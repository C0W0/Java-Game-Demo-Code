package dev.java.game.entities.creatures;


import dev.java.game.Handler;
import dev.java.game.gfx.Animation;
import dev.java.game.gfx.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //animations
    private Animation downAnim;
    private Animation upAnim;
    private Animation rightAnim;
    private Animation leftAnim;



    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 21;
        bounds.y = 30;
        bounds.width = 32;
        bounds.height = 32;

        //animation
        downAnim = new Animation(150, Assets.player_down);
        upAnim = new Animation(150, Assets.player_up);
        rightAnim = new Animation(150, Assets.player_right);
        leftAnim = new Animation(150, Assets.player_left);


    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    private BufferedImage getCurrentActionFrame(){
        if(yMove < 0){
            return upAnim.getCurrentFrame();
        } else if(xMove > 0){
            return rightAnim.getCurrentFrame();
        } else if(xMove < 0){
            return leftAnim.getCurrentFrame();
        } else if(yMove > 0){
            return downAnim.getCurrentFrame();
        } else {
            return Assets.player_neutral;
        }
    }


    @Override
    public void update() {

        //animation
        downAnim.update();
        upAnim.update();
        rightAnim.update();
        leftAnim.update();


        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentActionFrame(),(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}

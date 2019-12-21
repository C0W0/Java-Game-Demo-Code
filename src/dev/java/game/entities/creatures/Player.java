package dev.java.game.entities.creatures;


import dev.java.game.Handler;
import dev.java.game.gfx.Assets;

import java.awt.*;

public class Player extends Creature{


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 21;
        bounds.y = 30;
        bounds.width = 32;
        bounds.height = 32;
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

    @Override
    public void update() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.playerA,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
        graphics.setColor(Color.BLUE);
    }
}

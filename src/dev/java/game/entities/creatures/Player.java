package dev.java.game.entities.creatures;


import dev.java.game.Handler;
import dev.java.game.entities.Entity;
import dev.java.game.gfx.Animation;
import dev.java.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //animations
    private Animation downAnim;
    private Animation upAnim;
    private Animation rightAnim;
    private Animation leftAnim;
    //attack speed
    private long lastAttackTime, attackCooldown, attackTimer;



    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 21;
        bounds.y = 30;
        bounds.width = 32;
        bounds.height = 32;

        //attack timer
        attackCooldown = 800;
        attackTimer = attackCooldown;

        //animation
        downAnim = new Animation(150, Assets.player_down);
        upAnim = new Animation(150, Assets.player_up);
        rightAnim = new Animation(150, Assets.player_right);
        leftAnim = new Animation(150, Assets.player_left);


    }

    private void checkAttacks(){

        attackTimer += System.currentTimeMillis() - lastAttackTime;
        lastAttackTime = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }

        Rectangle collisionBox = getCollisionBounds(0,0);
        Rectangle attackRectangle = new Rectangle();
        int arSize = 20;
        attackRectangle.width = arSize;
        attackRectangle.height = arSize;

        if(handler.getKeyManager().aUp){
            attackRectangle.x = collisionBox.x + collisionBox.width/2 - arSize/2;
            attackRectangle.y = collisionBox.y - arSize;
        } else if(handler.getKeyManager().aDown){
            attackRectangle.x = collisionBox.x + collisionBox.width/2 - arSize/2;
            attackRectangle.y = collisionBox.y + collisionBox.height;
        } else if(handler.getKeyManager().aLeft){
            attackRectangle.x = collisionBox.x - arSize;
            attackRectangle.y = collisionBox.y + collisionBox.height/2 - arSize/2;
        } else if(handler.getKeyManager().aRight){
            attackRectangle.x = collisionBox.x + collisionBox.width;
            attackRectangle.y = collisionBox.y + collisionBox.height/2 - arSize/2;
        }else{
            return;
        }

        attackTimer = 0;

        for(int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++) { // this needs to be changed to a more efficient method
            Entity e = handler.getWorld().getEntityManager().getEntities().get(i);
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(attackRectangle)) {
                e.receiveDamage(1);
                return;
            }
        }
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

        //movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //attack
        checkAttacks();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentActionFrame(),(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {
        System.out.println("You lose");
    }

}

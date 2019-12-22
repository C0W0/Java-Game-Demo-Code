package dev.java.game.entities;

import dev.java.game.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Entity {

    //Entities
    protected float x,y;
    protected Handler handler;
    protected int width, height; //the size of the entity
    protected Rectangle bounds; //collision detection

    public Entity (Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);//default
    }

    public abstract void update();

    public abstract void render(Graphics graphics);


    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean checkEntityCollision(float xOffset, float yOffset){
        for(int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++){ // this needs to be changed to a more efficient method
            Entity e = handler.getWorld().getEntityManager().getEntities().get(i);
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }
        return false;
    }

    //Getters and Setters

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    //


}

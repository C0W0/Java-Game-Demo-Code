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
    //^^^^^


}

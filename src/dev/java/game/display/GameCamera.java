package dev.java.game.display;

import dev.java.game.Game;
import dev.java.game.entities.Entity;

public class GameCamera {

    private float xOffset, yOffset;
    private Game game;

    public GameCamera(Game game, float xOffset, float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - (float)game.getWidth()/2 + (float)e.getWidth() /2;
        yOffset = e.getY() - (float)game.getHeight()/2 + (float)e.getHeight() /2;
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }

    //getters and setters
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}

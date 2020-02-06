package dev.java.game.entities.creatures.npc;

import dev.java.game.Handler;

import java.awt.Rectangle;
import java.awt.Graphics;

public class NPC1 extends NPC {

    public NPC1(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void receiveDamage(int num) {}

    @Override
    protected void interact() {
        assignMission(1);
    }

    @Override
    protected void assignMission(int missionID) {

    }

    @Override
    public void update() {
        if(interactionCheck()){
            interact();
        }
    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void die() {

    }
}

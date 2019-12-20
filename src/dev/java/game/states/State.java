package dev.java.game.states;

import dev.java.game.Game;

import java.awt.Graphics;

public abstract class State {

    private static State currentState = null;

    //States

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    //getters and setters

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }

}

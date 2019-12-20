package dev.java.game;

public class Launcher {

    public static void main(String[] args){
        Game game = new Game("My Game",1024,768);
        game.start();
    }
}

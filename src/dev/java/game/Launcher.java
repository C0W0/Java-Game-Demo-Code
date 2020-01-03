package dev.java.game;

import dev.java.game.utils.Utils;

public class Launcher {

    private static int width, height, fps;

    public static void main(String[] args){
        String file = Utils.loadFileAsString("res/settings/settings.set");
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        fps = Utils.parseInt(tokens[2]);
        Game game = new Game("My Game",width,height,fps);
        game.start();
    }

}

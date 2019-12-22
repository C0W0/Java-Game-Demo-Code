package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.worlds.World;

import java.awt.Graphics;

public class GameState extends State {

    //private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/world1.wld");
        handler.setWorld(world);

    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }
}

package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.sdk.MapEditor;
import dev.java.game.worlds.World;

import java.awt.Graphics;

public class SDKState extends State {

    private World world;
    private MapEditor mapEditor;

    public SDKState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/worldSDK.wld");
        handler.setWorld(world);
        mapEditor = new MapEditor(handler);
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

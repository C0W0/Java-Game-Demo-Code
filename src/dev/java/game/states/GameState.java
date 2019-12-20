package dev.java.game.states;

import dev.java.game.entities.creatures.Player;
import dev.java.game.Handler;
import dev.java.game.tiles.Tile;
import dev.java.game.worlds.World;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/world1.wld");
        handler.setWorld(world);
        player = new Player(handler,world.getSpawnX()*Tile.TILEWIDTH,world.getSpawnY()*Tile.TILEHEIGHT);

    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        player.render(graphics);
    }
}

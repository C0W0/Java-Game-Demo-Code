package dev.java.game.states;

import dev.java.game.entities.creatures.Player;
import dev.java.game.Game;
import dev.java.game.tiles.Tile;
import dev.java.game.worlds.World;

import java.awt.Graphics;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game){
        super(game);
        world = new World("res/worlds/world1.txt");
        player = new Player(game,world.getSpawnX()*64,world.getSpawnY()*64);
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

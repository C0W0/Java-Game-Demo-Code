package dev.java.game.entities.statics;

import dev.java.game.Handler;
import dev.java.game.gfx.Assets;
import dev.java.game.tiles.Tile;

import java.awt.Graphics;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}

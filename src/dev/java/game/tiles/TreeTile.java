package dev.java.game.tiles;

import dev.java.game.gfx.Assets;

public class TreeTile extends Tile {

    public TreeTile(int id) {
        super(Assets.tree, id);
    }

    @Override
    public boolean isBarrier() {
        return true;
    }
}

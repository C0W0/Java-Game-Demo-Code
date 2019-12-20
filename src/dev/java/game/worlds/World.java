package dev.java.game.worlds;

import dev.java.game.Game;
import dev.java.game.tiles.Tile;
import dev.java.game.utils.Utils;

import java.awt.Graphics;

public class World {

    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int [][] worldTiles;//a 2d array which associates the type of tiles to the location (x,y)

    public World(Game game, String path){
        loadWorld(path);
        this.game = game;
    }

    private void loadWorld(String path){
        //loading the world file
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        worldTiles = new int[width][height];

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                worldTiles[x][y] = Utils.parseInt(tokens[x + y * width + 4]);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[worldTiles[x][y]];//get the tile type located at (x,y)
        if(t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    public void update(){

    }

    public void render(Graphics graphics){

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x,y).render(graphics,x * Tile.TILEWIDTH,y * Tile.TILEHEIGHT);
            }
        }

    }


    //getters and setters


    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}

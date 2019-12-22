package dev.java.game.worlds;

import dev.java.game.Handler;
import dev.java.game.entities.EntityManager;
import dev.java.game.entities.creatures.Player;
import dev.java.game.entities.statics.Tree;
import dev.java.game.tiles.Tile;
import dev.java.game.utils.Utils;

import java.awt.Graphics;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int [][] worldTiles;//a 2d array which associates the type of tiles to the location (x,y)

    //entities
    private EntityManager entityManager;

    public World(Handler handler, String path){
        loadWorld(path);

        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,spawnX*Tile.TILEWIDTH,spawnY*Tile.TILEHEIGHT));
        entityManager.addEntity(new Tree(handler, 100, 250));
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
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.dirtTile;
        }

        Tile t = Tile.tiles[worldTiles[x][y]];//get the tile type located at (x,y)
        if(t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    public void update(){

        entityManager.update();

    }

    public void render(Graphics graphics){

        int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0,handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x,y).render(graphics,(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }

        entityManager.render(graphics);

    }


    //getters and setters


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

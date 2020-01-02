package dev.java.game.worlds;

import dev.java.game.Handler;
import dev.java.game.entities.EntityManager;
import dev.java.game.entities.creatures.Player;
import dev.java.game.entities.statics.Tree;
import dev.java.game.items.ItemManager;
import dev.java.game.tiles.Tile;
import dev.java.game.utils.Utils;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int [][] worldTiles;//a 2d array which associates the type of tiles to the location (x,y)

    //entities
    private EntityManager entityManager;
    private Player player;

    //items
    private ItemManager itemManager;

    //SDK stuff
    private File mapFile;
    private String path;
    private int sdkTileID;

    public World(Handler handler, String path){
        loadWorld(path);
        //SDK stuff
        mapFile = new File(path);
        this.path = path;
        sdkTileID = 0;
        //

        player = new Player(handler,spawnX*Tile.TILEWIDTH,spawnY*Tile.TILEHEIGHT);
        this.handler = handler;
        entityManager = new EntityManager(handler, player);
        itemManager = new ItemManager(handler);

//        entityManager.addEntity(new Tree(handler, 100, 250));
//        entityManager.addEntity(new Tree(handler, 200, 250));
//        entityManager.addEntity(new Tree(handler, 350, 400));
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
        itemManager.update();

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

        itemManager.render(graphics);
        entityManager.render(graphics);

    }

    //SDK stuff

    public void setTile(int tileX, int tileY){

        if(worldTiles[tileX][tileY] == sdkTileID){
            return;
        }
        worldTiles[tileX][tileY] = sdkTileID;

    }

    public void resetTile(int tileX, int tileY){

        String[] tokens = Utils.loadFileAsString(path).split("\\s+");

        int[][] savedTiles = new int[width][height];

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                savedTiles[x][y] = Utils.parseInt(tokens[x + y * width + 4]);
            }
        }

        if(worldTiles[tileX][tileY] == savedTiles[tileX][tileY]){
            return;
        }
        worldTiles[tileX][tileY] = savedTiles[tileX][tileY];

    }

    public void saveMap(){

        if(mapFile.exists()){
            mapFile.delete();
        }

        try {
            mapFile.createNewFile();
            PrintWriter printWriter = new PrintWriter(mapFile);
            printWriter.println(width+" "+height);
            printWriter.println(spawnX+" "+spawnY);

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                   printWriter.print(worldTiles[x][y]+" ");
                }
                printWriter.println();
            }
            printWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setSDKTile(int id){
        sdkTileID = id;
    }

    public void generateNewMap(int width, int height, int spawnX, int spawnY){

        if(mapFile.exists()){
            mapFile.delete();
        }

        try {
            mapFile.createNewFile();
            PrintWriter printWriter = new PrintWriter(mapFile);
            printWriter.println(width+" "+height);
            printWriter.println(spawnX+" "+spawnY);

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    printWriter.print(sdkTileID+" ");
                }
                printWriter.println();
            }
            printWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        loadWorld(path);
        player.setX(spawnX*Tile.TILEWIDTH);
        player.setY(spawnY*Tile.TILEHEIGHT);
    }

    //

    //getters and setters
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }
}

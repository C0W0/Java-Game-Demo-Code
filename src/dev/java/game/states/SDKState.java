package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.tiles.Tile;
import dev.java.game.worlds.World;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class SDKState extends State {

    private World world;

    public SDKState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/worldSDK.wld");
        handler.setWorld(world);

    }

    private void leftClick(int x, int y){
        x = (int)((x+handler.getGameCamera().getxOffset()) / Tile.TILEWIDTH);
        y = (int)((y+handler.getGameCamera().getyOffset()) / Tile.TILEHEIGHT);
        handler.getWorld().setTile(x, y, 0);
    }

    private void rightClick(int x, int y){
        x = (int)((x+handler.getGameCamera().getxOffset()) / Tile.TILEWIDTH);
        y = (int)((y+handler.getGameCamera().getyOffset()) / Tile.TILEHEIGHT);
        handler.getWorld().resetTile(x, y);
    }

    @Override
    public void update() {
        world.update();
        
        boolean isLeftPressed = handler.getMouseManager().isLeftPressed();
        if(isLeftPressed){
            leftClick(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
        }
        boolean isRightPressed = handler.getMouseManager().isRightPressed();
        if(isRightPressed){
            rightClick(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
        }

        if(handler.getKeyManager().ctrl){

            if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
                world.saveMap();
                System.out.println("save");
            }

        }
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
    }
}

package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.gfx.Assets;
import dev.java.game.tiles.Tile;
import dev.java.game.ui.MapEditorButton;
import dev.java.game.ui.UIManager;
import dev.java.game.ui.clicker.TileEditingClicker;
import dev.java.game.worlds.World;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class SDKState extends State {

    private World world;
    private UIManager uiManager;
    private boolean isHovering;

    public SDKState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/worldSDK.wld");
        handler.setWorld(world);
        uiManager = handler.getUIManager();
    }

    private void leftClick(int x, int y){
        x = (int)((x+handler.getGameCamera().getxOffset()) / Tile.TILEWIDTH);
        y = (int)((y+handler.getGameCamera().getyOffset()) / Tile.TILEHEIGHT);
        handler.getWorld().setTile(x, y);
    }

    private void rightClick(int x, int y){
        x = (int)((x+handler.getGameCamera().getxOffset()) / Tile.TILEWIDTH);
        y = (int)((y+handler.getGameCamera().getyOffset()) / Tile.TILEHEIGHT);
        handler.getWorld().resetTile(x, y);
    }

    @Override
    public void update() {
        world.update();
        uiManager.update();

        for(int i = 0; i < uiManager.getUiObjects().size(); i++){
            if(uiManager.getUiObjects().get(i).isHovering()){
                isHovering = true;
            }
        }

        boolean isLeftPressed = handler.getMouseManager().isLeftPressed();
        if(isLeftPressed && !isHovering){
            leftClick(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
        }
        boolean isRightPressed = handler.getMouseManager().isRightPressed();
        if(isRightPressed && !isHovering){
            rightClick(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
        }

        if(handler.getKeyManager().ctrl){

            if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
                world.saveMap();
            }

        }
        isHovering = false;
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        uiManager.render(graphics);
    }

    @Override
    public void init() {
        uiManager.addUIObject(new MapEditorButton(16,16,32,32,Assets.grass_SDK,new TileEditingClicker(handler, 0),true));
        uiManager.addUIObject(new MapEditorButton(16,48,32,32,Assets.dirt_SDK,new TileEditingClicker(handler, 2),false));
    }
}

package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.gfx.Assets;
import dev.java.game.ui.Slider;
import dev.java.game.tiles.Tile;
import dev.java.game.ui.MapEditorButton;
import dev.java.game.ui.UIImageButton;
import dev.java.game.ui.UIManager;
import dev.java.game.ui.clicker.MapSizingClicker;
import dev.java.game.ui.clicker.TileEditingClicker;
import dev.java.game.worlds.World;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class SDKState extends State {

    private World world;
    private UIManager uiManager;
    private boolean isHovering;
    private Slider heightSlider, widthSlider, spawnXSlider, spawnYSlider;

    public SDKState(Handler handler){
        super(handler);
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
        if(world != null) {
            world.update();
        }

        uiManager.update();

        for(int i = 0; i < uiManager.getUiObjects().size(); i++){
            if(uiManager.getUiObjects().get(i).isHovering() && uiManager.getUiObjects().get(i).isActive()){
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
        if(world!= null){
            world.render(graphics);
        }
        if(heightSlider != null && widthSlider != null){
            heightSlider.render(graphics);
            widthSlider.render(graphics);
        }
        uiManager.render(graphics);
    }

    @Override
    public void init() {
        world = new World(handler,"res/worlds/worldSDK.wld");
        handler.setWorld(world);
        heightSlider = new Slider(64,32,256,32,100,0,10,"height:");
        widthSlider = new Slider(64,96,256,32,100,0,10,"width:");
        spawnXSlider = new Slider(336,32,64,16,100,0,10,"spawn x:");
        spawnYSlider = new Slider(336,96,64,16,100,0,10,"spawn y:");
        uiManager.addUIObject(new MapEditorButton(16,16,32,32,Assets.grass_SDK,new TileEditingClicker(handler, 0),true));
        uiManager.addUIObject(new MapEditorButton(16,48,32,32,Assets.grassStone_SDK,new TileEditingClicker(handler, 1),false));
        uiManager.addUIObject(new MapEditorButton(16,80,32,32,Assets.dirt_SDK,new TileEditingClicker(handler, 2),false));
        uiManager.addUIObject(new MapEditorButton(16,112,32,32,Assets.dirtStone_SDK,new TileEditingClicker(handler, 3),false));
        uiManager.addUIObject(new UIImageButton(80,8,64,32,Assets.button_new,new MapSizingClicker(handler,widthSlider,heightSlider,spawnXSlider,spawnYSlider)));
        uiManager.addUIObject(heightSlider);
        uiManager.addUIObject(widthSlider);
        uiManager.addUIObject(spawnXSlider);
        uiManager.addUIObject(spawnYSlider);
        heightSlider.setActive();
        widthSlider.setActive();
        spawnXSlider.setActive();
        spawnYSlider.setActive();
    }

    //getter and setters
    public Slider getHeightSlider() {
        return heightSlider;
    }

    public Slider getWidthSlider() {
        return widthSlider;
    }
}

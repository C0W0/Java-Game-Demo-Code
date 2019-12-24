package dev.java.game.states;

import dev.java.game.Handler;
import dev.java.game.gfx.Assets;
import dev.java.game.ui.ClickListener;
import dev.java.game.ui.GameStartClicker;
import dev.java.game.ui.UIImageButton;
import dev.java.game.ui.UIManager;

import java.awt.Graphics;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        ClickListener gameStartClicker = new GameStartClicker(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addUIObject(new UIImageButton(300, 300, 128, 64, Assets.button_start, gameStartClicker));
    }

    @Override
    public void update(){
        uiManager.update();
    }

    @Override
    public void render(Graphics graphics) {
        uiManager.render(graphics);
    }
}

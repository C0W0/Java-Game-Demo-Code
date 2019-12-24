package dev.java.game.ui;

import dev.java.game.Handler;
import dev.java.game.states.State;

public class GameStartClicker implements ClickListener {

    private Handler handler;

    public GameStartClicker(Handler handler){
        this.handler = handler;
    }

    @Override
    public void onClick() {
        State.setState(handler.getGame().gameState);
        handler.getMouseManager().setUiManager(null);
    }
}

package dev.java.game.ui;

import dev.java.game.Handler;
import dev.java.game.states.State;

import java.util.ArrayList;

public class StateSwitchingClicker implements ClickListener {

    private Handler handler;
    private State state;
    private ArrayList<UIObject> uiObjects;

    public StateSwitchingClicker(Handler handler, State state){
        this.handler = handler;
        this.state = state;
        uiObjects = handler.getMouseManager().getUiManager().getUiObjects();
    }

    @Override
    public void onClick() {
        State.setState(state);
        //handler.getMouseManager().setUiManager(null);
        for(int i = 0; i < uiObjects.size(); i++){
            handler.getMouseManager().getUiManager().removeUIObject(handler.getMouseManager().getUiManager().getUiObjects().get(1));
        }
    }
}

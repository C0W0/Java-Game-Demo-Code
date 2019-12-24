package dev.java.game.ui;

import dev.java.game.Handler;
import dev.java.game.states.State;

public class StateSwitchingClicker implements ClickListener {

    private Handler handler;
    private State state;

    public StateSwitchingClicker(Handler handler, State state){
        this.handler = handler;
        this.state = state;
    }

    @Override
    public void onClick() {
        State.setState(state);
        handler.getMouseManager().setUiManager(null);
    }
}

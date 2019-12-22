package dev.java.game;

import dev.java.game.display.Display;
import dev.java.game.gfx.Assets;
import dev.java.game.display.GameCamera;
import dev.java.game.input.KeyManager;
import dev.java.game.states.GameState;
import dev.java.game.states.MenuState;
import dev.java.game.states.SettingsState;
import dev.java.game.states.State;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private FPSTimer timer;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    //input
    private KeyManager keyManager;

    //camera
    private GameCamera gameCamera;

    //handler
    private Handler handler;

    //states
    private State gameState;
    private State menuState;
    private State settingsState;

    private int width, height;
    public String title;


    private boolean running = false;


    public Game(String title,int width,int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        timer = new FPSTimer(60);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);
        State.setState(gameState);
    }

    private void update(){

        keyManager.update();

        if(State.getCurrentState() != null){
            State.getCurrentState().update();
        }
    }

    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0,0,width,height); //clear the screen
        //Draw Below

        if(State.getCurrentState() != null){
            State.getCurrentState().render(graphics);
        }

        //End Drawing
        bufferStrategy.show();
        graphics.dispose();
    }

    public void run(){

        init();

        while(running){

                if (timer.check()){
                update();
                render();
            }

        }
        stop();
    }


    public synchronized void start(){
        if(running){
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running){
            return;
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //getters and setters
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

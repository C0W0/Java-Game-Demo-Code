package dev.java.game.entities;

import dev.java.game.Handler;
import dev.java.game.entities.creatures.Player;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void update(){

        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.update();
        }
        player.update();

    }

    public void render(Graphics graphics){

        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.render(graphics);
        }
        player.render(graphics);

    }

    //getters and setters
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

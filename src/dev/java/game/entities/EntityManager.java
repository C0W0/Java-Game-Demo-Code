package dev.java.game.entities;

import dev.java.game.Handler;
import dev.java.game.entities.creatures.Player;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    private Comparator<Entity> renderComparator = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
                return -1;
            }
            return 1;
        }
    };


    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void update(){

        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.update();
            if(!e.isActive()){
                entities.remove(e);
            }
        }
        entities.sort(renderComparator);

    }

    public void render(Graphics graphics){

        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.render(graphics);
        }

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

package dev.java.game.inventory;

import dev.java.game.Handler;
import dev.java.game.items.Item;

import java.awt.Graphics;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler){
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    public void update(){
        if(handler.getKeyManager().keyJustPressed(VK_I)){
            active = !active;
        }
        if(!active){
            return;
        }
        
    }

    public void render(Graphics graphics){
        if(!active){
            return;
        }

    }

    //inventory methods
    public void addItem(Item item){
        for(int i = 0; i < inventoryItems.size(); i++){
            Item tempItem = inventoryItems.get(i);
            if(tempItem.getId() == item.getId()){
                inventoryItems.get(i).setCount(tempItem.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }


    //getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}

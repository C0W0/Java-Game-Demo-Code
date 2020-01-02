package dev.java.game.ui;

import dev.java.game.gfx.Assets;
import dev.java.game.gfx.Text;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;


public class Slider extends UIObject{

    private int max, min, tickSpacing;
    private int value;
    private String name, label;

    public Slider(int x, int y, int width, int height, int max, int min, int tickSpacing, String name){
        super((float)x,(float)y,width,height);
        this.name = name;
        this.max = max;
        this.min = min;
        this.tickSpacing = tickSpacing;
        value = (max+min)/2;
        label = (name+value);
    }

    @Override
    public void update(){
        if(!active){
            return;
        }
        label = (name+value);
    }

    @Override
    public void onMouseRelease(MouseEvent e) {
        if(!active){
            return;
        }
        if(hovering){
            value = (int)((e.getX()-x)/width*max+0.5);
            if(value < min){
                value = min;
            } else if(value > max){
                value = max;
            }
        }
    }

    @Override
    public void render(Graphics graphics){
        if(!active){
            return;
        }
        graphics.drawImage(Assets.slideTrack,(int)x,(int)y,width,height,null);
        for(int i = 0; i <= max/tickSpacing; i++){
            graphics.drawImage(Assets.tickMark,(int)((float)i*tickSpacing/100*width+x),(int)y,height/2,height,null);
        }
        graphics.drawImage(Assets.slider,(int)((float)value/max*width+x),(int)y,height,height,null);
        Text.drawString(graphics,label,(int)(x+width/2),(int)(y+height+10),true,Color.black, Assets.font20);
    }

    @Override
    public void onClick() {

    }

    //getters and setters
    public int getValue() {
        return value;
    }
}

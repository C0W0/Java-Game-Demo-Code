package dev.java.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {


    private static final int width = 64;
    private static final int height = 64;

    public static BufferedImage playerA,playerB,grass,grassStone,tree,dirt,dirtStone;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet.png"));

        playerA = sheet.crop(0, 0,width,height);
        playerB = sheet.crop(width, 0,width,height);
        grass = sheet.crop(width*2, 0,width,height);
        grassStone = sheet.crop(width*3,0,width,height);
        tree = sheet.crop(0,height,width,height);
        dirt = sheet.crop(width,height,width,height);
        dirtStone = sheet.crop(width*2,height,width,height);
    }

}

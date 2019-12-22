package dev.java.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {


    private static final int width = 64;
    private static final int height = 64;

    public static BufferedImage player_neutral, grass,grassStone,tree,dirt,dirtStone;

    public static BufferedImage [] player_down;
    public static BufferedImage [] player_up;
    public static BufferedImage [] player_left;
    public static BufferedImage [] player_right;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet.png"));

        player_down = new BufferedImage[2];
        player_down[0] = sheet.crop(0,0,width,height);
        player_down[1] = sheet.crop(width,0,width,height);
        player_up = new BufferedImage[2];
        player_up[0] = sheet.crop(width*2,0,width,height);
        player_up[1] = sheet.crop(width*3,0,width,height);
        player_right = new BufferedImage[2];
        player_right[0] = sheet.crop(0,height,width,height);
        player_right[1] = sheet.crop(width,height,width,height);
        player_left = new BufferedImage[2];
        player_left[0] = sheet.crop(width*2,height,width,height);
        player_left[1] = sheet.crop(width*3,height,width,height);
        player_neutral = sheet.crop(0,height*2,width,height);

        grass = sheet.crop(width, height*2,width,height);
        grassStone = sheet.crop(width*2,height*2,width,height);
        tree = sheet.crop(width*3,height*2,width,height);
        dirt = sheet.crop(0,height*3,width,height);
        dirtStone = sheet.crop(width,height*3,width,height);
    }

}

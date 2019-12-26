package dev.java.game.gfx;

import java.awt.image.BufferedImage;
import java.util.Base64;

public class Assets {


    private static final int width = 64;
    private static final int height = 64;

    public static BufferedImage grass,grassStone,tree,dirt,dirtStone;

    public static BufferedImage wood;

    public static BufferedImage player_neutral;
    public static BufferedImage [] player_down, player_up, player_left, player_right;
    public static BufferedImage [] attack_down, attack_up, attack_left, attack_right;

    public static BufferedImage [] button_start;
    public static BufferedImage [] button_settings;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet1.png"));


        button_start = new BufferedImage[2];
        button_start[0] = sheet1.crop(0,0,width*2,height);
        button_start[1] = sheet1.crop(width*2,0,width*2,height);
        button_settings = new BufferedImage[2];
        button_settings[0] = sheet1.crop(width*4,0,width*2,height);
        button_settings[1] = sheet1.crop(width*6,0,width*2,height);

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

        attack_down = new BufferedImage[3];
        attack_down[0] = sheet.crop(width,height*2,width,height);
        attack_down[1] = sheet.crop(width,height*2,width,height);
        attack_down[1] = sheet.crop(width,height*2,width,height);
        attack_up = new BufferedImage[3];
        attack_up[0] = sheet.crop(width*2,height*2,width,height);
        attack_up[1] = sheet.crop(width*2,height*2,width,height);
        attack_up[2] = sheet.crop(width*2,height*2,width,height);
        attack_right = new BufferedImage[3];
        attack_right[0] = sheet.crop(width*3,height*2,width,height);
        attack_right[1] = sheet.crop(width*3,height*2,width,height);
        attack_right[2] = sheet.crop(width*3,height*2,width,height);
        attack_left = new BufferedImage[3];
        attack_left[0] = sheet.crop(0,height*3,width,height);
        attack_left[1] = sheet.crop(0,height*3,width,height);
        attack_left[2] = sheet.crop(0,height*3,width,height);

        grass = sheet1.crop(width*2, height,width,height);
        grassStone = sheet1.crop(width*3,height,width,height);
        tree = sheet1.crop(width*4,height,width,height);
        dirt = sheet1.crop(width*5,height,width,height);
        dirtStone = sheet1.crop(width*6,height,width,height);

        wood = sheet1.crop(width*7,height,width,height);
    }

}

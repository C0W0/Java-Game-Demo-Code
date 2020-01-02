package dev.java.game.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.Base64;

public class Assets {


    private static final int width = 64;
    private static final int height = 64;

    public static Font font28, font20;

    public static BufferedImage grass,grassStone,tree,dirt,dirtStone;
    public static BufferedImage pathVertical, pathHorizontal, pathCornerUpRight, pathCornerUpLeft, pathCornerDownLeft, pathCornerDownRight;

    public static BufferedImage wood;

    public static BufferedImage player_neutral;
    public static BufferedImage [] player_down, player_up, player_left, player_right;
    public static BufferedImage [] attack_down, attack_up, attack_left, attack_right;

    public static BufferedImage [] button_start;
    public static BufferedImage [] button_settings;

    //SDK stuff
    public static BufferedImage slideTrack, slider, tickMark;
    public static BufferedImage [] button_SDK, button_new, button_save;
    public static BufferedImage [] grass_SDK, grassStone_SDK, dirt_SDK, dirtStone_SDK, pathV_SDK, pathH_SDK, pathUpRight_SDK, pathUpLeft_SDK, pathDownRight_SDK, pathDownLeft_SDK;
    //

    public static BufferedImage inventoryScreen;

    public static void init(){
        font28 = FontLoader.loadFont("res/fonts/BLKCHCRY.ttf", 28);
        font20 = FontLoader.loadFont("res/fonts/BLKCHCRY.ttf", 20);

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/texture/SpriteSheet1.png"));
        SpriteSheet townTiles = new SpriteSheet(ImageLoader.loadImage("/texture/RemixTownTiles.png"));


        inventoryScreen = ImageLoader.loadImage("/texture/InventoryScreen.png");

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

        grass = townTiles.crop(0,height,width,height);
        grassStone = sheet1.crop(width*3,height,width,height);
        tree = townTiles.crop(width*5,height*3,width,height*2);
        dirt = townTiles.crop(width,height,width,height);
        dirtStone = sheet1.crop(width*6,height,width,height);

        pathVertical = townTiles.crop(width*2,height,width,height);
        pathHorizontal = townTiles.crop(width*2,height*2,width,height);
        pathCornerUpRight = townTiles.crop(width,height*2,width,height);
        pathCornerUpLeft = townTiles.crop(width,height*3,width,height);
        pathCornerDownLeft = townTiles.crop(0,height*3,width,height);
        pathCornerDownRight = townTiles.crop(width*2,height*3,width,height);

        wood = sheet1.crop(width*7,height,width,height);

        //SDK stuff
        button_SDK = new BufferedImage[2];
        button_SDK[0] = sheet1.crop(0,height,width*2,height);
        button_SDK[1] = sheet1.crop(0,height*2,width*2,height);

        button_new = new BufferedImage[2];
        button_new[0] = sheet1.crop(0,height*4,width*2,height);
        button_new[1] = sheet1.crop(width*2,height*4,width*2,height);
        button_save = new BufferedImage[2];
        button_save[0] = sheet1.crop(width*3,height*3,width*2,height);
        button_save[1] = sheet1.crop(width*5,height*3,width*2,height);


        slideTrack = sheet1.crop(width*4,height*4,width*2,height);
        slider = sheet1.crop(width*6,height*4,width,height);
        tickMark = sheet1.crop(width*7,height*4,width,height);

        grass_SDK = new BufferedImage[2];
        grass_SDK[0] = grass;
        grass_SDK[1] = sheet1.crop(width*2,height*2,width,height);
        grassStone_SDK = new BufferedImage[2];
        grassStone_SDK[0] = grassStone;
        grassStone_SDK[1] = sheet1.crop(width*2,height,width,height);
        dirt_SDK = new BufferedImage[2];
        dirt_SDK[0] = dirt;
        dirt_SDK[1] = sheet1.crop(width*3,height*2,width,height);
        dirtStone_SDK = new BufferedImage[2];
        dirtStone_SDK[0] = dirtStone;
        dirtStone_SDK[1] = sheet1.crop(width*5,height,width,height);
        pathV_SDK = new BufferedImage[2];
        pathV_SDK[0] = pathVertical;
        pathV_SDK[1] = sheet1.crop(width*4,height*2,width,height);
        pathH_SDK = new BufferedImage[2];
        pathH_SDK[0] = pathHorizontal;
        pathH_SDK[1] = sheet1.crop(width*5,height*2,width,height);
//        pathUpRight_SDK = new BufferedImage[2];
//        pathUpLeft_SDK = new BufferedImage[2];
//        pathDownRight_SDK = new BufferedImage[2];
//        pathDownLeft_SDK = new BufferedImage[2];
        //
    }

}

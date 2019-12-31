package dev.java.game.display;

import javax.swing.JFrame;
import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferInt;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width;
    private int height;

    //private BufferedImage view;
    //private int[] pixels;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        //view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize((new Dimension(width,height)));
        canvas.setMaximumSize((new Dimension(width,height)));
        canvas.setMinimumSize((new Dimension(width,height)));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }



    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

}

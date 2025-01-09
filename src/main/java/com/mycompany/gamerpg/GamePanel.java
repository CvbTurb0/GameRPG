package com.mycompany.gameRPG;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; //Might not need? not sure.
    
    int screenWidth = 1300;
    int screenHeight = 768;
    
    Thread gameThread;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
    }

    int fps = 60;
    double lastTime = System.nanotime();
    double currentTime;
    @Override //Delta Time
    public void run() {
        currentTime = System.nanotime();
        if ((currentTime - lastTime)/1e9/fps >= 1){
            lastTime = currentTime;

            this.update();

            this.repaint();
            //TODO
            //Add in the update and repaint functions
         }
    }
}

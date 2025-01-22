package com.mycompany.GameRPG;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import com.mycompany.Listeners.MouseCListener;
import com.mycompany.Listeners.MouseMListener;
import com.mycompany.ImageHandlers.ImageSetup;


public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; //Might not need? not sure.
    
    int screenWidth = 60 * 16;
    int screenHeight = 60 * 9;
    
    

    Thread gameThread;
    //Classes
    ImageSetup ImageSetup = new ImageSetup(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

        MouseCListener MouseCListener = new MouseCListener();
        MouseMListener MouseMListener = new MouseMListener();

        this.addMouseListener(MouseCListener);
        this.addMouseMotionListener(MouseMListener);
        gameThread = new Thread(this);
        gameThread.start();
    }

    int fps = 60;
    double lastTime = System.nanoTime();
    double currentTime;
    double anotherLastTime = System.nanoTime();
    double frames = 0;

    @Override //Delta Time
    public void run() {
        Setup();
        while (gameThread.isAlive()){    
            currentTime = System.nanoTime();
            if ((currentTime - lastTime)/1e9 >= 1.0/fps){ 
                frames++;
                if((currentTime - anotherLastTime)/1e9 >= 1){
                    System.out.println("FPS: " + frames);
                    frames = 0;
                    anotherLastTime = currentTime;
                }
                lastTime = currentTime;

                this.update();

                this.repaint();
                //TODO
                //Add in the update and repaint functions
                //Add in the key listener
            
            }
            
        }
    }
    public void Setup(){
        ImageSetup.setupImages();
    }
    public void update(){
        
    }
    int index = 0;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.black);
        g2.drawImage(ImageSetup.characterSpriteSheet[0][index/60], 64, 64, 64, 64, null);

        index++;
        if (index == ImageSetup.characterSpriteSheet[0].length*60){
            index = 0;
        }
       

    }
}

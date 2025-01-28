package com.mycompany.GameRPG;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import com.mycompany.Listeners.MouseCListener;
import com.mycompany.Listeners.MouseMListener;
import com.mycompany.Listeners.KeyPressListener;
import com.mycompany.ImageHandlers.ImageSetup;
import com.mycompany.ImageHandlers.EntityImageHandler;
import com.mycompany.EntityHandler.EntityDictionary;
import com.mycompany.EntityHandler.EntityHandler;
import com.mycompany.EntityHandler.PlayerManager;
import com.mycompany.Buttons.ButtonHandler;
import com.mycompany.Textboxes.TextboxHandler;
import com.mycompany.Cards.CardHandler;



public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; //Might not need? not sure.
    
    public int screenWidth = 60 * 16; //960
    public int screenHeight = 60 * 9; //540

    public int frameCount;
    public int frameDelay = 10;
    public int textDelay = 7;
    
    

    Thread gameThread;
    //Classes
    public ImageSetup imageSetup = new ImageSetup(this);
    EntityImageHandler entityImageH = new EntityImageHandler(this);    
    public EntityHandler entityH = new EntityHandler(this);
    public EntityDictionary entityD = new EntityDictionary();
    public ButtonHandler buttonH = new ButtonHandler(this);
    public PlayerManager playerM = new PlayerManager(this);
    public TextboxHandler textboxH = new TextboxHandler(this);
    public CardHandler cardH = new CardHandler(this);

    public StateManager stateM = new StateManager(this);

    public MouseCListener MouseCListener = new MouseCListener(this);
    public MouseMListener MouseMListener = new MouseMListener(this);
    public KeyPressListener KeyPressListener = new KeyPressListener(this);

    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(KeyPressListener);

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
        imageSetup.setupImages();
        entityH.setupEntities();
        entityD.setupDefaultAnimations();
        buttonH.setupButtons();
        textboxH.setup();
        cardH.setupCards();

    }
    public void update(){
        frameCount++;
        entityH.updateEntities();  
        buttonH.update(); 
        MouseCListener.update();
        KeyPressListener.update();
        textboxH.update();
        cardH.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.black);

    //  entityImageH.drawEntity(g2);
    // buttonH.drawButtons(g2);
        textboxH.drawTextbox(g2); //Probably should be on at all times
    
        switch(stateM.gameState){
            case "overworld":
                stateM.drawOverworld(g2);
                break;
            case "fight":
                stateM.drawFight(g2);
                break;

        }

    }
}

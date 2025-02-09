package com.mycompany.ImageHandlers;

import com.mycompany.GameRPG.GamePanel;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageSetup {
    
    GamePanel gp;
    public ImageSetup(GamePanel gp){
        this.gp = gp;
    }   
    public BufferedImage[][] characterSpriteSheet;
    public BufferedImage[][] enemySpriteSheet;
    public BufferedImage[][] buttonSpriteSheet;
    public BufferedImage[][] cardSpriteSheet;
    public Map<String, BufferedImage[][]> animationMap = new HashMap<>();
    SpriteSheetHandler ssh = new SpriteSheetHandler();
    public void setupImages(){
        System.out.println("Setting up images");
        characterSpriteSheet = ssh.loadSpriteSheet("/Pictures/characterSpriteSheet.png", 16, 16,16,16);
        enemySpriteSheet = ssh.loadSpriteSheet("/Pictures/enemySpriteSheet.png", 16, 16);
        buttonSpriteSheet = ssh.loadSpriteSheet("/Pictures/buttonSpriteSheet.png", 32, 32);
        cardSpriteSheet = ssh.loadSpriteSheet("/Pictures/cardSpriteSheet.png", 124, 185);

        animationMap.put("player", characterSpriteSheet);
        animationMap.put("chicken", enemySpriteSheet);
        animationMap.put("button", buttonSpriteSheet);
        animationMap.put("card", cardSpriteSheet);
    }
}


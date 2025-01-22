package com.mycompany.ImageHandlers;

import com.mycompany.GameRPG.GamePanel;
import java.awt.image.BufferedImage;

public class ImageSetup {
    
    GamePanel gp;
    public ImageSetup(GamePanel gp){
        this.gp = gp;
    }   
    public BufferedImage[][] characterSpriteSheet;
    public BufferedImage[][] enemySpriteSheet;

    SpriteSheetHandler ssh = new SpriteSheetHandler();
    public void setupImages(){
        System.out.println("Setting up images");
        characterSpriteSheet = ssh.loadSpriteSheet("src\\main\\Resources\\Pictures\\characterSpritesheet.png.png", 16, 16,16,16);
        //enemySpriteSheet = ssh.loadSpriteSheet("src/main/resources/enemySpriteSheet.png", 64, 64);
    }
}


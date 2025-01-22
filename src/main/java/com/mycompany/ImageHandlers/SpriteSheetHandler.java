package com.mycompany.ImageHandlers;

import com.mycompany.GameRPG.GamePanel; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class SpriteSheetHandler {

    
    BufferedImage bigSheet;

    public BufferedImage[][] loadSpriteSheet(String path, int width, int height, int xOffset, int yOffset){
        //TODO
        //ADD in offsets for the sprite sheet
        BufferedImage[][] spriteSheet = null;
        int x =0;
        int y =0;
        try{
            bigSheet = ImageIO.read(new File(path));
            System.out.println("Read");
            int rows = bigSheet.getHeight() / (height+yOffset*2);
            int cols = bigSheet.getWidth() / (width+xOffset*2);
            spriteSheet = new BufferedImage[rows][cols];
            for (int i = 0; i < rows; i++){
                x=0;
                y+=yOffset;
                for (int j = 0; j < cols; j++){
                    x+=xOffset;
                    spriteSheet[i][j] = bigSheet.getSubimage(j * width +x, i * height + y, width, height);
                    x+=xOffset;
                }
                y+=yOffset;
            }
        } catch (IOException e){
            System.out.println("Error loading sprite sheet");
        }
        return spriteSheet;

    }

    public BufferedImage[][] loadSpriteSheet(String path, int width, int height){
        //TODO
        //ADD in offsets for the sprite sheet
        BufferedImage[][] spriteSheet = null;
        try{
            bigSheet = ImageIO.read(new File(path));
            System.out.println("Read");
            int rows = bigSheet.getHeight() / height;
            int cols = bigSheet.getWidth() / width;
            spriteSheet = new BufferedImage[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    spriteSheet[i][j] = bigSheet.getSubimage(j * width, i * height, width, height);
                }
            }
        } catch (IOException e){
            System.out.println("Error loading sprite sheet");
        }
        return spriteSheet;

    }
}
package com.mycompany.ImageHandlers;

import com.mycompany.GameRPG.GamePanel;
import java.awt.Graphics2D;

public class EntityImageHandler {

    GamePanel gp;
    public EntityImageHandler(GamePanel gp){
        this.gp = gp;
    }
    public void drawEntity(Graphics2D g2){

        int x, y, width, height, frame;
        
        for(int i = 0; i < gp.entityH.entityList.length; i++){
            
            if(gp.entityH.entityList[i] == null){
                break;
            }
            else{
                x = (int) (gp.entityH.entityList[i].x);
                y = (int) (gp.entityH.entityList[i].y);
                width = gp.entityH.entityList[i].width;
                height = gp.entityH.entityList[i].height;
                frame = gp.entityH.entityList[i].animationIndex;
                if (i == gp.playerM.currentPlayerIndex){
                    g2.drawImage(gp.imageSetup.animationMap.get(gp.entityH.entityList[i].name)[gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation)][frame], gp.playerDrawPosX, gp.playerDrawPosY, width, height, null);
                }else{
                    g2.drawImage(gp.imageSetup.animationMap.get(gp.entityH.entityList[i].name)[gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation)][frame], modifyX(x), modifyY(y), width, height, null);

                }
            }

        }
    }
    public int modifyX(int x){
        
        int xPos = -1;
        
        xPos = (int) (x - gp.entityH.entityList[gp.playerM.currentPlayerIndex].x + gp.playerDrawPosX);

        return xPos;
    }
    public int modifyX(double x){
        
        int xPos = -1;
        
        xPos = (int) (x - gp.entityH.entityList[gp.playerM.currentPlayerIndex].x + gp.playerDrawPosX);

        return xPos;
    }
    public int modifyY(int y){
        
        int yPos = -1;
        
        yPos = (int) (y - gp.entityH.entityList[gp.playerM.currentPlayerIndex].y + gp.playerDrawPosY);

        return yPos;
    }
    public int modifyY(double y){
        
        int yPos = -1;
        
        yPos = (int) (y - gp.entityH.entityList[gp.playerM.currentPlayerIndex].y + gp.playerDrawPosY);

        return yPos;
    }
}

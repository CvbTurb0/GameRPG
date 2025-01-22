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
            
                if(gp.entityH.entityList[i].name.equals("player")){
                    g2.drawImage(gp.imageSetup.characterSpriteSheet[gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation)][frame], x, y, width, height, null);
                }
                else if(gp.entityH.entityList[i].name.equals("chicken")){
                    g2.drawImage(gp.imageSetup.enemySpriteSheet[gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation)][frame], x, y, width, height, null);
                    //System.out.println(gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation));
                }
                else
                    g2.drawImage(gp.imageSetup.characterSpriteSheet[gp.entityD.entityMap.get(gp.entityH.entityList[i].name).get(gp.entityH.entityList[i].animation)][frame], x, y, width, height, null);
            }
        }

    }
}

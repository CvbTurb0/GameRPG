package com.mycompany.EntityHandler;

import com.mycompany.GameRPG.GamePanel;

public class PlayerManager {

    GamePanel gp;
    public PlayerManager(GamePanel gp){
        this.gp = gp;
    }
    public void move(double xChange, double yChange){
        //Normalize
        if (xChange == 1 && yChange == 1){
            xChange *= 0.7071;
            yChange *= 0.7071;
        }
        //Change position
        gp.entityH.entityList[0].x += xChange * gp.entityH.entityList[0].speed;
        gp.entityH.entityList[0].y += yChange * gp.entityH.entityList[0].speed;

        //Change Directions
        if (xChange > 0){
            gp.entityH.entityList[0].direction = 1; //Right
        }else if (xChange < 0){ 
            gp.entityH.entityList[0].direction = 3; //Left
        }else if (yChange > 0){
            gp.entityH.entityList[0].direction = 0; //Up
        }else if (yChange < 0){
            gp.entityH.entityList[0].direction = 2; //Down
        }
        System.out.println(gp.entityH.entityList[0].x + " " + gp.entityH.entityList[0].y);
    }

}

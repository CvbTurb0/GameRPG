package com.mycompany.EntityHandler;

import com.mycompany.GameRPG.GamePanel;

public class PlayerManager {

    GamePanel gp;
    public int currentPlayerIndex = 0;
    public int playerCount = 1;

    public PlayerManager(GamePanel gp){
        this.gp = gp;
    }
    public void move(double xChange, double yChange){
        if (playerCount > 0){
            //Normalize
            if (xChange !=0 && yChange != 0){
                xChange *= 0.7071;
                yChange *= 0.7071;
            }
            //Change position
            gp.entityH.entityList[currentPlayerIndex].x += xChange * gp.entityH.entityList[0].speed;
            gp.entityH.entityList[0].y += yChange * gp.entityH.entityList[0].speed;

            //Change Directions
            if (xChange > 0){
                gp.entityH.entityList[currentPlayerIndex].direction = 1; //Right
                gp.entityH.entityList[currentPlayerIndex].animation = "walkRight"; //Right
            }else if (xChange < 0){ 
                gp.entityH.entityList[currentPlayerIndex].direction = 3; //Left
                gp.entityH.entityList[currentPlayerIndex].animation = "walkLeft"; //Left
            }else if (yChange > 0){
                gp.entityH.entityList[currentPlayerIndex].direction = 2; //Down
                gp.entityH.entityList[currentPlayerIndex].animation = "walkDown"; //Down
            }else if (yChange < 0){
                gp.entityH.entityList[currentPlayerIndex].direction = 0; //Up
                gp.entityH.entityList[currentPlayerIndex].animation = "walkUp"; //Up
            }
        }
    }
    public void addPlayer(){
        if (playerCount == 0){
            gp.entityH.entityList[gp.entityH.entityCount] = new Entity();
            gp.entityH.addEntity(gp.entityH.player);
            currentPlayerIndex = gp.entityH.entityCount -1;
            System.out.println(gp.entityH.entityCount);
            System.out.println(currentPlayerIndex);
            for (int i = 0; i < gp.entityH.entityCount; i++){
                System.out.println(gp.entityH.entityList[i].name);
            }
            playerCount++;
        }
    }

}

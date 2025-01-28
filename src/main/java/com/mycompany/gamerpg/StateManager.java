package com.mycompany.GameRPG;

import java.awt.Graphics2D;

public class StateManager {

    GamePanel gp;

    public String gameState;

    public StateManager(GamePanel gp){
        this.gp = gp;
        gameState = "overworld";
    }

    public void drawOverworld(Graphics2D g2){
       gp.entityImageH.drawEntity(g2);
       gp.buttonH.drawButtons(g2);
    }
    public void drawFight(Graphics2D g2){
        gp.entityImageH.drawEntity(g2);
        gp.buttonH.drawButtons(g2);
        gp.cardH.drawCards(g2);
    }

}

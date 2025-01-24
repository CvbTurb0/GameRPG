package com.mycompany.Buttons;

import com.mycompany.GameRPG.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
public class ButtonHandler {

    GamePanel gp;
    public ButtonHandler(GamePanel gp){
        this.gp = gp;
    }
    public Button[] buttons = new Button[10];
    public int buttonCount = 0;

    public void setupButtons(){
        addButton(400, 400, 32, 32, "button", () -> {
            System.out.println("Button 1 pressed");
            //buttons[0].isAlive = false;
            if(gp.entityH.entityList[gp.playerM.currentPlayerIndex].animation.equals("idle")){
                gp.entityH.entityList[gp.playerM.currentPlayerIndex].animation = "walkUp";
            }
            else{
                gp.entityH.entityList[gp.playerM.currentPlayerIndex].animation = "idle";
            }   
        });
        addButton(500, 400, 32, 32, "button", () -> {
            System.out.println("Button 2 pressed");
            gp.entityH.entityList[gp.playerM.currentPlayerIndex].isAlive = false;
        });
        addButton(600, 400, 32, 32, "button", () -> {
            System.out.println("Button 3 pressed");
            gp.playerM.addPlayer();
            
        });
    }

    public void addButton(int x, int y, int width, int height, String name, Runnable action){
        Button button = new Button();
        button.x = x;
        button.y = y;
        button.width = width;
        button.height = height;
        button.name = name;
        button.action = action;
        button.isAlive = true;
        buttons[buttonCount] = button;
        buttonCount++;
    }
    public void drawButtons(Graphics2D g2){
        for(int i = 0; i < buttonCount; i++){
            if(buttons[i].isAlive){
                g2.drawImage((BufferedImage) (gp.imageSetup.animationMap.get(buttons[i].name)[0][buttons[i].frame]), buttons[i].x, buttons[i].y, buttons[i].width, buttons[i].height, null);
            }
        }
    }
    
    public void update(){
        for (int i = 0; i < buttonCount; i++){
            if(gp.frameCount % gp.frameDelay == 0){
                buttons[i].frame ++;
                if (buttons[i].frame >= gp.imageSetup.animationMap.get(buttons[i].name)[0].length){
                    buttons[i].frame = 0;
                }
            }
        }

    }
}

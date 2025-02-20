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
        addButton(700, 100, 32, 32, "button", () -> {
            System.out.println("Button 1 pressed");
            gp.cardH.getCard("growth");
        }
        );
        addButton(800, 100, 32, 32, "button", () -> {
            System.out.println("Button 2 pressed");
            gp.stateM.gameState = "fight";
        });
        addButton(900, 100, 32, 32, "button", () -> {
            System.out.println("Button 3 pressed");
            gp.playerM.addPlayer();
            gp.stateM.gameState = "overworld"; 
            
        });
       
    }
    public void replaceButton(  double x, double y, double width, double height, String name, Runnable action, int index){
        buttons[index].x = x;
        buttons[index].y = y;
        buttons[index].width = width;
        buttons[index].height = height;
        buttons[index].name = name;
        buttons[index].onClick = action;
        buttons[index].isAlive = true;
    }
    public void startHover(int index){
        buttons[index].hover = true;
        buttons[index].width = (buttons[index].width * 1.1);
        buttons[index].height = (buttons[index].height * 1.1);
        buttons[index].x = buttons[index].x - (buttons[index].width * 0.05);
        buttons[index].y = buttons[index].y - (buttons[index].height * 0.05);
    }
    public void endHover(int index){

        buttons[index].hover = false;
        
        buttons[index].x = buttons[index].x + (buttons[index].width * 0.05);
        buttons[index].y = buttons[index].y + (buttons[index].height * 0.05);
        buttons[index].width = (buttons[index].width / 1.1);
        buttons[index].height = (buttons[index].height / 1.1);
    }
    public void addButton(int x, int y, int width, int height, String name, Runnable action){
        Button button = new Button();
        button.x = x;
        button.y = y;
        button.width = width;
        button.height = height;
        button.name = name;
        button.onClick = action;
        button.isAlive = true;
        buttons[buttonCount] = button;
        buttonCount++;
    }
    public void drawButtons(Graphics2D g2){
        for(int i = 0; i < buttonCount; i++){
            if(buttons[i].isAlive){
                if (buttons[i].hover){
                    g2.drawImage((BufferedImage) (gp.imageSetup.animationMap.get(buttons[i].name)[0][buttons[i].frame]), (int) buttons[i].x, (int)(buttons[i].y - (buttons[i].height * 0.2)), (int)(buttons[i].width * 1.3), (int)(buttons[i].height * 1.3), null);
                }
                else{
                    g2.drawImage((BufferedImage) (gp.imageSetup.animationMap.get(buttons[i].name)[0][buttons[i].frame]), (int) buttons[i].x,(int) buttons[i].y, (int) buttons[i].width, (int) buttons[i].height, null);
                }
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

package com.mycompany.Textboxes;

import java.awt.Color;
import java.awt.Graphics2D;

import com.mycompany.GameRPG.GamePanel;

public class TextboxHandler {

    public Textbox[] textboxList = new Textbox[10];
    public int textboxIndex = 0;
    public boolean textboxOpen;

    GamePanel gp;

    public TextboxHandler(GamePanel gp){
        this.gp = gp;
    }

    public void setup(){
        textboxList[0] = new Textbox();
        textboxList[0].name = "textbox";
        textboxList[0].animation = "idle";
        textboxList[0].x = 0;
        textboxList[0].y = 0;
        textboxList[0].width = 500;
        textboxList[0].height = 100;
        textboxList[0].isAlive = true;
        textboxList[0].text = new String[5];
        textboxList[0].text[0] = "Hello, welcome to the game!";
        textboxList[0].text[1] = "This is a textbox.";
        textboxList[0].text[2] = "You can use this to display text.";
        textboxList[0].text[3] = "You can also use this to display text.";
        textboxList[0].text[4] = "This is the last text.";
        textboxList[0].frame = 0;
        textboxList[0].textIndex = 0;
        textboxList[0].animationIndex = 0;
    }
    public void drawTextbox(Graphics2D g2){
        
        if(textboxList[textboxIndex].isAlive && textboxOpen){
            //g2.drawImage(gp.imageSetup.animationMap.get(textboxList[i].name)[0][textboxList[i].animationIndex], textboxList[i].x, textboxList[i].y, textboxList[i].width, textboxList[i].height, null);
            g2.setColor(Color.black);
            g2.fillRect(textboxList[textboxIndex].x, textboxList[textboxIndex].y, textboxList[textboxIndex].width, textboxList[textboxIndex].height);   
            
            g2.setColor(Color.white);
            String text = textboxList[textboxIndex].text[textboxList[textboxIndex].textIndex];
            text = text.substring(0, Math.min(textboxList[textboxIndex].frame, text.length()));
            g2.drawString(text, textboxList[textboxIndex].x + 10, textboxList[textboxIndex].y + 20);
            
        }
            

    }
    public void openTextbox(int index){
        textboxIndex = index;
        textboxList[textboxIndex].frame = 0;
        textboxList[textboxIndex].textIndex = 0;
        textboxList[textboxIndex].animationIndex = 0;
        textboxList[textboxIndex].isAlive = true;

        textboxOpen = true;
    }
    public void update(){
        if(textboxOpen){
            if(gp.frameCount % gp.frameDelay == 0){
                textboxList[textboxIndex].animationIndex ++;
                //if (textboxList[textboxIndex].frame >= gp.imageSetup.animationMap.get(textboxList[textboxIndex].name)[0].length){
                //textboxList[textboxIndex].frame = 0;
                //}
            }
            if(gp.frameCount % gp.textDelay == 0){
                textboxList[textboxIndex].frame ++;
            }
            
        }
    }
    public void actionTextbox(){
        if (textboxOpen){
            if (textboxList[textboxIndex].frame >= textboxList[textboxIndex].text[textboxList[textboxIndex].textIndex].length()-1){     
                textboxList[textboxIndex].textIndex++;
                if (textboxList[textboxIndex].textIndex >= textboxList[textboxIndex].text.length){
                    textboxOpen = false;
                }
                textboxList[textboxIndex].frame = 0;
            }else{
                textboxList[textboxIndex].frame = textboxList[textboxIndex].text[textboxList[textboxIndex].textIndex].length()-1;
            }
        }
    }
    

}

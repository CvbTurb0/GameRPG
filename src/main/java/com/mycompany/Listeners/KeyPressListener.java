package com.mycompany.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.mycompany.GameRPG.GamePanel;


public class KeyPressListener implements KeyListener {


    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, enterPressed, escPressed;
    
    GamePanel gp;
    public KeyPressListener(GamePanel gp) {
        this.gp = gp;
    } 
    public void update(){

        double xChange = 0;
        double yChange = 0;

        if(upPressed){
            yChange -= 1;
        }if(downPressed){
            yChange += 1;
        }if(leftPressed){
            xChange -= 1;
        }if(rightPressed){
            xChange += 1;
        }if(spacePressed){
            //gp.player.shoot();
        }if(enterPressed){
            //gp.player.enter();
        }if(escPressed){
            //gp.player.esc();
        }
        gp.playerM.move(xChange, yChange);

    }
    @Override
    public void keyTyped(KeyEvent e) {
      
        // Handle key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("upPressed: " + upPressed + " downPressed: " + downPressed + " leftPressed: " + leftPressed + " rightPressed: " + rightPressed);

        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            upPressed = true;
        }if(key == KeyEvent.VK_DOWN){
            downPressed = true;
        }if(key == KeyEvent.VK_LEFT){
            leftPressed = true;
        }if(key == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }if(key == KeyEvent.VK_SPACE){
            spacePressed = true;
        }if(key == KeyEvent.VK_ENTER){
            enterPressed = true;
        }if(key == KeyEvent.VK_ESCAPE){
            escPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            upPressed = false;
        }if(key == KeyEvent.VK_DOWN){
            downPressed = false;
        }if(key == KeyEvent.VK_LEFT){
            leftPressed = false;
        }if(key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }if(key == KeyEvent.VK_SPACE){
            spacePressed = false;
        }if(key == KeyEvent.VK_ENTER){
            enterPressed = false;
        }if(key == KeyEvent.VK_ESCAPE){
            escPressed = false;
        }

        // Handle key released event
    }
}
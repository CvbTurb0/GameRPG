package com.mycompany.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.mycompany.GameRPG.GamePanel;

public class MouseCListener implements MouseListener{

  public double clickX, clickY;
  public boolean pressed, released;

  public GamePanel gp;
  public MouseCListener(GamePanel gp){
    this.gp = gp;
    clickX = 0;
    clickY = 0;
    pressed = false;
    released = false;
  }
  public void reset(){
    clickX = 0;
    clickY = 0;
    released = false;
  }
  public void update(){
  
    if(released){
      for (int i = 0; i < gp.buttonH.buttonCount; i++){
        //Check if the mouse click is within the button's bounds and if the button is alive
        if (gp.buttonH.buttons[i].hover && gp.buttonH.buttons[i].isAlive){
          gp.buttonH.buttons[i].onClick.run();
        }
      }
    }
  

    reset(); 
  }
  @Override
  public void mouseClicked(MouseEvent e){
    clickX = e.getX();
    clickY = e.getY();
    gp.cardH.click();


  }
  @Override
  public void mousePressed(MouseEvent e){
    pressed = true;
    clickX = e.getX();
    clickY = e.getY();
  }
  @Override
  public void mouseReleased(MouseEvent e){
    released = true;
    pressed = false;
    clickX = e.getX();
    clickY = e.getY();
  }
  @Override
  public void mouseEntered(MouseEvent e){ 
    clickX = e.getX();
    clickY = e.getY();
  }
  @Override
  public void mouseExited(MouseEvent e){
    clickX = e.getX();
    clickY = e.getY();
  }
 
}
package com.mycompany.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseCListener implements MouseListener{

  public double clickX, clickY;
  public boolean pressed;
  @Override
  public void mouseClicked(MouseEvent e){
    clickX = e.getX();
    clickY = e.getY();
  }
  @Override
  public void mousePressed(MouseEvent e){
    pressed = true;
    clickX = e.getX();
    clickY = e.getY();
  }
  @Override
  public void mouseReleased(MouseEvent e){
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
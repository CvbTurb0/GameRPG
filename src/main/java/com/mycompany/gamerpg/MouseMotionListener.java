package com.mycompany.gamerpg;

public class MouseMotionListener implements MouseMotionListener{

  public double x,y;
  @overide
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();
  }
  @overide
  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y= e.getY();
  }

}

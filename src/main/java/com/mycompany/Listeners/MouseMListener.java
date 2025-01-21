package com.mycompany.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMListener implements MouseMotionListener{

  public double x,y;
  @Override
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();
  }
  @Override
  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y= e.getY();
  }

}

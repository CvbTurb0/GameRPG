package com.mycompany.GameRPG;

import javax.swing.JFrame; 

public class GameRPG {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game RPG");
        
        
        GamePanel gp = new GamePanel();
        window.add(gp);
        
        window.pack();
        

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

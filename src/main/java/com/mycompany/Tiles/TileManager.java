package com.mycompany.Tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mycompany.GameRPG.GamePanel;

public class TileManager {

    GamePanel gp;
    public TileManager (GamePanel gp){
        this.gp = gp;
    }

    Tile[] tiles = new Tile[100];

    int[][] map = new int[100][100];


    public void setup(){
        setupMap("src\\main\\Resources\\Maps\\map01.txt");
        for (int i = 0; i<= 20; i++){
            tiles[i] = new Tile();
            tiles[i].collision = false;
            try {
                tiles[i].image = ImageIO.read(new File("src\\main\\Resources\\Tiles\\Outdoors\\outdoors" + String.format("%02d", i) + ".png"));
            } catch (IOException e) {
                System.out.println("Tile Image error");
            }
        }
    }
    public void setupMap(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
            String[] values = line.split(" ");
            for (int col = 0; col < values.length; col++) {
                map[row][col] = Integer.parseInt(values[col]);
            }
            row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawMap(Graphics2D g2){
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
            int tileIndex = map[row][col];
            if (tileIndex >= 0 && tileIndex < tiles.length) {
                g2.drawImage(tiles[tileIndex].image, gp.entityImageH.modifyX( col * gp.tileSize), gp.entityImageH.modifyY(row * gp.tileSize), gp.tileSize, gp.tileSize, null);
            }
            }
        }
    }


}

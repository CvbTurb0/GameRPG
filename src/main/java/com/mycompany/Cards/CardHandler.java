package com.mycompany.Cards;


import java.awt.Graphics2D;

import com.mycompany.GameRPG.GamePanel;

public class CardHandler {

    GamePanel gp;
    public CardHandler(GamePanel gp){
        this.gp = gp;
    }

    public Card[] cardList = new Card[100];
    public int[] hand = new int[500];
    public int handCount = 0;
    public int cardCount = 0;
    public int handHovered = 0;

    int defaultWidth = 124;
    int defaultHeight = 185;

    public void setupCards(){
        Card card = new Card();
        card.name = "card";
        card.animation = "idle";
        card.animationFrame = 0;
        card.x = 0;
        card.y = 0;
        card.width = 124;
        card.height = 185;
        card.inHand = false;
        card.selected = false;
        cardList[cardCount] = card;

        cardCount++;

        card = new Card();
        card.name = "card";
        card.animation = "idle";
        card.animationFrame = 0;
        card.x = 0;
        card.y = 0;
        card.width = 124;
        card.height = 185;
        card.inHand = false;
        card.selected = false;
        cardList[cardCount] = card;

        cardCount++;
        card = new Card();
        card.name = "card";
        card.animation = "idle";
        card.animationFrame = 0;
        card.x = 0;
        card.y = 0;
        card.width = 124;
        card.height = 185;
        card.inHand = false;
        card.selected = false;
        cardList[cardCount] = card;

        cardCount++;
        card = new Card();
        card.name = "card";
        card.animation = "idle";
        card.animationFrame = 0;
        card.x = 0;
        card.y = 0;
        card.width = 124;
        card.height = 185;
        card.inHand = false;
        card.selected = false;
        cardList[cardCount] = card;

        cardCount++;

        for (int i = 0; i < 80; i++){
            card = new Card();
            card.name = "card";
            card.animation = "idle";
            card.animationFrame = 0;
            card.x = 0;
            card.y = 0;
            card.width = 124;
            card.height = 185;
            card.inHand = false;
            card.selected = false;
            cardList[cardCount] = card;

            cardCount++;
        }
    }
    public void getCard(int index){
        if (cardList[index].inHand == false){
            cardList[index].inHand = true;
            hand[handCount] = index;
            handCount++;
        }
    }
    public void drawCards(Graphics2D g2){

        int totalWidth = handCount * defaultWidth;
        int width = defaultWidth;
        int maxWidth = 3 * defaultWidth;
        if (handCount >= 3) {
            width = maxWidth / handCount;
            totalWidth = handCount * (width -1) + defaultWidth;
        } 
      
        int startX = (gp.screenWidth - totalWidth) / 2;

        for (int i = 0; i < handCount; i++) {
            
            int xPosition = startX + i * width;
            int yPosition = gp.screenHeight - 120;
            int height = defaultHeight;
            if (cardList[hand[i]].selected){
                height *= 2;
            }
            g2.drawImage(gp.imageSetup.animationMap.get("card")[0][0], xPosition, yPosition, defaultWidth, height, null);
            
        }
        
    }
    public void update(){
        int totalWidth = handCount * defaultWidth;
        int width = defaultWidth;
        int maxWidth = 3 * defaultWidth;
        if (handCount >= 3) {
            width = maxWidth / handCount;
            totalWidth = handCount * (width -1) + defaultWidth;
        } 
      
        int startX = (gp.screenWidth - totalWidth) / 2;

        for (int i = 0; i < handCount; i++) {
            
            int xPosition = startX + i * width;
            int yPosition = gp.screenHeight - 120;
            
            cardList[hand[i]].x = xPosition;
            cardList[hand[i]].y = yPosition;

            cardList[hand[i]].selected = false;
            
        }
    }
}

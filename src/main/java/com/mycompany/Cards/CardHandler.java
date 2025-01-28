package com.mycompany.Cards;


import java.awt.Graphics2D;

import com.mycompany.GameRPG.GamePanel;

public class CardHandler {

    GamePanel gp;
    public CardHandler(GamePanel gp){
        this.gp = gp;
    }

    public Card[] cardList = new Card[500];
    public Card[] hand = new Card[100];
    public int handCount = 0;
    public int cardCount = 0;
    public int handHovered = 0;
    public int selectedCount = 0;

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
            hand[handCount] = cardList[index]; //TODO: Make it so these aren't linked
            handCount++;
        }
    }
    public void drawCards(Graphics2D g2){
        for (int i = 0; i < handCount; i++){
            g2.drawImage(gp.imageSetup.animationMap.get("card")[0][0], (int) hand[i].x,(int) hand[i].y, defaultWidth, defaultHeight, null);
        }
    }
    public void update(){
       
        int center = gp.screenWidth /2;
        int maxWidth = 3 * defaultWidth;

        int width = defaultWidth;
        int x = center - (defaultWidth * handCount)/2;
        if (handCount > 3){
            if (handHovered != -1 && handHovered != handCount -1){
                //maxWidth += defaultWidth;
                width = (maxWidth - 2*defaultWidth) / (handCount-2);
                x = center - ((handCount-2)*width + 2 * defaultWidth )/2;
            }
            else{
                width = (maxWidth - defaultWidth) / (handCount-1);
                x = center - ((handCount-1)*width + defaultWidth )/2;
            }
        }
        for (int i = 0; i < handCount; i ++){
            hand[i].x = x;
            if (hand[i].selected){
                x += width;
                hand[i].y = gp.screenHeight - ( defaultHeight*14/15 ); 
            }
            else if (i == handHovered){
                x += defaultWidth;
                hand[i].y = gp.screenHeight - (2 * defaultHeight /3);
            }else{
                x += width;
                hand[i].y = gp.screenHeight - defaultHeight /2;

            }
        }

        checkHover();
    }public void checkHover(){
        boolean yes = false;        
        for (int i = 0; i < handCount; i++) {
            if (gp.MouseMListener.x >= hand[i].x && gp.MouseMListener.x <= hand[i].x + hand[i].width &&
            gp.MouseMListener.y >= hand[i].y && gp.MouseMListener.y <= hand[i].y + hand[i].height) {
            handHovered = i;
            yes = true;
            System.out.println(i);
            }
        }
        if (!yes){
            handHovered = -1;
        }

    }public void click(){
        if (handHovered != -1){
            if (hand[handHovered].selected ){
                hand[handHovered].selected = false; 
                selectedCount --;
            }else{
                hand[handHovered].selected = true; 
                selectedCount ++;
            }
        }
    }
}

package com.mycompany.Cards;

//Imports
import java.awt.Graphics2D;
import java.lang.reflect.Type;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.GameRPG.GamePanel;

public class CardHandler {

    GamePanel gp;
    public CardHandler(GamePanel gp){
        this.gp = gp;
    }
    //Variables
    public HashMap<String, Card> cardList = new HashMap<>(); //Hashmap storing the base data for all cards
    public Card[] hand = new Card[100];
    public int handCount = 0;
    public int cardCount = 0;
    public int handHovered = 0;
    public int selectedCount = 0;
    public int animationDelay = 7;


    int defaultWidth = 133;
    int defaultHeight = 200;

    public void setupCards(){ // Sets up the cards from the JSON file
        try (InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/cards.json"))) {
            Gson gson = new Gson();
            Type cardListType = new TypeToken<List<Card>>() {}.getType();
            List<Card> cards = gson.fromJson(reader, cardListType);
            for (Card card : cards) {
                cardList.put(card.name, card);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Initiate the hand
        for (int i = 0; i < hand.length; i++) {
            hand[i] = new Card();
        }
    }
    public void getCard(String name){ //Add the card with "name" to the hand
    
            Card card = cardList.get(name);
            if (card != null) {
                hand[handCount].x = card.x;
                hand[handCount].y = card.y;
                hand[handCount].width = card.width;
                hand[handCount].height = card.height;
                hand[handCount].animationFrame = card.animationFrame;
                hand[handCount].animation = card.animation;
                hand[handCount].name = card.name;
                hand[handCount].inHand = card.inHand;
                hand[handCount].selected = card.selected;
                hand[handCount].hovered = card.hovered;
                hand[handCount].inHand = true;
                handCount++;
            } else {
                System.out.println("Card not found: " + name);
            }
        
    }
    public void drawCards(Graphics2D g2){ //Draw the card at its coords
        for (int i = 0; i < handCount; i++){
            g2.drawImage(gp.imageSetup.animationMap.get(hand[i].name)[0][hand[i].animationFrame], (int) hand[i].x,(int) hand[i].y, defaultWidth, defaultHeight, null);
            System.out.println(hand[i].x);
        }
    }
    
    public void update(){ //Mostly just changes the x,y, and the width
// puts them within 1.5 base card widths from the middle
       
        int center = gp.screenWidth /2;
        int maxWidth = 3 * defaultWidth;

        int width = defaultWidth;
        int x = center - (defaultWidth * handCount)/2;

        //Calculate width
        if (handCount > 3){
            if (handHovered != -1 && handHovered != handCount -1 && !hand[handHovered].selected ){
                

                width = (maxWidth - 2*defaultWidth) / (handCount-2);
                x = center - ((handCount-2)*width + 2 * defaultWidth )/2;
            }
            else{
                width = (maxWidth - defaultWidth) / (handCount-1);
                x = center - ((handCount-1)*width + defaultWidth )/2;
            }
        }
        //Calculate X-pos
        for (int i = 0; i < handCount; i ++){
            hand[i].x = x;
            if (hand[i].selected){
                x += width;
                hand[i].y = gp.screenHeight - ( defaultHeight*14/15 ); 
            }
            else if (i == handHovered  ){
                x += defaultWidth;
                hand[i].y = gp.screenHeight - (2 * defaultHeight /3);
            }else{
                x += width;
                hand[i].y = gp.screenHeight - defaultHeight /2;

            }
        }

        checkHover(); // You know what this does
        //update image/animation
        if (gp.frameCount % animationDelay == 0){
            for (int i = 0; i < handCount; i++){
                hand[i].animationFrame++;
                if (hand[i].animationFrame >= gp.imageSetup.animationMap.get(hand[i].name)[0].length){
                    if (gp.frameCount % ((gp.imageSetup.animationMap.get(hand[i].name)[0].length -1) * animationDelay ) == 0){
                        hand[i].animationFrame = 0;
                    }else{
                        hand[i].animationFrame --;
                    }
                    
                }
            }
        }

    }public void checkHover(){ // Checks if a card is being hovered over 
//You need to go over all, because they overlap with eachother
        boolean yes = false;        
        for (int i = 0; i < handCount; i++) {
            if (gp.MouseMListener.x >= hand[i].x && gp.MouseMListener.x <= hand[i].x + hand[i].width &&
            gp.MouseMListener.y >= hand[i].y && gp.MouseMListener.y <= hand[i].y + hand[i].height) {
            handHovered = i;
            yes = true;
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
                for(int i = 0; i < handCount; i ++){
                    hand[i].selected = false;
                }
                hand[handHovered].selected = true; 

//Pins the selected card to the rightmost position
                Card temp = new Card();
                temp.x = hand[handHovered].x;
                temp.y = hand[handHovered].y;
                temp.width = hand[handHovered].width;
                temp.height = hand[handHovered].height;
                temp.animationFrame = hand[handHovered].animationFrame;
                temp.animation = hand[handHovered].animation;
                temp.name = hand[handHovered].name;
                temp.inHand = hand[handHovered].inHand;
                temp.selected = hand[handHovered].selected;
                temp.hovered = hand[handHovered].hovered;

                hand[handHovered].x = hand[handCount - 1].x;
                hand[handHovered].y = hand[handCount - 1].y;
                hand[handHovered].width = hand[handCount - 1].width;
                hand[handHovered].height = hand[handCount - 1].height;
                hand[handHovered].animationFrame = hand[handCount - 1].animationFrame;
                hand[handHovered].animation = hand[handCount - 1].animation;
                hand[handHovered].name = hand[handCount - 1].name;
                hand[handHovered].inHand = hand[handCount - 1].inHand;
                hand[handHovered].selected = hand[handCount - 1].selected;
                hand[handHovered].hovered = hand[handCount - 1].hovered;

                hand[handCount - 1].x = temp.x;
                hand[handCount - 1].y = temp.y;
                hand[handCount - 1].width = temp.width;
                hand[handCount - 1].height = temp.height;
                hand[handCount - 1].animationFrame = temp.animationFrame;
                hand[handCount - 1].animation = temp.animation;
                hand[handCount - 1].name = temp.name;
                hand[handCount - 1].inHand = temp.inHand;
                hand[handCount - 1].selected = temp.selected;
                hand[handCount - 1].hovered = temp.hovered;

                selectedCount ++;
            }
        }
    }
}

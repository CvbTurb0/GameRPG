package com.mycompany.EntityHandler;

import java.util.HashMap;  
import java.util.Map;   


public class EntityDictionary {

    public EntityDictionary(){
     //   setupDefaultAnimations();
    }
    public Map<String, Map<String, Integer>> entityMap = new HashMap<String, Map<String,Integer>>();

    public void setupDefaultAnimations(){
        Map<String, Integer> player = new HashMap<String, Integer>(); //Down, up, left, right
        player.put("idle", 0);
        player.put("walkDown", 0);
        player.put("walkUp", 1);
        player.put("walkLeft", 2);
        player.put("walkRight", 3);
        player.put("dead", 3);
        entityMap.put("player", player);

        Map<String, Integer> chicken = new HashMap<String, Integer>();
        chicken.put("idle", 0);
        chicken.put("walk", 1);
        chicken.put("attack", 2);
        chicken.put("hurt", 3);
        chicken.put("dead", 4);
        entityMap.put("chicken",chicken);

        Map<String, Integer> button = new HashMap<String, Integer>();
        button.put("idle", 0);
        button.put("pressed",1);

        entityMap.put("button", button); 
    }
}

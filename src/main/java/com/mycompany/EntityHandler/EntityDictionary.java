package com.mycompany.EntityHandler;

import java.util.HashMap;  
import java.util.Map;   


public class EntityDictionary {

    public EntityDictionary(){
     //   setupDefaultAnimations();
    }
    public Map<String, Map<String, Integer>> entityMap = new HashMap<String, Map<String,Integer>>();

    public void setupDefaultAnimations(){
        Map<String, Integer> player = new HashMap<String, Integer>();
        player.put("idle", 0);
        player.put("walk", 1);
        player.put("attack", 2);
        player.put("hurt", 3);
        player.put("dead", 4);
        entityMap.put("player", player);

        Map<String, Integer> chicken = new HashMap<String, Integer>();
        chicken.put("idle", 0);
        chicken.put("walk", 1);
        chicken.put("attack", 2);
        chicken.put("hurt", 3);
        chicken.put("dead", 4);
        entityMap.put("chicken",chicken);
    }
}

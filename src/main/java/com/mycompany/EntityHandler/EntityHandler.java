package com.mycompany.EntityHandler;

import com.mycompany.GameRPG.GamePanel;

public class EntityHandler {

    public Entity entityList[] = new Entity[100];
    public  Entity player, chicken, button;
    int entityCount = 0;

    GamePanel gp;
    public EntityHandler(GamePanel gp){
        this.gp = gp;
    }   
    public void setupEntities(){
        player = new Entity();
        player.name = "player";
        player.animation = "idle";
        player.animationIndex = 0;
        player.x = 1000;
        player.y = 1000;
        player.width = 32;
        player.height = 32;
        player.direction = 0;
        player.speed = 2;
        player.health = 100;
        player.damage = 10;
        player.attackSpeed = 1;
        player.attackRange = 32;
        player.attackCooldown = 0;
        player.attackCooldownMax = 60;
        player.isAlive = true;

        chicken = new Entity();
        chicken.name = "chicken";
        chicken.animation = "idle";
        chicken.animationIndex = 0;
        chicken.x = 200;
        chicken.y = 100;
        chicken.width = 32;
        chicken.height = 32;
        chicken.direction = 0;
        chicken.speed = 1;
        chicken.health = 10;
        chicken.damage = 1;
        chicken.attackSpeed = 1;
        chicken.attackRange = 32;
        chicken.attackCooldown = 0;
        chicken.attackCooldownMax = 60;
        chicken.isAlive = true;

        button = new Entity();
        button.name = "button";
        button.animation = "idle";
        button.animationIndex = 0;
        button.x = 300;
        button.y = 100;
        button.width = 32;
        button.height = 32;
        button.isAlive = true;

        addEntity(player);
        addEntity(chicken);
       // addEntity(button);
    }
        
    
    public void updateEntities(){
        //Update animation
        if(gp.frameCount % gp.frameDelay == 0){
            for (int i = 0; i < entityCount; i++){
                entityList[i].animationIndex++;
                if (entityList[i].animationIndex > gp.imageSetup.animationMap.get(entityList[i].name)[0].length - 1){
                    entityList[i].animationIndex = 0;
                }
            }
        }
        for (int i = 0; i < gp.entityH.entityCount; i++){
            if(!entityList[i].isAlive){
                System.out.println(entityList[i].name + " " + entityList[i].health);
                entityList[i].health -= 1;
                System.out.println(entityList[i].name + " " + entityList[i].health);
            }
            if(entityList[i].health <= 0){
                enemyDeath(i);
            }
        }

    }   
    public void enemyDeath(int index){

        if(entityList[index].isAlive){
            entityList[index].isAlive = false;
            entityList[index].health = 120;
            entityList[index].animation = "dead";
        }else{
            String name = entityList[index].name;
            int health = entityList[index].health;
            entityList[index] = entityList[entityCount - 1];
            entityList[entityCount - 1] = null;
            entityCount--;
            if (name.equals("player")){
                gp.playerM.playerCount --;
            }
            System.out.println(entityCount);
            
            System.out.println("Entity removed: " + name + " Reason: " + health );
           
        }
        //Set health to 10*length of death animation
        



        //TODO
        //Add death animation
        //Remove entity from entity array
    }
    public void addEntity(Entity e){
        entityList[entityCount] = new Entity(e);

        entityCount++;
    }
}

package com.mycompany.EntityHandler;

import com.mycompany.GameRPG.GamePanel;

public class EntityHandler {

    public Entity entityList[] = new Entity[100];
    Entity player, chicken, button;
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
        player.x = 100;
        player.y = 100;
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
        if(gp.frameCount % gp.frameDelay == 0){
            for (int i = 0; i < entityCount; i++){
                if (entityList[i].isAlive){
                    entityList[i].animationIndex++;

                    if (entityList[i].animationIndex > gp.imageSetup.animationMap.get(entityList[i].name)[0].length - 1){
                        entityList[i].animationIndex = 0;
                    }
                    //TODO: Add Stuff
                    // - Add entity movement
                    // - Add entity collision
                    // - Add entity attack
                    // - Add entity death
                }
            }
        }
    }   
    public void enemyDeath(int index){
        //TODO
        //Add death animation
        //Remove entity from entity array
    }
    public void addEntity(Entity e){
        entityList[entityCount] = e;
        entityCount++;
    }
}

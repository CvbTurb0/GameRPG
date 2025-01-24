package com.mycompany.EntityHandler;

public class Entity {

    public double x,y;
    public int width, height;
    public int direction; //0 = up, 1 = right, 2 = down, 3 = left
    public int speed;
    public int health;
    public int damage;
    public int attackSpeed;
    public int attackRange;
    public int attackCooldown;
    public int attackCooldownMax;
    public boolean isAlive;
    public String type;

    //For Animation
    public String name;
    public String animation;
    public int animationIndex;

    public Entity(Entity other) {
        this.name = other.name;
        this.animation = other.animation;
        this.animationIndex = other.animationIndex;
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
        this.direction = other.direction;
        this.speed = other.speed;
        this.health = other.health;
        this.damage = other.damage;
        this.attackSpeed = other.attackSpeed;
        this.attackRange = other.attackRange;
        this.attackCooldown = other.attackCooldown;
        this.attackCooldownMax = other.attackCooldownMax;
        this.isAlive = other.isAlive;
    }
    public Entity() {
    }

}

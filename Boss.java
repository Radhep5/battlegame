package com.example.demo;

public class Boss {
    private String bossName;
    private int bossHealth;
    private int bossDamage;
    private int bossArmor;
    private int bossStrength;

    public Boss(String n, int h, int d, int a, int s){
        this.bossName = n;
        this.bossHealth = h;
        this.bossDamage = d;
        this.bossArmor = a;
        this.bossStrength = s;
    }

    public String getBossName() {
        return bossName;
    }

    public int getBossHealth() {
        return bossHealth;
    }

    public int getBossDamage() {
        return bossDamage;
    }

    public int getBossArmor() {
        return bossArmor;
    }

    public int getBossStrength() {
        return bossStrength;
    }
}

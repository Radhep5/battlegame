package com.example.demo;

public class Attack {
    private String attackName;
    private int attackDamage;
    private int attackEffectiveness;
    private int attackAccuracy;
    private int attackSpeed;
    public Attack(String n, int d, int e, int a, int s){
        this.attackName = n;
        this.attackDamage = d;
        this.attackEffectiveness = e;
        this.attackAccuracy = a;
        this.attackSpeed = s;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackEffectiveness() {
        return attackEffectiveness;
    }

    public int getAttackAccuracy() {
        return attackAccuracy;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void increaseDamage(int num){
        this.attackDamage += num;
    }

    public void decreaseDamage(int num){
        this.attackDamage -= num;
    }

    public void increaseEffectiveness(int num){
        this.attackEffectiveness += num;
    }

    public void decreaseEffectiveness(int num){
        this.attackEffectiveness -= num;
    }

    public void increaseAccuracy(int num){
        this.attackAccuracy += num;
    }

    public void decreaseAccuracy(int num){
        this.attackAccuracy -= num;
    }

    public void increaseSpeed(int num){
        this.attackSpeed += num;
    }

    public void decreaseSpeed(int num){
        this.attackSpeed -= num;
    }
}

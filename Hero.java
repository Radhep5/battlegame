package com.example.demo;

public class Hero {
    private String heroName;
    private int heroHealth;
    private int heroStrength;
    private String heroWeapon;
    private int heroScore;
    private int heroArmor;
    private String heroImage;

    public Hero(String n, int h, int s, String w, int a, int score, String image){
        this.heroName = n;
        this.heroHealth = h;
        this.heroStrength = s;
        this.heroWeapon = w;
        this.heroArmor = a;
        this.heroScore = score;
        this.heroImage = image;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public int getHeroStrength() {
        return heroStrength;
    }

    public String getHeroWeapon() {
        return heroWeapon;
    }

    public int getHeroArmor() {
        return heroArmor;
    }

    public int getHeroScore() {
        return heroScore;
    }

    public void changeWeapon(String w){
        this.heroWeapon = w;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroStrength(int s){
        this.heroStrength = s;
    }

    public void setHeroArmor(int a){
        this.heroArmor = a;
    }

    public void setHeroScore(int s){
        this.heroScore = s;
    }

    public void setHeroImage(String i){
        this.heroImage = i;
    }

    public void setHeroName(String n){
        this.heroName = n;
    }

    public void increaseHealth(int num){
        this.heroHealth += num;
    }

    public void decreaseHealth(int num){
        this.heroHealth -= num;
    }

    public void setHeroHealth(int h){
        this.heroHealth = h;
    }
}

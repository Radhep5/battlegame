package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label labelCharacter;
    @FXML
    private Label labelHealth;
    @FXML
    private Label labelStrength;
    @FXML
    private Label labelWeapon;
    @FXML
    private Label labelArmor;
    @FXML
    private Label labelBossName;
    @FXML
    private Label labelBossHealth;
    @FXML
    private Label labelBossDamage;
    @FXML
    private Label labelNextPage;
    @FXML
    private Label labelHeroBattleHealth;
    @FXML
    private Label labelHeroHeader;
    @FXML
    private Label labelBossStats;
    @FXML
    private Label labelPoints;
    @FXML
    private Label labelAttackHit;
    @FXML
    private Label labelBossHeader;
    @FXML
    private Label labelWeaponChoice;
    @FXML
    private Label labelAttack1Stats;
    @FXML
    private Label labelAttack2Stats;
    @FXML
    private Label labelAttack3Stats;
    @FXML
    private Button btnKnight;
    @FXML
    private Button btnArcher;
    @FXML
    private Button btnBarbarian;
    @FXML
    private Button btnWizard;
    @FXML
    private Button btnHealth;
    @FXML
    private Button btnStrength;
    @FXML
    private Button btnAttack1;
    @FXML
    private Button btnAttack2;
    @FXML
    private Button btnAttack3;
    @FXML
    private Button btnResume;
    @FXML
    private Button btnResumeStats;
    @FXML
    private ListView listWeapon;
    @FXML
    private Button btnArmor;
    @FXML
    private Button btnHealthPotion;
    @FXML
    private Button btnDamagePotion;
    @FXML
    private ImageView imgPic;
    @FXML
    private ImageView imgHero;
    @FXML
    private ImageView imgBoss;
    @FXML
    private ImageView imgHealthPotion;
    @FXML
    private ImageView imgDamagePotion;
    @FXML
    private ProgressBar pBar;
    @FXML
    private ProgressBar pBarHero;

    Hero hero;

    @FXML
    public void handleKnight() {
        hero = new Hero("Knight", 100, 75, "", 80,0,"src/main/resources/pics/knight.jpg");
        btnArcher.setDisable(true);
        btnBarbarian.setDisable(true);
        btnWizard.setDisable(true);
        heroPicked();
        knightPic();
        heroHealth = hero.getHeroHealth();
        totalHealth = hero.getHeroHealth();
        btnResume.setDisable(true);
        btnResumeStats.setDisable(true);
    }

    public void knightPic(){
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/knight.jpg");
            imgPic.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleArcher() {
        hero = new Hero("Archer", 100, 40, "", 70,0,"src/main/resources/pics/archer.png");
        btnKnight.setDisable(true);
        btnBarbarian.setDisable(true);
        btnWizard.setDisable(true);
        heroPicked();
        archerPic();
        heroHealth = hero.getHeroHealth();
        totalHealth = hero.getHeroHealth();
        btnResume.setDisable(true);
        btnResumeStats.setDisable(true);
    }

    public void archerPic(){
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/archer.png");
            imgPic.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBarbarian() {
        hero = new Hero("Barbarian", 75, 90, "", 75,0,"src/main/resources/pics/barbarian.png");
        btnKnight.setDisable(true);
        btnArcher.setDisable(true);
        btnWizard.setDisable(true);
        heroPicked();
        barbarianPic();
        heroHealth = hero.getHeroHealth();
        totalHealth = hero.getHeroHealth();
        btnResume.setDisable(true);
        btnResumeStats.setDisable(true);
    }

    public void barbarianPic(){
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/barbarian.png");
            imgPic.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleWizard() {
        hero = new Hero("Wizard", 100, 55, "", 70,0,"src/main/resources/pics/wizard.jpg");
        btnKnight.setDisable(true);
        btnArcher.setDisable(true);
        btnBarbarian.setDisable(true);
        heroPicked();
        wizardPic();
        heroHealth = hero.getHeroHealth();
        totalHealth = hero.getHeroHealth();
        btnResume.setDisable(true);
        btnResumeStats.setDisable(true);
    }

    public void wizardPic(){
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/wizard.jpg");
            imgPic.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveCharacter(){
        String outFilePath = "src/main/resources/characterSave.txt";
        try {
            PrintWriter out = new PrintWriter(outFilePath);
            out.println(hero.getHeroName());
            out.println(hero.getHeroWeapon());
            out.println(hero.getHeroImage());
            out.println(hero.getHeroHealth());
            out.println(hero.getHeroStrength());
            out.println(hero.getHeroArmor());
            out.println(hero.getHeroScore());
            out.close();
        } catch (FileNotFoundException var1) {
            System.out.println("no file here");
        }
    }

    String heroName;
    int heroStrength;
    String heroWeapon;
    int heroArmor;
    int heroScore;
    String heroImage;
    public void loadCharacter(){
//        System.out.println(resumeHealth);
        try {
            FileReader reader = new FileReader("src/main/resources/characterSave.txt");
            Scanner in = new Scanner(reader);
            heroName = in.nextLine();
            heroWeapon = in.nextLine();
            heroImage = in.nextLine();
            heroHealth = in.nextInt();
            heroStrength = in.nextInt();
            heroArmor = in.nextInt();
            heroScore = in.nextInt();
        } catch (FileNotFoundException ex) {
            System.out.println("uh oh!");
        }
//        System.out.println(resumeHealth);
    }

    @FXML
    public void handleResume(){
        loadCharacter();
        hero = new Hero("", 0, 0, "", 0,0,""); //placeholder
        hero.setHeroName(heroName);
        hero.setHeroHealth(heroHealth);
        hero.setHeroStrength(heroStrength);
        hero.changeWeapon(heroWeapon);
        hero.setHeroArmor(heroArmor);
        hero.setHeroScore(heroScore);
        hero.setHeroImage(heroImage);
        btnKnight.setDisable(true);
        btnArcher.setDisable(true);
        btnBarbarian.setDisable(true);
        btnBarbarian.setDisable(true);
        btnWizard.setDisable(true);
        if(!Objects.equals(hero.getHeroName(), "Barbarian")) {
            totalHealth = 100;
        } else{
            totalHealth = 75;
        }
    }

    @FXML
    public void handleResumeStats(){
        labelHealth.setText("Health: " + hero.getHeroHealth());
        labelStrength.setText("Strength: " + hero.getHeroStrength());
        labelWeapon.setText("Weapon: " + hero.getHeroWeapon());
        labelArmor.setText("Armor: " + hero.getHeroArmor());
        labelNextPage.setText("Go to the next tab to begin your first battle!");
        createOpponent();
        battlePics();
        btnAttack1.setVisible(false);
        btnAttack2.setVisible(false);
        btnAttack3.setVisible(false);
        fillHealthBar();
        fillHeroHealthResume();
    }

    boolean attacksCreated = false;
    public void weaponChoice(){
        if(hero.getHeroName().equals("Knight") && hero.getHeroWeapon().equals("Sword")){
            if(attacksCreated) {
                attack1.increaseDamage(10);
                attack2.increaseDamage(10);
                attack3.increaseDamage(10);
            } else{
                labelWeaponChoice.setText("+10 attack damage");
            }
        }
        if(hero.getHeroName().equals("Knight") && hero.getHeroWeapon().equals("Spear")) {
            if (attacksCreated) {
                attack1.increaseAccuracy(5);
                attack1.increaseSpeed(5);
                attack2.increaseAccuracy(5);
                attack2.increaseSpeed(5);
                attack3.increaseAccuracy(5);
                attack3.increaseSpeed(5);
            } else {
                labelWeaponChoice.setText("+5 attack accuracy, +5 attack speed");
            }
        }
        if(hero.getHeroName().equals("Archer") && hero.getHeroWeapon().equals("Bow")){
            if(attacksCreated) {
                attack1.decreaseAccuracy(5);
                attack2.decreaseAccuracy(5);
                attack3.decreaseAccuracy(5);
            } else{
                labelWeaponChoice.setText("-5 attack accuracy");
            }
        }
        if(hero.getHeroName().equals("Archer") && hero.getHeroWeapon().equals("Crossbow")){
            if(attacksCreated) {
                attack1.increaseEffectiveness(5);
                attack2.increaseEffectiveness(5);
                attack3.increaseEffectiveness(5);
            } else{
                labelWeaponChoice.setText("+5 attack effectiveness");
            }
        }
        if(hero.getHeroName().equals("Barbarian") && hero.getHeroWeapon().equals("Axe")){
            if(attacksCreated) {
                attack1.increaseDamage(5);
                attack2.increaseDamage(5);
                attack3.increaseDamage(5);
            } else{
                labelWeaponChoice.setText("+5 attack damage");
            }
        }
        if(hero.getHeroName().equals("Barbarian") && hero.getHeroWeapon().equals("Spear")){
            if(attacksCreated) {
                attack1.increaseAccuracy(5);
                attack1.increaseSpeed(5);
                attack2.increaseAccuracy(5);
                attack2.increaseSpeed(5);
                attack3.increaseAccuracy(5);
                attack3.increaseSpeed(5);
            } else {
                labelWeaponChoice.setText("+5 attack accuracy, +5 attack speed");
            }
        }
        if(hero.getHeroName().equals("Wizard") && hero.getHeroWeapon().equals("Wand")){
            if(attacksCreated) {
                attack1.increaseAccuracy(5);
                attack2.increaseAccuracy(5);
                attack3.increaseAccuracy(5);
            } else{
                labelWeaponChoice.setText("+5 attack accuracy");
            }
        }
        if(hero.getHeroName().equals("Wizard") && hero.getHeroWeapon().equals("Staff")){
            if(attacksCreated) {
                attack1.increaseSpeed(5);
                attack2.increaseSpeed(5);
                attack3.increaseSpeed(5);
            } else{
                labelWeaponChoice.setText("+5 attack speed");
            }
        }
    }

    public void classVsBoss(){
        if(hero.getHeroName().equals("Archer") && boss.getBossName().equals("dragon")){

        }
        if(hero.getHeroName().equals("Wizard") && boss.getBossName().equals("dragon")){

        }
        if(hero.getHeroName().equals("Wizard") && boss.getBossName().equals("witch")){

        }
        if(hero.getHeroName().equals("Knight") && boss.getBossName().equals("ogre")){

        }
        if(hero.getHeroName().equals("Barbarian") && boss.getBossName().equals("ogre")){

        }
    }

    public void heroPicked(){
        labelCharacter.setText("You chose to play as " + hero.getHeroName() + ".\nGo to the next tab to get your attributes");
    }

    @FXML
    public void handleHealth() {
        labelHealth.setText("Health: " + hero.getHeroHealth());
        btnHealth.setDisable(true);
        btnStrength.setDisable(false);
    }

    @FXML
    public void handleStrength() {
        labelStrength.setText("Strength: " + hero.getHeroStrength());
        btnStrength.setDisable(true);
        listWeapon.setDisable(false);
        putWeaponsInList();
    }

    @FXML
    public void handleWeapon() {
        String weaponSelected = listWeapon.getSelectionModel().getSelectedItem().toString();
        hero.changeWeapon(weaponSelected);
        labelWeapon.setText("Weapon: " + hero.getHeroWeapon());
        listWeapon.setDisable(true);
        btnArmor.setDisable(false);
        weaponChoice();
    }

    String[] weapons = {"Sword", "Axe", "Bow", "Wand", "Spear", "Staff", "Crossbow"};
    public void putWeaponsInList(){
        if(hero.getHeroName().equals("Knight")){
            listWeapon.getItems().add(weapons[0]);
            listWeapon.getItems().add(weapons[4]);
        }

        if(hero.getHeroName().equals("Archer")){
            listWeapon.getItems().add(weapons[2]);
            listWeapon.getItems().add(weapons[6]);
        }

        if(hero.getHeroName().equals("Barbarian")){
            listWeapon.getItems().add(weapons[1]);
            listWeapon.getItems().add(weapons[4]);
        }

        if(hero.getHeroName().equals("Wizard")){
            listWeapon.getItems().add(weapons[3]);
            listWeapon.getItems().add(weapons[5]);
        }
    }

    @FXML
    public void handleArmor() {
        labelArmor.setText("Armor: " + hero.getHeroArmor());
        btnArmor.setDisable(true);
        labelNextPage.setText("Go to the next tab to begin your first battle!");
        createOpponent();
        battlePics();
        btnAttack1.setVisible(false);
        btnAttack2.setVisible(false);
        btnAttack3.setVisible(false);
        fillHealthBar();
        fillHeroHealthBar();
    }

    int bossHealth;
    Boss boss;
    public void createOpponent(){
        boss = new Boss("ogre", 200, 15, 65,50);
        bossHealth = boss.getBossHealth();
    }

    public void battlePics(){
        try {
            FileInputStream input = new FileInputStream(hero.getHeroImage());
            imgHero.setImage(new Image(input));
            FileInputStream input2 = new FileInputStream("src/main/resources/pics/" + boss.getBossName() + ".jpg");
            imgBoss.setImage(new Image(input2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleHeroImage(){
        btnAttack1.setVisible(true);
        btnAttack2.setVisible(true);
        btnAttack3.setVisible(true);
        heroAttacks();
        labelHeroHeader.setText("");
        imgHero.setDisable(true);
        heroPotionsImage();
        labelHeroBattleHealth.setText("Health:" + heroHealth);
        setLabelAttackStats();
    }

    Attack attack1;
    Attack attack2;
    Attack attack3;
    public void heroAttacks(){
        if(hero.getHeroName().equals("Knight")){
            attack1 = new Attack("Sword Attack", 75, 65, 65,75);
            attack2 = new Attack("Charge at boss", 25, 90, 75, 100 );
            attack3 = new Attack("Slash", 50, 75,65,85);
            labelSetNames();
        }

        if(hero.getHeroName().equals("Archer")){
            attack1 = new Attack("Single Arrow",50, 60,75,90);
            attack2 = new Attack("Triple Arrow",90,90,90,55);
            attack3 = new Attack("Swing weapon",25, 95, 95, 85);
            labelSetNames();
        }

        if(hero.getHeroName().equals("Barbarian")){
            attack1 = new Attack("Swing weapon",35,50,40,80);
            attack2 = new Attack("Body Slam",85,80,65,65);
            attack3 = new Attack("Throw Rock",60,70,60,55);
            labelSetNames();
        }

        if(hero.getHeroName().equals("Wizard")){
            attack1 = new Attack("Cast Spell",80,70,75,65);
            attack2 = new Attack("Shoot Orb",65,70,65,80);
            attack3 = new Attack("Swing weapon",45,75,70,80);
            labelSetNames();
        }
        labelBossName.setText("Name: " + boss.getBossName());
        labelBossHealth.setText("Health: " + boss.getBossHealth());
        labelBossDamage.setText("Damage: " + boss.getBossDamage());
        btnAttack1.setDisable(false);
        btnAttack2.setDisable(false);
        btnAttack3.setDisable(false);
        initializeDamage();
        attacksCreated = true;
        weaponChoice();
    }

    public void labelSetNames(){
        btnAttack1.setText(attack1.getAttackName());
        btnAttack2.setText(attack2.getAttackName());
        btnAttack3.setText(attack3.getAttackName());
    }

    public void setLabelAttackStats(){
        labelAttack1Stats.setText("atk dmg: " + attack1.getAttackDamage());
        labelAttack2Stats.setText("atk dmg: " + attack2.getAttackDamage());
        labelAttack3Stats.setText("atk dmg: " + attack3.getAttackDamage());
    }

    int attack1Damage;
    int attack2Damage;
    int attack3Damage;
    public void initializeDamage(){
        attack1Damage = attack1.getAttackDamage();
        attack2Damage = attack2.getAttackDamage();
        attack3Damage = attack3.getAttackDamage();
    }

    int round = 1;
    boolean heroTurn = true;
    boolean bossTurn = false;

    @FXML
    public void handleAttack1(){
        if (heroTurn) {
            int chance = (int) (Math.random() * 100);
            if (chance < (attack1.getAttackAccuracy() + attack1.getAttackEffectiveness() + attack1.getAttackSpeed()) + hero.getHeroStrength() + hero.getHeroArmor() / 4) {
                bossHealth -= attack1Damage;
                labelBossHealth.setText("Health: " + bossHealth);
                System.out.println("Boss health: " + bossHealth);
                healthBar(attack1Damage);
                points++;
                initializeDamage();
                labelAttackHit.setText("Your attack HIT!");
            } else {
                labelAttackHit.setText("Your attack MISSED!");
            }
            heroPoints();
            labelHeroHeader.setText("");
            labelBossHeader.setText("Boss's turn to attack. Press image");
        }
        changeTurns();
        roundEnd();
        saveCharacter();
//        auto();
    }

    @FXML
    public void handleAttack2(){
        if (heroTurn) {
            int chance = (int) (Math.random() * 100);
            if (chance < (attack2.getAttackAccuracy() + attack2.getAttackEffectiveness() + attack2.getAttackSpeed()) + hero.getHeroStrength() + hero.getHeroArmor()/ 4) {
                bossHealth -= attack2Damage;
                labelBossHealth.setText("Health: " + bossHealth);
                System.out.println("Boss health: " + bossHealth);
                healthBar(attack2Damage);
                points++;
                initializeDamage();
                labelAttackHit.setText("Your attack HIT!");
            } else {
                labelAttackHit.setText("Your attack MISSED!");
            }
            heroPoints();
            labelHeroHeader.setText("");
            labelBossHeader.setText("Boss's turn to attack. Press image");
        }
        changeTurns();
        roundEnd();
        saveCharacter();
    }

    @FXML
    public void handleAttack3() {
        if(heroTurn) {
            int chance = (int) (Math.random() * 100);
            if (chance < (attack3.getAttackAccuracy() + attack3.getAttackEffectiveness() + attack3.getAttackSpeed()) + hero.getHeroStrength() + hero.getHeroArmor()/ 4) {
                bossHealth -= attack3Damage;
                labelBossHealth.setText("Health: " + bossHealth);
                System.out.println("Boss health: " + bossHealth);
                healthBar(attack3Damage);
                points++;
                initializeDamage();
                labelAttackHit.setText("Your attack HIT!");
            } else {
                labelAttackHit.setText("Your attack MISSED!");
            }
            heroPoints();
            labelHeroHeader.setText("");
            labelBossHeader.setText("Boss's turn to attack. Press image");
        }
        changeTurns();
        roundEnd();
        saveCharacter();
    }

//    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(15), ev -> {
//            btnHealth.setDisable(true);
//        }));
//
//    public void auto() {
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }

    public void changeTurns(){
        heroTurn = false;
        bossTurn = true;
        btnAttack1.setDisable(true);
        btnAttack2.setDisable(true);
        btnAttack3.setDisable(true);
    }

    int heroHealth;
    @FXML
    public void handleBossImage(){
        if(bossTurn) {
            int chance = (int) (Math.random() * 100);
            if (chance < ((boss.getBossDamage() + boss.getBossArmor() + boss.getBossStrength()) / 2)) {
                heroHealth -= boss.getBossDamage();
                labelHeroBattleHealth.setText("Health: " + heroHealth);
                System.out.println("Hero health: " + heroHealth);
                labelAttackHit.setText("The boss attack HIT!");
            } else {
                labelAttackHit.setText("The boss attack MISSED!");
                points++;
            }
            heroPoints();
            labelHeroHeader.setText("Your turn to attack.");
            labelBossHeader.setText("");
        }
        changeTurnForBoss();
        roundEnd();
        heroHealthBar();
    }

    public void changeTurnForBoss(){
        heroTurn = true;
        bossTurn = false;
        btnAttack1.setDisable(false);
        btnAttack2.setDisable(false);
        btnAttack3.setDisable(false);
    }

    public void createRoundTwoBoss(){
        boss = new Boss("witch", 600, 25, 75,75);
        battlePics();
    }

    public void createRoundThreeBoss(){
        boss = new Boss("dragon", 1000, 50, 90,85);
        battlePics();
    }

    public void setBossStats(){
        labelBossName.setText("Name: " + boss.getBossName());
        labelBossHealth.setText("Health: " + boss.getBossHealth());
        labelBossDamage.setText("Damage: " + boss.getBossDamage());
        bossHealth = boss.getBossHealth();
    }

    public void roundEnd() {
        if(round == 1) {
            if (bossHealth <= 0) {
                System.out.println("You beat the boss!");
                round++;
                fillHealthBar();
                createRoundTwoBoss();
                setBossStats();
            } else if (heroHealth <= 0) {
                System.out.println("The boss beat you!");
                gameEnd();
            }
        }
        if(round == 2) {
            if (bossHealth <= 0) {
                System.out.println("You beat the boss!");
                round++;
                fillHealthBar();
                createRoundThreeBoss();
                setBossStats();
            } else if (heroHealth <= 0) {
                System.out.println("The boss beat you!");
                gameEnd();
            }
        }
        if (round == 3){
            if (bossHealth <= 0) {
                System.out.println("You beat the boss!");
                gameWin();
            } else if (heroHealth <= 0) {
                System.out.println("The boss beat you!");
                gameEnd();
            }
        }
    }

    public void gameEnd(){
        labelPoints.setText("YOU LOST!");
        game();
    }

    public void gameWin(){
        labelPoints.setText("YOU WON!");
        game();
    }

    public void game(){
        labelHeroBattleHealth.setText("");
        labelBossStats.setText("");
        labelBossDamage.setText("");
        labelBossHealth.setText("");
        labelBossName.setText("");
        points = 0;
        btnAttack1.setDisable(true);
        btnAttack2.setDisable(true);
        btnAttack3.setDisable(true);
        btnHealthPotion.setDisable(true);
        btnDamagePotion.setDisable(true);
        imgBoss.setDisable(true);
        labelAttackHit.setText("");
    }

    double pBarPercent;

    public void fillHealthBar(){
        pBarPercent = 1;
        pBar.setProgress(pBarPercent);
    }

    public void healthBar(int damage){
        if(boss.getBossName().equals("ogre")) {
            pBarPercent -= 1.0/200.0 * damage;
            pBar.setProgress(pBarPercent);
        }
        if(boss.getBossName().equals("witch")) {
            pBarPercent -= 1.0/600.0 * damage;
            pBar.setProgress(pBarPercent);
        }
        if(boss.getBossName().equals("dragon")) {
            pBarPercent -= 1.0/1000.0 * damage;
            pBar.setProgress(pBarPercent);
        }
    }

    double pBarPercentHero;
    public void fillHeroHealthBar(){
        pBarPercentHero = 1;
        pBarHero.setProgress(pBarPercentHero);
    }

    public void fillHeroHealthResume(){
        double heroHealthFraction = ((double)(heroHealth))/((double)(totalHealth));
        pBarHero.setProgress(heroHealthFraction);
    }

    public void heroHealthBar(){
        pBarHero.setProgress(((double)(heroHealth))/((double)(totalHealth)));
    }

    int totalHealth;
    public void addHealth(int heal){
        heroHealth += heal;
        pBarHero.setProgress(((double)(heroHealth))/((double)(totalHealth)));
    }

    int points = 0;
    public void heroPotionsImage(){
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/healthPotion.png");
            imgHealthPotion.setImage(new Image(input));
            FileInputStream input2 = new FileInputStream("src/main/resources/pics/damagePotion.png");
            imgDamagePotion.setImage(new Image(input2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void heroPoints(){
        if (points >= 3){
            System.out.println("You can heal");
            btnHealthPotion.setDisable(false);
        }
        if (points >= 3){
            System.out.println("You can strengthen attacks");
            btnDamagePotion.setDisable(false);
        }
        labelPoints.setText("Your Points: " + points);
    }

    @FXML
    public void handleHealthPotion(){
        points -= 3;
        addHealth(25);
        labelHeroBattleHealth.setText("Health: " + heroHealth);
        labelPoints.setText("Your Points: " + points);
        checkPoints();
    }

    @FXML
    public void handleDamagePotion(){
        attack1Damage = 2 * attack1.getAttackDamage();
        attack2Damage = 2 * attack2.getAttackDamage();
        attack3Damage = 2 * attack3.getAttackDamage();
        points -= 3;
        labelPoints.setText("Your Points: " + points);
        checkPoints();
    }

    public void checkPoints(){
//        if(points < 5) {
//            btnDamagePotion.setDisable(true);
//        }
        if(points < 3) {
            btnHealthPotion.setDisable(true);
            btnDamagePotion.setDisable(true);
        }
    }
}
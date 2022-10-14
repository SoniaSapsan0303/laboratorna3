package com.droid.laboratorna3;
import java.io.*;
import java.util.Scanner;
public class Droid{
    protected String name;
    protected int health;

    final private int damage = 5;
    public Droid(){
    }
    public Droid(String name, int health){
        this.name = name;
        this.health = health;
    }
    public String showDroid(){return "";}
    public String theDamage(Droid droid, BufferedWriter writer){return "";}
    public String awesomeStrike(Droid droid){
            droid.setHealth((droid.getHealth()-this.getDamage()));
            return "Well done! The strike was awesome!";
    }
    public String missedStrike(){
        this.setHealth((this.getHealth()-this.getDamage()));
        return "You have missed and your droid injured itself!";
    }
    public static void displayStrings(BufferedWriter writer, String sentence){
        System.out.println(sentence);
        try {
            writer.write(sentence+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int numbersToFile(BufferedWriter writer){
        Scanner s = new Scanner(System.in);
        int temp = Integer.parseInt(s.nextLine());
        try {
            writer.write("\t" + temp+ "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
    public int getDamage() {return damage;}


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "The droid is " + this.name + " its health is "+ this.health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


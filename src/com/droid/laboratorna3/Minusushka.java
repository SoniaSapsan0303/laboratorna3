package com.droid.laboratorna3;
import java.io.BufferedWriter;
public class Minusushka extends Droid{
    public Minusushka(String name, int health){
        super(name, health);
    }
    public String showDroid(){
        return "(> ￣ 3￣)>";
    }
    public String theDamage(Droid droid, BufferedWriter writer){
        int x = (int) (Math.random() * 100) + 1;
        int y = (int) (Math.random() * 100) + 1;
        displayStrings(writer, this.name + ", enter the result of \"x - y\" to strike the "+ droid.name +"! The x = "+x+", and the y = "+y);
        int result = numbersToFile(writer);
        if(result == (x - y)){
            return awesomeStrike(droid);
        }else{
            return missedStrike();
        }
    }
}

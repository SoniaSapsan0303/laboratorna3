package com.droid.laboratorna3;

import java.io.BufferedWriter;
public class Mnojushka extends Droid{
    public Mnojushka(String name, int health){
        super(name, health);
    }
    public String showDroid(){
        return "( > * _ *)>";
    }
    public String theDamage(Droid droid, BufferedWriter writer){
        int x, y, result;
        x = (int) (Math.random() * 10) + 1;
        y = (int) (Math.random() * 10) + 1;
        displayStrings(writer, this.name + ", enter the result of \"x * y\" to strike the "+ droid.name +"! The x = "+x+", and the y = "+y);
        result = numbersToFile(writer);
        if(result == (x * y)){
            return awesomeStrike(droid);
        }else{
            return missedStrike();
        }
    }
}

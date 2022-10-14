
import java.util.Scanner;
import java.io.*;
import com.droid.laboratorna3.Droid;
import com.droid.laboratorna3.Plushka;
import com.droid.laboratorna3.Minusushka;
import com.droid.laboratorna3.Dilushka;
import com.droid.laboratorna3.Mnojushka;



public class Main {
    static int HEALTH = 100;

    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        File myFile = new File("text.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            displayStrings(writer, "Please, choose the mode of the game: enter 1 for 1vs1 or 2 for 2vs2");
            int choice = numbersToFile(writer);
            switch (choice) {
                case 1 -> {
                    Droid[] droids = new Droid[2];
                    displayStrings(writer, "Choose the type for you and your enemy: ");
                    creatingDroids(droids, writer);
                    battle(droids[0], droids[1], 8, writer);
                    if (droids[0].getHealth() > droids[1].getHealth())
                        displayStrings(writer, "The first droid is winner!");
                    else if (droids[1].getHealth() > droids[0].getHealth())
                        displayStrings(writer, "The second droid is winner!");
                    else
                        displayStrings(writer, "The friendship is winner!");
                }
                case 2 -> {
                    Droid[] team1 = new Droid[2];
                    Droid[] team2 = new Droid[2];
                    displayStrings(writer, "Choose the types for first team: ");
                    creatingDroids(team1, writer);
                    displayStrings(writer, "Choose the types for second team: ");
                    creatingDroids(team2, writer);
                    displayStrings(writer, "The battle between first members of different teams!");
                    battle(team1[0], team2[0], 8, writer);
                    displayStrings(writer, "The battle between second members of different teams!");
                    battle(team1[1], team2[1], 8, writer);
                    if ((team1[0].getHealth() + team1[1].getHealth()) > (team2[0].getHealth() + team2[1].getHealth()))
                        displayStrings(writer, "The first team is winner!");
                    else if ((team2[0].getHealth() + team2[1].getHealth()) > (team1[0].getHealth() + team1[1].getHealth()))
                        displayStrings(writer, "The second team is winner!");
                    else
                        displayStrings(writer, "The friendship is winner!");
                }
                default -> displayStrings(writer, "You have entered the wrong data!");
            }
            displayStrings(writer, "The game is over! Thanks for having us!");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        int temp = Integer.parseInt(s.nextLine());
        try {
            writer.write("\t" + temp + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
    public static void battle(Droid one, Droid two, int strikes, BufferedWriter writer){
        for(int i = 0; i < strikes; i++){
            displayStrings(writer, "The "+ (strikes-i) +" rounds remain");
            if(i % 2 == 0)
                displayStrings(writer, one.theDamage(two, writer));
            else
                displayStrings(writer, two.theDamage(one, writer));
            displayStrings(writer, one.toString());
            displayStrings(writer, two.toString());
            displayStrings(writer, "\t\t" + one.showDroid() + "\t\t" +turnDroid(two));

        }
    }
    public static String turnDroid(Droid droid){
        StringBuilder temp = new StringBuilder(droid.showDroid());
        for(int i = 0; i < droid.showDroid().length(); i++){
            if(droid.showDroid().charAt(i)=='>')
                temp.setCharAt(i, '<');
            else if(droid.showDroid().charAt(i) == '(')
                temp.setCharAt(i, ')');
            else if(droid.showDroid().charAt(i)==')')
                temp.setCharAt(i, '(');
        }
        temp.reverse();
        return temp.toString();
    }

    public static void creatingDroids(Droid[] droids, BufferedWriter writer){

        for(int i = 0; i < droids.length; i++) {
            displayStrings(writer, "Please, enter the type of the droid: 1 - Plushka, 2 - Minusushka, 3 - Dilushka, 4 - Mnojushka");
            int choiceType = numbersToFile(writer);
            switch (choiceType) {
                case 1:
                    droids[i] = new Plushka("plushka_"+(i+1), HEALTH);
                    break;
                case 2:
                    droids[i] = new Minusushka("minusushka_"+(i+1), HEALTH);
                    break;
                case 3:
                    droids[i] = new Dilushka("dilushka_"+(i+1), HEALTH);
                    break;
                case 4:
                    droids[i] = new Mnojushka("mnojushka_"+(i+1), HEALTH);
                    break;
                default:
                    displayStrings(writer, "You have entered the wrong data!");

            }
        }
    }
}

/*
 * Notes: World creates an object of type player, everything is run through the map object, or the map.player object
 */
package main;

import java.util.Scanner;
import swing.SwingGUI;

/**
 *
 * @author Corey
 */
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
//        System.out.println("Would you like to use the GUI version? (y/n)");
//        answer = input.next().toLowerCase();
//        answerChar = answer.charAt(0);
        
        //GUI not available at this time
//        if(answerChar=='y'){
            //run GUI
//            SwingGUI test = new SwingGUI("");
//        }else{
            //run console
            String path = "src/resources/";
            menus.MainMenu.run("");
//        }
    }
}

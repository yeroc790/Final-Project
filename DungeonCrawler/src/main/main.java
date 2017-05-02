/*
 * Notes: World creates an object of type player, everything is run through the map object, or the map.player object
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Corey
 */
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
        
        System.out.println("Would you like to see the instructions? (y/n)");
        try{
            answerChar = input.next("[yn]").charAt(0);
            if(answerChar=='y')
                instructions();
        }catch(InputMismatchException e){
            System.out.println("Please enter y or n");
            main(args);
        }
        
        menus.MainMenu.run("");
    }
    
    public static void instructions(){
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("---------------------- Instructions ----------------------");
        System.out.println("Dungeon Crawler is a basic ASCII roguelike.");
        System.out.println("You start off in a maze, denoted by the character 'P'");
        System.out.println("You have to explore the area to uncover what lies behind the fog, '*'");
        System.out.println("Your goal is to find the hidden lever to open the door and advance to the next level");
        System.out.println("You move around with 'w', 'a', 's', and 'd'");
        System.out.println("\nYou can interact with items in the world:");
        System.out.println("    1-5: A monster of tier 1-5");
        System.out.println("    C: A chest");
        System.out.println("    L: A lever");
        System.out.println("    |: The door");
        System.out.println("\nTo navigate the submenu, you can select what is currently");
        System.out.println("highlighted by the arrow by pressing ENTER. To switch selections,");
        System.out.println("type 'w' followed by ENTER to move up, or 's' followed by ENTER to move down");
        System.out.println("----------------------------------------------------------\n");
        System.out.println("Press ENTER to continue to the game");
        answer = input.nextLine();
        
    }
}

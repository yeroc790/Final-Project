/*
 * Main menu: controls movement, possibly open inventory
 */
package menus;
import java.util.Scanner;
import objects.*;

/**
 *
 * @author Corey
 */
public class MainMenu {
    public static void run(){
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        char answer;
        
        System.out.println("Welcome to the Dungeon");
        World world = new World();

        System.out.println("-- Current Map --");
        world.displayMap();

        System.out.println("-- Player Map --");
        world.displayPlayerMap();
        
        while(quit==false){
            System.out.println("Move with WASD, type 0 to quit");
            answer = input.nextLine().charAt(0);
            
            switch (answer){
                case 'w':
                    world.movePlayer('u');
                    break;
                case 's':
                    world.movePlayer('d');
                    break;
                case 'a':
                    world.movePlayer('l');
                    break;
                case 'd':
                    world.movePlayer('r');
                    break;
                case '0':
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
            
            world.displayPlayerMap();
        }
    }
}

/*
 * Main menu: controls movement, possibly open inventory
 */
package menus;
import java.util.Scanner;
import objects.*;
import resources.Clear;

/**
 *
 * @author Corey
 */
public class MainMenu {
    private static World world = new World();
    
    public static void run(){
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
        
        Clear.clrScreen();
        System.out.println("Welcome to the Dungeon\n");
        

        System.out.println("-- Current Map --");
        world.displayMap();

        
        System.out.println("-- Player Map --");
        world.displayPlayerMap();
        
        while(quit==false){
            System.out.println("Move with WASD, type 0 to quit");
            answer = input.nextLine();
            if(answer.length()>0){
                answerChar = answer.charAt(0);
                
                switch (answerChar){
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
            }
        }
    }
    
    public static void removeObject(int x, int y){
        BoardObject[][] map = world.getMap();
        map[x][y] = new Floor(x, y);
        world.setMap(map);
    }
}

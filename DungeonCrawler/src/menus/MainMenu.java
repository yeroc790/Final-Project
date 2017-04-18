/*
 * Main menu: controls movement, possibly open inventory
 */
package menus;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import objects.*;
import resources.Clear;
import swing.KeyEventTest;

/**
 *
 * @author Corey
 */
public class MainMenu implements KeyListener{
    private static KeyEventTest window;
    private static World world = new World(window);
    
    public static void run(String file, KeyEventTest window){
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
        MainMenu.window = window;
        
        if(file!= "" && file!= null)
            world = new World(file, window);
        
        Clear.clrScreen();
        System.out.println("Welcome to the Dungeon\n");
        window.displayText("Welcome to the Dungeon" + 
                            "\n" +
                            "-- Map --\n" +
                            world.playerMapString());
        
        while(quit==false){
            System.out.println("Move with WASD, type I for inventory, type 0 to quit");
            answer = input.next().toLowerCase() + "\n";
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
            if(answer.length()>0){
                answerChar = answer.charAt(0);
                
                switch (answerChar){
                    case 'w':
                        world.movePlayer('u');
                        window.displayText(world.playerMapString());
                        break;
                    case 's':
                        world.movePlayer('d');
                        world.displayPlayerMap();
                        break;
                    case 'a':
                        world.movePlayer('l');
                        world.displayPlayerMap();
                        break;
                    case 'd':
                        world.movePlayer('r');
                        world.displayPlayerMap();
                        break;
                    case 'i':
                        menus.InventoryMenu.run(world.getPlayer());
                        world.displayPlayerMap();
                        break;
                    case '0':
                        quit = true;
                        break;
                    case 't':
                        window.displayText("this is a test");
                        break;
                    default:
                        System.out.println("Invalid input, try again");
                        break;
                }
            }
        }
    }
    
    public static void processInput(KeyEvent e, KeyEventTest window){
        MainMenu.window = window;
        world.addWindow(window);
        char answerChar = e.getKeyChar();
        
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
            case 'i':
                menus.InventoryMenu.run(world.getPlayer()); //need to update to menus.InventoryMenu.processInfo(world.getPlayer(), e);
                break;
            case '0':
                break;
            case 't':
                window.displayText("this is a test");
                break;
            case 'm':
                window.displayText(world.playerMapString());
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
    }
    
    public static void removeObject(int x, int y){
        BoardObject[][] map = world.getMap();
        map[x][y] = new Floor(x, y);
        world.setMap(map);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        window.processInput(e);
//        window.displayText("you typed " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

/*
 * Main menu: controls movement, possibly open inventory
 */
package menus;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import objects.*;
import resources.Clear;
import swing.SwingGUI;

/**
 *
 * @author Corey
 */
public class MainMenu implements KeyListener{
    private static SwingGUI window;
    private static World world;
    
    public static void run(String file){ //console version
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
        
        if(file!= "" && file!= null)
            world = new World(file);
        else
            world = new World();
        
        Clear.clrScreen();
        System.out.println("Welcome to the Dungeon\n");
        System.out.println("-------- Map --------");
        world.displayPlayerMap();
        
        while(quit==false){
            System.out.println("Move with WASD, type I for inventory, type 0 to quit");
            answer = input.next().toLowerCase() + "\n";
            
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
                    case 'i':
                        menus.InventoryMenu.run(world.getPlayer());
                        world.displayPlayerMap();
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
    
    /* -- Begin GUI Methods (Deprecated -- */
//    public static void runGUI(String file, SwingGUI window){
//        if(file!= "" && file!= null)
//            world = new World(file);
//        else
//            world = new World();
//        
////        window.displayTitle("<html><div style='text-align:center;'>Welcome to the Dungeon</div></html>");
//        window.displayGame(world.playerMapString());
//        window.displayText("Move around using wasd");
//    }
//    
//    public static void guiInput(KeyEvent e, SwingGUI window){ //gui version
//        MainMenu.window = window;
//        world.addWindow(window);
//        char answerChar = e.getKeyChar();
//        window.setPlayer(world.getPlayer());
//        
//        window.displayText("");
//        switch (answerChar){
//            case 'w':
//                world.movePlayerGUI('u', window, e);
//                break;
//            case 's':
//                world.movePlayerGUI('d', window, e);
//                break;
//            case 'a':
//                world.movePlayerGUI('l', window, e);
//                break;
//            case 'd':
//                world.movePlayerGUI('r', window, e);
//                break;
//            case 'i':
//                window.setMenu(window.INVENTORY_MENU);
//                menus.InventoryMenu.guiInput(e, window, world.getPlayer());
//                break;
//            case '0':
//                break;
//            case 't':
//                window.displayGame("this is a test");
//                break;
//            case 'm':
//                window.displayGame(world.playerMapString());
//                break;
//            default:
//                System.out.println("Invalid input, try again");
//                break;
//        }
//    }
    /* -- End GUI Methods -- */
}

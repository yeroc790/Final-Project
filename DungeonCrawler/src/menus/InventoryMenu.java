/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.awt.event.KeyEvent;
import java.util.Scanner;
import objects.Player;
import objects.items.Item;
import resources.Clear;
import swing.SwingGUI;

/**
 *
 * @author Corey
 */
public class InventoryMenu {
    private static Player player;
    
    public static void run(Player player){
        final int NUM_CHOICES = player.getInventorySize() + 1;
        Item[] inventory = player.getInventory();
        boolean quit = false;
        int choice = 0;
        
        Clear.clrScreen();
        Clear.clrScreen();
        
        while(quit == false){
            inventory = player.getInventory();
            choice = subMenu(player);
            
            switch(choice){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    itemMenu(inventory[choice], player);
                    break;
                case 10: //back button
                    quit = true;
                    break;
                default:
                    break;   
            }
        }
    }
    
    public static void setPlayer(Player player){
        InventoryMenu.player = player;
    }
    
    private static int subMenu(Player player){
        final int NUM_CHOICES = player.getInventorySize() + 1; //inventory size plus back button
        Item[] inventory = player.getInventory();
        String[] header = new String[NUM_CHOICES];
        String[] choices = new String[NUM_CHOICES];
        Scanner input = new Scanner(System.in);
        String answer = "   ";
        char answerChar = 0;
        int choice = 0;
        boolean quit = false;
        
        for (int i = 0; i < NUM_CHOICES; i++) {
            header[i] = "   ";
        }
        header[0] = "-->";
        
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]==null)
                choices[i] = ((i+1) + ".");
            else{
                if(inventory[i].isEquipped())
                    choices[i] = ((i+1) + ". " + inventory[i].getName() + " (equipped)");
                else
                    choices[i] = ((i+1) + ". " + inventory[i].getName());
            }
        }
        choices[NUM_CHOICES-1] = "BACK";
        
        do{
            System.out.println("\n------------------- Your Stats --------------------");
            System.out.println("                    Health: " + player.getHealth());
            System.out.println("                    Attack: " + player.getTotalAttack());
            System.out.println("                    Defense: " + player.getTotalDefense());
            System.out.println("---------------------------------------------------");
            System.out.println("\n----------------- Your Inventory ------------------");
            for (int i = 0; i < NUM_CHOICES; i++) {
                System.out.println(header[i] + choices[i]);
            }
            System.out.println("---------------------------------------------------\n");
            
            answer = input.nextLine();
            
            if(answer.length()>0){
                answerChar = answer.charAt(0);
            }else
                answerChar = 0;

            switch(answerChar){
                case 'w':
                    System.out.println("move up");
                    for (int i = 0; i < NUM_CHOICES; i++) {
                        if(header[i] == "-->"){
                            if(i == 0){
                                header[NUM_CHOICES-1] = "-->";
                                choice = NUM_CHOICES-1;
                            }else{
                                header[i-1] = "-->";
                                choice = i-1;
                            }
                            header[i] = "   ";
                            break;
                        }
                    }
                    break;
                case 's':
                    System.out.println("move down");
                    for (int i = 0; i < NUM_CHOICES; i++) {
                        if(header[i] == "-->"){
                            if(i == NUM_CHOICES-1){
                                header[0] = "-->";
                                choice = 0;
                            }else{
                                header[i+1] = "-->";
                                choice = i+1;
                            }
                            header[i] = "   ";
                            break;
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
            Clear.clrScreen();
            Clear.clrScreen();
        }while(quit == false);
        return choice;
    }
    
    public static void itemMenu(Item item, Player player){
        //equip, unequip, drop, inspect, back
        final int NUM_CHOICES = 5;
        String[] header = new String[NUM_CHOICES];
        String[] choices = {"Inspect", "Equip/Use", "Unequip", "Drop", "Back"};
        Scanner input = new Scanner(System.in);
        String answer = "   ";
        char answerChar = 0;
        int choice = 0;
        boolean quit = false;
        
        for (int i = 0; i < NUM_CHOICES; i++) {
            header[i] = "   ";
        }
        header[0] = "-->";
        
        
        choices[NUM_CHOICES-1] = "BACK";
        
        if(item==null){
            System.out.println("\n-- That slot is empty --");
            return;
        }
        
        do{
            System.out.println("\n---------------------------------------------------");
            System.out.println(item.getName() + "\n");
            for (int i = 0; i < NUM_CHOICES; i++) {
                System.out.println(header[i] + choices[i]);
            }
            System.out.println("---------------------------------------------------\n");
            
            answer = input.nextLine();
            
            if(answer.length()>0){
                answerChar = answer.charAt(0);
            }else
                answerChar = 0;

            switch(answerChar){
                case 'w':
                    for (int i = 0; i < NUM_CHOICES; i++) {
                        if(header[i] == "-->"){
                            if(i == 0){
                                header[NUM_CHOICES-1] = "-->";
                                choice = NUM_CHOICES-1;
                            }else{
                                header[i-1] = "-->";
                                choice = i-1;
                            }
                            header[i] = "   ";
                            break;
                        }
                    }
                    break;
                case 's':
                    for (int i = 0; i < NUM_CHOICES; i++) {
                        if(header[i] == "-->"){
                            if(i == NUM_CHOICES-1){
                                header[0] = "-->";
                                choice = 0;
                            }else{
                                header[i+1] = "-->";
                                choice = i+1;
                            }
                            header[i] = "   ";
                            break;
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
            Clear.clrScreen();
            Clear.clrScreen();
            
            
        }while(quit == false);
        
        switch(choice){
            case 0:
                System.out.println(item.getName() + " - " + item.getStat() + " - \"" + item.getDesc() + "\"");
                itemMenu(item, player);
                break;
            case 1:
                player.equipItem(item);
                break;
            case 2:
                player.unequipItem(item);
                itemMenu(item, player);
                break;
            case 3:
                player.removeFromInventory(item);
            case 4:
            default:
                break;
        }
    }

    
    
    /* -- Begin GUI Methods (Deprecated) -- */
//    private static void itemMenuGUI(Item item, Player player, KeyEvent e, SwingGUI window) {
//        //equip, unequip, drop, inspect, back
//        final int NUM_CHOICES = 5;
//        String[] header = new String[NUM_CHOICES];
//        String[] choices = {"Inspect", "Equip/Use", "Unequip", "Drop", "Back"};
//        String answer = "   ";
//        char answerChar = 0;
//        int choice = 0;
//        boolean quit = false, choiceMade = false;
//        
//        for (int i = 0; i < NUM_CHOICES; i++) {
//            header[i] = "   ";
//        }
//        header[0] = "-->";
//        
//        
//        choices[NUM_CHOICES-1] = "BACK";
//        
//        if(item==null){
//            window.displayText("\n-- That slot is empty --");
//            return;
//        }
//        
//        String s = "";
//        
//        
//        s+=(item.getName() + "\n");
//        for (int i = 0; i < NUM_CHOICES; i++) {
//            s+=(header[i] + choices[i]);
//        }
//        
//        window.displayText(s);
//        
//        answerChar = e.getKeyChar();
//        
//        switch(answerChar){
//            case 'w':
//                for (int i = 0; i < NUM_CHOICES; i++) {
//                    if(header[i] == "-->"){
//                        if(i == 0){
//                            header[NUM_CHOICES-1] = "-->";
//                            choice = NUM_CHOICES-1;
//                        }else{
//                            header[i-1] = "-->";
//                            choice = i-1;
//                        }
//                        header[i] = "   ";
//                        break;
//                    }
//                }
//                break;
//            case 's':
//                for (int i = 0; i < NUM_CHOICES; i++) {
//                    if(header[i] == "-->"){
//                        if(i == NUM_CHOICES-1){
//                            header[0] = "-->";
//                            choice = 0;
//                        }else{
//                            header[i+1] = "-->";
//                            choice = i+1;
//                        }
//                        header[i] = "   ";
//                        break;
//                    }
//                }
//                break;
//            case 97:
//                window.displayText("You pressed 'a'");
//                break;
//            default:
//                break;
//        }
//        
//        switch(choice){
//            case 0:
//                window.displayText(item.getName() + " - " + item.getStat() + " - \"" + item.getDesc() + "\"");
//                break;
//            case 1:
//                player.equipItem(item);
//                break;
//            case 2:
//                player.unequipItem(item);
//                break;
//            case 3:
//                player.removeFromInventory(item);
//                break;
//            case 4:
//                break;
//            default:
//                break;
//        }
//    }
    
//    public static void guiInput(KeyEvent e, SwingGUI window, Player player) {
////        char c = e.getKeyChar();
////        runGUI(player, window);
////        if(c=='1'){
////            window.displayText("You pressed 1, hello there");
////        }else if(c=='0'){ //need to have a return condition, like the back button
////            window.displayText("Returning to main menu");
////            window.setMenu(window.MAIN_MENU);
////        }
//        window.alignTextLeft();
//        final int NUM_CHOICES = player.getInventorySize() + 1; //inventory size plus back button
//        Item[] inventory = player.getInventory();
//        String[] header = new String[NUM_CHOICES];
//        String[] choices = new String[NUM_CHOICES];
//        String answer = "   ";
//        char answerChar = 0;
//        int choice = 0;
//        boolean choiceMade = false;
//        
//        for (int i = 0; i < NUM_CHOICES; i++) {
//            header[i] = "   ";
//        }
//        header[0] = "-->";
//        
//        for (int i = 0; i < inventory.length; i++) {
//            if(inventory[i]==null)
//                choices[i] = ((i+1) + ".");
//            else{
//                if(inventory[i].isEquipped())
//                    choices[i] = ((i+1) + ". " + inventory[i].getName() + " (equipped)");
//                else
//                    choices[i] = ((i+1) + ". " + inventory[i].getName());
//            }
//        }
//        choices[NUM_CHOICES-1] = "BACK";
//        
//        String s = "";
//        s+=("\n------------------- Your Stats --------------------");
//        s+=("                    Health: " + player.getHealth());
//        s+=("                    Attack: " + player.getTotalAttack());
//        s+=("                    Defense: " + player.getTotalDefense());
//        s+=("---------------------------------------------------");
//        s+=("\n----------------- Your Inventory ------------------");
//        for (int i = 0; i < NUM_CHOICES; i++) {
//            s+=(header[i] + choices[i]);
//        }
//        s+=("---------------------------------------------------\n");
////        window.displayText(s);
//        
//        answerChar = e.getKeyChar();
//
//        switch(answerChar){
//            case 'w':
//                window.displayText("you pressed w");
//                for (int i = 0; i < NUM_CHOICES; i++) {
//                    if(header[i] == "-->"){
//                        if(i == 0){
//                            header[NUM_CHOICES-1] = "-->";
//                            choice = NUM_CHOICES-1;
//                        }else{
//                            header[i-1] = "-->";
//                            choice = i-1;
//                        }
//                        header[i] = "   ";
//                        break;
//                    }
//                }
//                break;
//            case 's':
//                window.displayText("you pressed s");
//                for (int i = 0; i < NUM_CHOICES; i++) {
//                    if(header[i] == "-->"){
//                        if(i == NUM_CHOICES-1){
//                            header[0] = "-->";
//                            choice = 0;
//                        }else{
//                            header[i+1] = "-->";
//                            choice = i+1;
//                        }
//                        header[i] = "   ";
//                        break;
//                    }
//                }
//                break;
//            case 13:
////                choiceMade = true;
//                window.displayText("You pressed ENTER");
//                break;
//            default:
//                break;
//        }
//            
//        if(choiceMade){
//            switch(choice){
//                case 0:
//                    case 1:
//                    case 2:
//                    case 3:
//                    case 4:
//                    case 5:
//                    case 6:
//                    case 7:
//                    case 8:
//                    case 9:
//                        itemMenuGUI(inventory[choice], player, e, window);
//                        break;
//                    case 10: //back button
//                        window.displayText("Returning to main menu");
//                        window.alignTextCenter();
//                        window.setMenu(window.MAIN_MENU);
//                        break;
//                    default:
//                        break;   
//            }
//        }
//    }  
//    
//    
//    static void runGUI(Player player, SwingGUI window) {
//        window.displayText("inventory menu loaded");
//        
//    }
    /* -- End GUI Methods -- */
}

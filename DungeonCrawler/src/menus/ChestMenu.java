/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.awt.event.KeyEvent;
import java.util.Scanner;
import objects.BoardObject;
import objects.Chest;
import objects.Player;
import objects.items.Item;
import resources.Clear;
import swing.SwingGUI;

/**
 *
 * @author hansenc
 */
public class ChestMenu {
    public static void run(BoardObject chest, Player player){
        Scanner input = new Scanner(System.in);
        String answer;
        char answerChar;
        
        Chest otherChest = new Chest();
        
        if(chest.getClass() != otherChest.getClass()){
            System.out.println("Error: Chest not passed to ChestMenu");
            System.exit(0);
        }
        otherChest = (Chest) chest;
        
        System.out.println("You found a chest, press ENTER to open it");
        answer = input.nextLine();
        if(answer.equals("")){
            Clear.clrScreen();
            Clear.clrScreen();
            subMenu(otherChest, player);
        }
    }
    
    private static void subMenu(Chest chest, Player player){
        final int NUM_CHOICES = chest.getContents().length + 1; //inventory size plus back button
        Item[] contents = chest.getContents();
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
        
        for (int i = 0; i < contents.length; i++) {
            if(contents[i]==null)
                choices[i] = ("");
            else{
                choices[i] = (contents[i].getName());
            }
        }
        choices[NUM_CHOICES-1] = "BACK";
        
        do{
            System.out.println("\n----------------- Chest Contents ------------------");
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
        
        if(choice == NUM_CHOICES-1) //back button
            return;
        
        int num = itemMenu(chest, choice, player);
        if(num==0){
            return;
        }else{
            subMenu(chest, player);
        }
        return;
    }
    
    public static int itemMenu(Chest chest, int index, Player player){
        //inspect, take, back
        final int NUM_CHOICES = 3;
        String[] header = new String[NUM_CHOICES];
        String[] choices = {"Inspect", "Take", "Back"};
        Scanner input = new Scanner(System.in);
        String answer = "   ";
        char answerChar = 0;
        int choice = 0;
        boolean quit = false;
        Item item = chest.getContents()[index];
        
        for (int i = 0; i < NUM_CHOICES; i++) {
            header[i] = "   ";
        }
        header[0] = "-->";
        
        
        choices[NUM_CHOICES-1] = "BACK";
        
        if(item==null){
            System.out.println("\n-- That slot is empty --");
            return 1;
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
        
        switch(choice){
            case 0: //inspect
                System.out.println("\n---------------------------------------------------------------------");
                System.out.println(item.getName() + " - " + item.getStat() + " - \"" + item.getDesc() + "\"");
                System.out.println("---------------------------------------------------------------------\n");
                break;
            case 1: //take
                chest.takeItem(index, player);
                return 1;
            case 2: //back
            default:
                return 0;
        }
        return 1;
    }
    
    /* -- Begin GUI Methods (Deprecated) -- */
//    public static void runGUI(BoardObject boardObject, Player player, SwingGUI window, KeyEvent e) {
//        window.displayText("chest menu loaded");
//        if(e.getKeyChar()=='1')
//            window.displayText("hello from chest menu");
//    }
    /* -- End GUI Methods -- */
}

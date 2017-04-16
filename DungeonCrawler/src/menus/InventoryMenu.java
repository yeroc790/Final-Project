/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.util.Scanner;
import objects.Player;
import objects.items.Item;
import resources.Clear;

/**
 *
 * @author Corey
 */
public class InventoryMenu {
    public static void run(Player player){
        final int NUM_CHOICES = player.getInventorySize() + 1;
        Item[] inventory = player.getInventory();
        boolean quit = false;
        int choice = 0;
        
        Clear.clrScreen();
        Clear.clrScreen();
        
        while(quit == false){
            choice = subMenu(player);
            
            switch(choice){
                case 0:
                    inspectItem(inventory[0]);
                    break;
                case 1:
                    inspectItem(inventory[1]);
                    break;
                case 2:
                    inspectItem(inventory[2]);
                    break;
                case 3:
                    inspectItem(inventory[3]);
                    break;
                case 4:
                    inspectItem(inventory[4]);
                    break;
                case 5:
                    inspectItem(inventory[5]);
                    break;
                case 6:
                    inspectItem(inventory[6]);
                    break;
                case 7:
                    inspectItem(inventory[7]);
                    break;
                case 8:
                    inspectItem(inventory[8]);
                    break;
                case 9:
                    inspectItem(inventory[9]);
                    break;
                case 10: //back button
                    quit = true;
                    break;
                default:
                    break;   
            }
        }
    }
    
    public static void displayInventory(Player player){
        Item[] inventory = player.getInventory();
        System.out.println("\n----------------- Your Inventory ------------------");
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]==null)
                System.out.println((i+1) + ".");
            else
                System.out.println((i+1) + ". " + inventory[i].getName() + " - " + inventory[i].getDesc());
        }
        System.out.println("---------------------------------------------------\n");
    }
    
    public static void inspectItem(Item item){
        if(item==null)
            System.out.println("\n-- That slot is empty --");
        else
            System.out.println("\n-- " + item.getName() + " - " + item.getDesc() + " --");
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
            else
                choices[i] = ((i+1) + ". " + inventory[i].getName());
        }
        choices[NUM_CHOICES-1] = "BACK";
        
        do{
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
}

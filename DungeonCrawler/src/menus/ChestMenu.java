/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.util.Scanner;
import objects.BoardObject;
import objects.Chest;
import resources.Clear;

/**
 *
 * @author hansenc
 */
public class ChestMenu {
    public static void run(BoardObject chest){
        Scanner input = new Scanner(System.in);
        char answer;
        
        Chest otherChest = new Chest();
        
        if(chest.getClass() != otherChest.getClass()){
            System.out.println("Error: Chest not passed to ChestMenu");
            System.exit(0);
        }
        otherChest = (Chest) chest;
        
        System.out.println("You found a chest, would you like to open it? (y/n)");
        answer = input.next().toLowerCase().charAt(0);
        
        if(answer=='y'){
            Clear.clrScreen();
            otherChest.displayContents();
        }
    }
}

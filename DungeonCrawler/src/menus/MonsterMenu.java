/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.util.Scanner;
import objects.Player;
import objects.monsters.tier1.Tier1;
import resources.Clear;

/**
 *
 * @author hansenc
 */
public class MonsterMenu {
    public static void run(Tier1 monster, Player player){
        System.out.println("\n-- There is a " + monster.getName() + " blocking your path! --");
       
        encounter(monster,player);
    }
    
    public static void encounter(Tier1 monster, Player player){
        Scanner input = new Scanner(System.in);
        String answer;
        int choice;
        boolean monsterDead;
        
        System.out.println("\n" + monster.getName() + " health: " + monster.getHealth());
        System.out.println("Player health: " + player.getHealth());
        
        choice = subMenu();
        if(choice == 0){ //fight
            monsterDead = attack(monster, player);
            
            if(monsterDead){
                return;
            }else{
                encounter(monster, player);
            }
        }else{ //run
            System.out.println("-- You ran away --");
            return;
        }
    }
    
    private static boolean attack(Tier1 monster, Player player){ //returns true if monster is dead
        int mAttack = monster.getAttack(), pAttack = player.getAttack();
        int mHealth = monster.getHealth(), pHealth = player.getHealth();
        
        mHealth -= pAttack;
        pHealth -= mAttack;
        
        if(mHealth<=0){
            System.out.println("\n-- You killed the " + monster.getName() + " --");
            System.out.println("Player health: " + player.getHealth());
            monster.die();
            return true;
        }else if(pHealth<0){
            System.out.println("-- You died, game over --");
            System.exit(0);
        }
        
        System.out.println("\n-- You attacked the " + monster.getName() + " for " + pAttack + " damage --");
        System.out.println("-- The " + monster.getName() + " attacked you for " + mAttack + " damage --");
        
        monster.setHealth(mHealth);
        player.setHealth(pHealth);
        return false;
    }
    
    private static int subMenu(){
        //1. Fight
        //2. Run
        final int NUM_CHOICES = 2;
        String[] header = new String[NUM_CHOICES];
        String[] choices = {"Fight", "Run"};
        Scanner input = new Scanner(System.in);
        String answer = "   ";
        char answerChar = 0;
        int choice = 0;
        boolean quit = false;
        
        for (int i = 0; i < NUM_CHOICES; i++) {
            header[i] = "   ";
        }
        header[0] = "-->";
        
        do{
            System.out.println("\nWhat would you like to do?");
            
            for (int i = 0; i < NUM_CHOICES; i++) {
                System.out.println(header[i] + choices[i]);
            }
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

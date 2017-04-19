/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;
import objects.Player;
import objects.monsters.tier1.Tier1;
import resources.Clear;
import swing.SwingGUI;

/**
 *
 * @author hansenc
 */
public class MonsterMenu {
    public static void run(Tier1 monster, Player player){
        System.out.println("\n-- There is a " + monster.getName() + " blocking your path! --");
       
        encounter(monster,player);
    }
    
    public static void runGUI(Tier1 randMonster, Player player, SwingGUI window, KeyEvent e) {
        window.displayText("monster menu loaded");
        if(e.getKeyChar()=='1')
            window.displayText("hello from monster menu");
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
        Random r = new Random();
        final int CRIT_CHANCE = 30;
        String name = monster.getName();

        /* -- Player Stats in first slot, monster in second -- */
        int[] attack = {player.getTotalAttack(), monster.getAttack()};
        int[] defense = {player.getTotalDefense(), monster.getDefense()};
        int[] health = {player.getHealth(), monster.getHealth()};
        int[] roll = {r.nextInt(CRIT_CHANCE), r.nextInt(CRIT_CHANCE)};
        boolean[] crit = {false, false};
        
        /* -- Simulated roll for attack values -- */
        for (int i = 0; i < 2; i++) {
            if(roll[i]==0){ //miss
                attack[i] = 0;}
            else if(roll[i]==CRIT_CHANCE-1){ //crit
                attack[i] = attack[i]*2;
                crit[i] = true;
            }else{
                attack[i] = rngAttack(attack[i]);
            }
        }
        
        //damage goes through defense shield first
        defense[1] -= attack[0];
        if(defense[1]<=0){
            health[1] -= (defense[1]*(-1));
            attack[0] = (defense[1]*(-1));
        }else
            attack[0] = 0;
            
        defense[0] -= attack[1];
        if(defense[0]<=0){
            health[0] -= (defense[0]*(-1));
            attack[1] = (defense[0]*(-1));
        }else
            attack[1] = 0;
        
//        health[1] = health[1] - (defense[1] - attack[0]);
        
//        health[1] -= attack[0]; //player attacks
//        health[0] -= attack[1]; //monster attacks
        
        //player display
        if(attack[0]==0)
            System.out.println("\n-- You attacked the " + name + " and missed --");
        else if(crit[0]==true)
            System.out.println("\n-- You landed a critical hit on the " + name + " for " + attack[0] + " damage! --");
        else
            System.out.println("\n-- You attacked the " + name + " for " + attack[0] + " damage --");
        
        //monster display
        if(attack[1]==0)
            System.out.println("-- The " + name + " attacked you, but you dodged the attack --");
        else if(crit[1]==true)
            System.out.println("-- The " + name + " landed a critical hit on you for " + attack[1] + " damage --");
        else
            System.out.println("-- The " + monster.getName() + " attacked you for " + attack[1] + " damage --");
        
        //player died
        if(health[0]<0){
            System.out.println("\n-- You died, game over --");
            System.exit(0);
        }
        
        //monster died
        if(health[1]<=0){
            System.out.println("\n-- You killed the " + name + " --");
            System.out.println("Player health: " + health[0]);
            player.setHealth(health[0]);
            monster.die();
            return true;
        }
        
        monster.setHealth(health[1]);
        player.setHealth(health[0]);
        return false;
    }
    
    private static int rngAttack(int attack){
        Random r = new Random();
        int high, low;

        //tossing out nonpositive attacks
        if(attack<=0)
            return 0;
        
        //to avoid highs and lows of 0
        if(attack<=3){
            high = attack;
            low = 1;
        }else{
            high = (int)(attack + attack*0.25); //range of 25% higher and 25% lower than standard attack
            low = (int)(attack - attack*0.25);
        }
        
        int rand = r.nextInt(high-low) + low;
        if(rand<0)
            rand = 0;
        
        return rand;
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

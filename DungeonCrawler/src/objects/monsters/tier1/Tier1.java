/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier1;

import java.util.logging.Level;
import java.util.logging.Logger;
import objects.monsters.Monster;

/**
 *
 * @author hansenc
 */
public class Tier1 extends Monster{
    public static void getRandomMonster(){ //will be public Tier1 getRandomMonster()
        String monsterNames[] = {"Goblin", "CaveBat"};
        try{
            Class someMonsterClass = Class.forName(monsterNames[0]);
            Tier1 someMonster = (Tier1) someMonsterClass.newInstance();
        }catch(ClassNotFoundException e){
            System.out.println("Error: " + e.getClass() + ": " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Error: " + e.getClass() + ": " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e.getClass() + ": " + e.getMessage());
        }
        
//        Class someAnimalClass = Class.forName(animalNameArray[randomNumber]); 
//        Animal someAnimal = someAnimalClass.newInstance();
        
        
        Tier1 test = new Goblin();
//        return new Tier1();
    }
}

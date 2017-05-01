/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import exceptions.DuplicateItemException;
import exceptions.InventoryFullException;
import java.util.Arrays;
import java.util.Random;
import objects.items.Item;
import objects.items.armor.*;
import objects.items.potions.*;
import objects.items.weapons.*;

/**
 *
 * @author Corey
 */
public class Chest extends BoardObject{
    Item[] contents;
    boolean empty;
    
    public Chest(){
        super(0, 0, 'C', "chest");
        populateChest(5);
        empty = false;
    }
    
    public Chest(int x, int y){
        super(x, y, 'C', "chest");
        populateChest(5);
        empty = false;
    }
    
    public void setContents(Item[] contents){
        this.contents = contents;
    }
    
    public Item[] getContents(){
        return Arrays.copyOf(contents, contents.length);
    }
    
    public void removeItem(int index){
        contents[index] = null;
    }
    
    public Item getItem(int index){
        return contents[index];
    }
    
    public void displayContents(){
        if(contents!=null){
            System.out.println("-- Chest Contents --");
            for (int i = 0; i < contents.length; i++) {
                if(contents[i]!=null)
                    System.out.println(contents[i].getName());
            }
            System.out.println("--------------------");
        }else
            System.out.println("-- The chest is empty --");
    }
    
    public void takeItem(int index, Player player){
        try{
            player.addToInventory(contents[index]);
            removeItem(index);
        }catch(InventoryFullException e){
            System.out.println("\n-- You cannot pick up that item, your inventory is full --");
        }catch(DuplicateItemException e){
            System.out.println("\n-- You already have that item --");
        }
    }
    
    /* -- Population Methods --*/
    public void populateChest(int numItems){
//        int low = 1, high = numItems;
        Random r = new Random();
        numItems = r.nextInt(numItems-2)+2;
        int rand;
        Item[] contents = new Item[numItems];
        
        for (int i = 0; i < numItems; i++) {
            rand = r.nextInt(3); //from 0 - 2
            
            switch(rand){
                case 0:
                    contents[i] = getRandomWeapon();
                    break;
                case 1:
                    contents[i] = getRandomArmor();
                    break;
                case 2:
                    contents[i] = getRandomPotion();
                    break;
                default:
                    break;
            }
        }
        this.contents = contents;
    }
    
    private static int convertRarity(String rarity){
        switch(rarity){
            case "common":
                return 50;
            case "rare":
                return 20;
            case "epic":
                return 5;
            case "legendary":
                return 1;
            default:
                return 50;
        }
    }
    
    public static Weapon getRandomWeapon(){
        Weapon[] weapons = {
            new IronSword(), new GoldSword(), new Excalibur(), new Morgif(), new BoneSword(), new DualDaggers(),
            new CrossBow(), new LongBow(), new IronMace(), new FireStaff()
        }; //weapons holds the different weapons available
        int[] weights = new int[weapons.length]; //rarity weights for each weapon
        int totalWeight = 0;
        Random r = new Random();
        
        //getting total weight and populating weights
        for (int i = 0; i < weapons.length; i++) {
            weights[i] = convertRarity(weapons[i].getRarity());
            totalWeight += weights[i];
        }
        
        
        String weaponNames[] = new String[totalWeight]; //holds duplicates of all weapons, according to rarity
        int index = 0;
        for (int i = 0; i < weapons.length; i++) { //loops for each type of weapon
            for (int j = 0; j < weights[i]; j++) { //loops for the weight of that weapon
                weaponNames[index] = weapons[i].getClass().getName(); //puts that weapon's name in the list to pick from below
                index++;
            }
        }
        
        int low = 0, high = weaponNames.length;
        int rand = r.nextInt(high-low)+low;
        
        try{
            Weapon object = (Weapon)Class.forName(weaponNames[rand]).newInstance(); //picks a random weapon in the weighted list
            return object;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (InstantiationException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        
        //to keep compiler happy
        Weapon foo = new Weapon();
        return foo;
    }
    
    public static Armor getRandomArmor(){
        Armor[] armors = {
            new CopperArmor(), new IronArmor(), new GoldArmor(), new ChainMail(), new LeatherArmor(), new HeavensWheel()
        }; //weapons holds the different armors available
        int[] weights = new int[armors.length]; //rarity weights for each armor
        int totalWeight = 0;
        Random r = new Random();
        
        //getting total weight and populating weights
        for (int i = 0; i < armors.length; i++) {
            weights[i] = convertRarity(armors[i].getRarity());
            totalWeight += weights[i];
        }
        
        
        String weaponNames[] = new String[totalWeight]; //holds duplicates of all armors, according to rarity
        int index = 0;
        for (int i = 0; i < armors.length; i++) { //loops for each type of armor
            for (int j = 0; j < weights[i]; j++) { //loops for the weight of that armor
                weaponNames[index] = armors[i].getClass().getName(); //puts that armor's name in the list to pick from below
                index++;
            }
        }
        
        int low = 0, high = weaponNames.length;
        int rand = r.nextInt(high-low)+low;
        
        try{
            Armor object = (Armor)Class.forName(weaponNames[rand]).newInstance(); //picks a random armor in the weighted list
            return object;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (InstantiationException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        
        //to keep compiler happy
        Armor foo = new Armor();
        return foo;
    }
    
    public static Potion getRandomPotion(){
        Potion[] potions = {new LesserHealing(), new GreaterHealing()}; //potions holds the different potions available
        int[] weights = new int[potions.length]; //rarity weights for each weapon
        int totalWeight = 0;
        Random r = new Random();
        
        //getting total weight and populating weights
        for (int i = 0; i < potions.length; i++) {
            weights[i] = convertRarity(potions[i].getRarity());
            totalWeight += weights[i];
        }
        
        
        String potionNames[] = new String[totalWeight]; //holds duplicates of all potions, according to rarity
        int index = 0;
        for (int i = 0; i < potions.length; i++) { //loops for each type of potion
            for (int j = 0; j < weights[i]; j++) { //loops for the weight of that potion
                potionNames[index] = potions[i].getClass().getName(); //puts that potion's name in the list to pick from below
                index++;
            }
        }
        
        int low = 0, high = potionNames.length;
        int rand = r.nextInt(high-low)+low;
        
        try{
            Potion object = (Potion)Class.forName(potionNames[rand]).newInstance(); //picks a random potion in the weighted list
            return object;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (InstantiationException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        
        //to keep compiler happy
        Potion foo = new Potion();
        return foo;
    }
    /* -- End Population Methods -- */
}

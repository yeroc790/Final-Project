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
import objects.items.armor.Armor;
import objects.items.potions.Potion;
import objects.items.weapons.Excalibur;
import objects.items.weapons.Weapon;
import objects.items.weapons.WoodenSword;

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
        numItems = r.nextInt(numItems-1)+1;
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
                return 20;
            case "rare":
                return 10;
            case "epic":
                return 5;
            case "legendary":
                return 1;
            default:
                return 20;
        }
    }
    
    public static Weapon getRandomWeapon(){
        String path = "objects.items.weapons.";
        Weapon[] weapons = {new WoodenSword(), new Excalibur()}; //weapons holds the different weapons available
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
        String path = "objects.items.armor.";
        String armorNames[] = {path+"Rags", path+"CopperArmor"};
        Random r = new Random();
        int low = 0, high = armorNames.length;
        int rand = r.nextInt(high-low)+low;
        
        try{
            Armor object = (Armor)Class.forName(armorNames[rand]).newInstance();
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
        String path = "objects.items.potions.";
        String potionNames[] = {path+"LesserHealing", path+"GreaterHealing"};
        Random r = new Random();
        int low = 0, high = potionNames.length;
        int rand = r.nextInt(high-low)+low;
        
        try{
            Potion object = (Potion)Class.forName(potionNames[rand]).newInstance();
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

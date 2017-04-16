/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import exceptions.DuplicateItemException;
import exceptions.InventoryFullException;
import java.util.Arrays;
import objects.items.Item;
import objects.items.armor.Rags;
import objects.items.utility.LesserHealing;
import objects.items.utility.Utility;
import objects.items.weapons.WoodenSword;

/**
 *
 * @author Corey
 */
public class Player extends Character{
    private final int ATTACK = 10;
    private final double DEFENSE = 10;
    private final int HEALTH = 100;
    private final int INVENTORY_SIZE = 10;
    private Item[] inventory = new Item[INVENTORY_SIZE]; //can only have duplicate utilities, no duplicate weapons or armor
    
    /* -- Begin Constructors -- */
    public Player(){
        super(0, 0, 'P', "player");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
        
        setStarterInventory();
    }
    
    public Player(int row, int col){
        super(row, col, 'P', "player");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
        
        setStarterInventory();
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    public Item[] getInventory(){
        return Arrays.copyOf(inventory, inventory.length);
    }
    
    public int getInventorySize(){
        return INVENTORY_SIZE;
    }
    /* -- End Accessors -- */
    
    /* -- Begin Custom Methods -- */
    public void addToInventory(Item item) throws InventoryFullException, DuplicateItemException{
        int index = 0;
        boolean duplicates = false;
        
        if(item instanceof Utility){ //duplicates allowed
            for (int i = 0; i < inventory.length; i++) {
                if(inventory[i]==null){
                    inventory[i] = item;
                    return;
                }
            }
        }else{
            for (int i = 0; i < inventory.length; i++) {
                if(inventory[i]!=null){
                    if(inventory[i].equals(item)){
                        duplicates = true;
                        throw new DuplicateItemException("\nYou already have that item in your inventory");
                    }
                }
            }
            if(duplicates==false){
                for (int i = 0; i < inventory.length; i++) {
                    if(inventory[i]==null){
                        inventory[i] = item;
                        return;
                    }
                }
            }
        }
        
        //if space isn't found
        throw new InventoryFullException("You don't have room in your inventory for that");
    }
    
    public void removeFromInventory(Item item){
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i].equals(item)){
                inventory[i] = null;
                return;
            }
        }
        System.out.println("\nCould not find item in inventory");
    }
    
    private void setStarterInventory(){
        try{
            addToInventory(new WoodenSword(true));
            addToInventory(new Rags(true));
            addToInventory(new LesserHealing(true));
        }catch(InventoryFullException e){
            System.out.println(e.getMessage());
        } catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
    }
    /* -- End Custom Methods -- */
}

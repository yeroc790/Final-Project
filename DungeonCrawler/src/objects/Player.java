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
import objects.items.armor.Armor;
import objects.items.armor.Rags;
import objects.items.potions.LesserHealing;
import objects.items.potions.Potion;
import objects.items.weapons.Weapon;
import objects.items.weapons.WoodenSword;

/**
 *
 * @author Corey
 */
public class Player extends Character{
    private final int ATTACK = 10;
    private final int DEFENSE = 0;
    private int MAX_HEALTH = 100;
    private int HEALTH = MAX_HEALTH;
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
    
    public int getMaxHealth(){
        return MAX_HEALTH;
    }
    /* -- End Accessors -- */
    
    /* -- Begin Custom Methods -- */
    public void addToInventory(Item item) throws InventoryFullException, DuplicateItemException{
        int index = 0;
        boolean duplicates = false;
        
        if(item instanceof Potion){ //duplicates allowed
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
            addToInventory(new LesserHealing());
        }catch(InventoryFullException e){
            System.out.println(e.getMessage());
        } catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getTotalAttack(){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i].isEquipped()){
                if(inventory[i] instanceof objects.items.weapons.Weapon){
                    //item is an equipped weapon
                    Weapon w = (Weapon) inventory[i];
                    return (getAttack() + w.getAttack());
                }
            }
        }
        return getAttack();
    }
    
    public int getTotalDefense(){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]!=null){
                if(inventory[i].isEquipped()){
                    if(inventory[i] instanceof objects.items.armor.Armor){
                        //item is equipped armor
                        Armor a = (Armor) inventory[i];
                        return (getDefense() + a.getDefense());
                    }
                }
            }
        }
        return getDefense();
    }
    
    public void equipItem(Item item){ //needs a case for when equipping utilities
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]!=null){
                if((inventory[i] instanceof Weapon)&&(item instanceof Weapon)){
                    if(inventory[i].isEquipped() && (inventory[i].equals(item)==false)){
                        //a weapon is equipped that is not the item
                        inventory[i].setEquip(false);
                    }
                }
                if((inventory[i] instanceof Armor)&&(item instanceof Armor)){
                    if(inventory[i].isEquipped() && (inventory[i].equals(item)==false)){
                        //armor is equipped that is not the item
                        inventory[i].setEquip(false);
                    }
                }
                

                if(inventory[i].equals(item)){
                    if((inventory[i] instanceof Potion)&&(item instanceof Potion)){
                        Potion u = (Potion)inventory[i];
                        u.consume(this);
                        return;
                    }
                    if(inventory[i].isEquipped())
                        System.out.println("That item is already equipped");
                    else
                        inventory[i].setEquip(true);
                }
            }
        }
    }
    
    public void unequipItem(Item item){
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i]!=null){
                if(inventory[i].equals(item)){
                    if(inventory[i].isEquipped() == false)
                        System.out.println("That item is already unequipped");
                    else
                        inventory[i].setEquip(false);
                }
            }
        }
    }
    /* -- End Custom Methods -- */
}

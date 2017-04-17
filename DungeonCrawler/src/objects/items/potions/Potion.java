/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.potions;

import objects.Player;
import objects.items.Item;

/**
 *
 * @author Corey
 */
public class Potion extends Item{
    private int health;
    
    public Potion(){
        super("potion", "consumable item", "drink 'em to get health", "common");
        this.health = 0;
    }
    
    public Potion(String name, String stat, String desc, String rarity, int health){
        super(name, stat, desc, rarity);
        this.health = health;
    }
    
    public void consume(Player player){
        int pHealth = player.getHealth();
        int restored;
        
        if(pHealth == player.getMaxHealth()){
            System.out.println("-- You are already at full health --");
            return;
        }
        
        pHealth += health;
        if(pHealth>player.getMaxHealth()){
            restored = player.getMaxHealth() - pHealth;
            pHealth = player.getMaxHealth();
        }else
            restored = health;
        
        player.setHealth(pHealth);
        player.removeFromInventory(this);
        System.out.println("-- Restored " + restored + " health");
    }
}

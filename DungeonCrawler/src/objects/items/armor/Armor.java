/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.armor;

import objects.items.Item;

/**
 *
 * @author Corey
 */
public class Armor extends Item{
    private int defense;
    public Armor(){
        super("armor", "affects defense", "armor is a thing that you wear", "common");
        defense = 0;
    }
    
    public Armor(String name, String stat, String desc, String rarity){
        super(name, stat, desc, rarity);
        defense = 0;
    }
    
    public Armor(String name, String stat, String desc, String rarity, int defense){
        super(name, stat, desc, rarity);
        this.defense = defense;
    }
    
    public Armor(String name, String stat, String desc, String rarity, int defense, boolean equipped){
        super(name, stat, desc, rarity, equipped);
        this.defense = defense;
    }
    
    public int getDefense(){
        return defense;
    }
}

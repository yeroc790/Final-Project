/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.weapons;

import objects.items.Item;

/**
 *
 * @author Corey
 */
public class Weapon extends Item{
    private int attack;
    
    public Weapon(){
        super("weapon", "affects attack", "weapons are things you use to hit monsters with", "common");
        attack = 0;
    }
    
    public Weapon(String name, String stat, String desc, String rarity){
        super(name, stat, desc, rarity);
        attack = 0;
    }
    
    public Weapon(String name, String stat, String desc, String rarity, int attack){
        super(name, stat, desc, rarity);
        this.attack = attack;
    }
    
    public Weapon(String name, String stat, String desc, String rarity, int attack, boolean equipped){
        super(name, stat, desc, rarity, equipped);
        this.attack = attack;
    }
    
    public int getAttack(){
        return attack;
    }
}

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
        super("weapon", "affects attack", "weapons are things you use to hit monsters with");
        attack = 0;
    }
    
    public Weapon(String name, String stat, String desc){
        super(name, stat, desc);
        attack = 0;
    }
    
    public Weapon(String name, String stat, String desc, int attack){
        super(name, stat, desc);
        this.attack = attack;
    }
    
    public Weapon(String name, String stat, String desc, int attack, boolean equipped){
        super(name, stat, desc, equipped);
        this.attack = attack;
    }
    
    public int getAttack(){
        return attack;
    }
}

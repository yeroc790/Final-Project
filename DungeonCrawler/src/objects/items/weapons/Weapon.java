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
    public Weapon(){
        super("weapon", "affects attack");
    }
    
    public Weapon(String name, String desc){
        super(name, desc);
    }
    
    public Weapon(String name, String desc, boolean equipped){
        super(name, desc, equipped);
    }
}

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
    public Armor(){
        super("armor", "affects defense");
    }
    
    public Armor(String name, String desc){
        super(name, desc);
    }
    
    public Armor(String name, String desc, boolean equipped){
        super(name, desc, equipped);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.utility;

import objects.items.Item;

/**
 *
 * @author Corey
 */
public class Utility extends Item{
    public Utility(){
        super("utility", "consumable item");
    }
    
    public Utility(String name, String desc){
        super(name, desc);
    }
    
    public Utility(String name, String desc, boolean equipped){
        super(name, desc, equipped);
    }
}

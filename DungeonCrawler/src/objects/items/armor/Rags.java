/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.armor;

/**
 *
 * @author Corey
 */
public class Rags extends Armor{
    private static final String name = "Dirty Rags";
    private static final String stat = "Defense +0";
    private static final String desc = "You feel a breeze where there shouldn't be";
    private static final String rarity = "common";

    
    public Rags(){
        super(name, stat, desc, rarity, 0);
    }
    
    public Rags(boolean equipped){
        super(name, stat, desc, rarity, 0, equipped);
    }
}

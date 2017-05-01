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
public class LeatherArmor extends Armor{
    private static final String name = "Leather Armor";
    private static final String stat = "Defense +2";
    private static final String desc = "You were wearing leather before it was cool";
    private static final String rarity = "common";
    
    public LeatherArmor(){
        super(name, stat, desc, rarity, 2);
    }
    
    public LeatherArmor(boolean equipped){
        super(name, stat, desc, rarity, 2, equipped);
    }
}

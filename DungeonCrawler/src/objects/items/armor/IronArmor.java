/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.armor;

/**
 *
 * @author hansenc
 */
public class IronArmor extends Armor{
    private static final String name = "Iron Armor";
    private static final String stat = "Defense +2";
    private static final String desc = "Does this make me look fat?";
    private static final String rarity = "common";
    
    public IronArmor(){
        super(name, stat, desc, rarity, 2);
    }
    
    public IronArmor(boolean equipped){
        super(name, stat, desc, rarity, 2, equipped);
    }
}

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
public class CopperArmor extends Armor{
    private static final String name = "Copper Armor";
    private static final String stat = "Defense +1";
    private static final String desc = "You feel like the tin man, but with copper";
    private static final String rarity = "rare";
    
    public CopperArmor(){
        super(name, stat, desc, rarity, 1);
    }
    
    public CopperArmor(boolean equipped){
        super(name, stat, desc, rarity, 1, equipped);
    }
}

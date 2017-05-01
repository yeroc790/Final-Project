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
public class GoldArmor extends Armor{
    private static final String name = "Gold Armor";
    private static final String stat = "Defense +7";
    private static final String desc = "It's rather dashing, but also rather heavy";
    private static final String rarity = "epic";
    
    public GoldArmor(){
        super(name, stat, desc, rarity, 7);
    }
    
    public GoldArmor(boolean equipped){
        super(name, stat, desc, rarity, 7, equipped);
    }
}

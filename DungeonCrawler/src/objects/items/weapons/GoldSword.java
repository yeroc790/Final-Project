/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.weapons;

/**
 *
 * @author hansenc
 */
public class GoldSword extends Weapon{
    private static final String name = "Gold Sword";
    private static final String stat = "Attack +3";
    private static final String desc = "It's a shame it has to get covered in blood";
    private static final String rarity = "rare";
    
    public GoldSword(){
        super(name, stat, desc, rarity, 3);
    }
    
    public GoldSword(boolean equipped){
        super(name, stat, desc, rarity, 3, equipped);
    }
}

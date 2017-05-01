/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.weapons;

/**
 *
 * @author Corey
 */
public class BoneSword extends Weapon{
    private static final String name = "Bone Sword";
    private static final String stat = "Attack +2";
    private static final String desc = "It's going to California, fool!";
    private static final String rarity = "common";
    
    public BoneSword(){
        super(name, stat, desc, rarity, 2);
    }
    
    public BoneSword(boolean equipped){
        super(name, stat, desc, rarity, 2, equipped);
    }
}

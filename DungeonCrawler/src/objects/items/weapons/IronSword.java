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
public class IronSword extends Weapon{
    private static final String name = "Iron Sword";
    private static final String stat = "Attack +2";
    private static final String desc = "It's shiny";
    private static final String rarity = "common";
    
    public IronSword(){
        super(name, stat, desc, rarity, 2);
    }
    
    public IronSword(boolean equipped){
        super(name, stat, desc, rarity, 2, equipped);
    }
}

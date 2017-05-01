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
public class CrossBow extends Weapon{
    private static final String name = "Crossbow";
    private static final String stat = "Attack +6";
    private static final String desc = "Who needs to pull back a bow string when you have levers?";
    private static final String rarity = "rare";
    
    public CrossBow(){
        super(name, stat, desc, rarity, 6);
    }
    
    public CrossBow(boolean equipped){
        super(name, stat, desc, rarity, 6, equipped);
    }
}

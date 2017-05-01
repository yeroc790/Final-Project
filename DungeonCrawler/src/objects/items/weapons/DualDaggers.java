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
public class DualDaggers extends Weapon{
    private static final String name = "Dual Daggers";
    private static final String stat = "Attack +7";
    private static final String desc = "Wanna see me slice up that goblin? Wanna see me do it again?";
    private static final String rarity = "rare";
    
    public DualDaggers(){
        super(name, stat, desc, rarity, 7);
    }
    
    public DualDaggers(boolean equipped){
        super(name, stat, desc, rarity, 7, equipped);
    }
}

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
public class LongBow extends Weapon{
    private static final String name = "Longbow";
    private static final String stat = "Attack +4";
    private static final String desc = "You feel like Robin Hood...not quite as good looking though";
    private static final String rarity = "common";
    
    public LongBow(){
        super(name, stat, desc, rarity, 4);
    }
    
    public LongBow(boolean equipped){
        super(name, stat, desc, rarity, 4, equipped);
    }
}

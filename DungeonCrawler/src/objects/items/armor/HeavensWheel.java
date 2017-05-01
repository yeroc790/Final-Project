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
public class HeavensWheel extends Armor{
    private static final String name = "Heaven's Wheel";
    private static final String stat = "Defense +20";
    private static final String desc = "A gift from the queen of fairies...which reminds you, do fairies have tails?";
    private static final String rarity = "legendary";
    
    public HeavensWheel(){
        super(name, stat, desc, rarity, 20);
    }
    
    public HeavensWheel(boolean equipped){
        super(name, stat, desc, rarity, 20, equipped);
    }
}

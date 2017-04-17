/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.potions;

/**
 *
 * @author Corey
 */
public class GreaterHealing extends Potion{
    private static final String name = "Potion of Greater Healing";
    private static final String stat = "Restores 50 health";
    private static final String desc = "You feel a buzz after drinking it";
    private static final String rarity = "rare";
    
    public GreaterHealing(){
        super(name, stat, desc, rarity, 50);
    }
}

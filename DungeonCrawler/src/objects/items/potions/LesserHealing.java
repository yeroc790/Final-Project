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
public class LesserHealing extends Potion{
    private static final String name = "Potion of Lesser Healing";
    private static final String stat = "Restores 20 health";
    private static final String desc = "Smells funny";
    private static final String rarity = "common";
    
    public LesserHealing(){
        super(name, stat, desc, rarity, 20);
    }
}

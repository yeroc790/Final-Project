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
    
    public LesserHealing(){
        super(name, stat, desc, 20);
    }
    
    public LesserHealing(boolean equipped){
        super(name, stat, desc, 20, equipped);
    }
}

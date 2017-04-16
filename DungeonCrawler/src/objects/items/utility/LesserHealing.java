/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items.utility;

/**
 *
 * @author Corey
 */
public class LesserHealing extends Utility{
    public LesserHealing(){
        super("Lesser Healing Potion", "Restores 20 health");
    }
    
    public LesserHealing(boolean equipped){
        super("Lesser Healing Potion", "Restores 20 health", equipped);
    }
}

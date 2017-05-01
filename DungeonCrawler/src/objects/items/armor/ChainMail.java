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
public class ChainMail extends Armor{
    private static final String name = "Chainmail";
    private static final String stat = "Defense +10";
    private static final String desc = "Now if only you had fan mail.";
    private static final String rarity = "epic";
    
    public ChainMail(){
        super(name, stat, desc, rarity, 10);
    }
    
    public ChainMail(boolean equipped){
        super(name, stat, desc, rarity, 10, equipped);
    }
}

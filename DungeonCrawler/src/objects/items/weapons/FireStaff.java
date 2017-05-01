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
public class FireStaff extends Weapon{
    private static final String name = "Fire Staff";
    private static final String stat = "Attack +12";
    private static final String desc = "On the front it says \"Tim the Enchanter\", on the back it says \"Made in China\"";
    private static final String rarity = "epic";
    
    public FireStaff(){
        super(name, stat, desc, rarity, 12);
    }
    
    public FireStaff(boolean equipped){
        super(name, stat, desc, rarity, 12, equipped);
    }
}

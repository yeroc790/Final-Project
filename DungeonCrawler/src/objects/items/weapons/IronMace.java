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
public class IronMace extends Weapon{
    private static final String name = "Excalibur";
    private static final String stat = "Attack +10";
    private static final String desc = "Sometimes you just wanna bash a skull in with a really large mace";
    private static final String rarity = "epic";
    
    public IronMace(){
        super(name, stat, desc, rarity, 10);
    }
    
    public IronMace(boolean equipped){
        super(name, stat, desc, rarity, 10, equipped);
    }
}

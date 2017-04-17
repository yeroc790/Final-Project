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
public class WoodenSword extends Weapon{
    private static final String name = "Wooden Sword";
    private static final String stat = "Attack +2";
    private static final String desc = "It looks like it's seen better days";
    
    public WoodenSword(){
        super(name, stat, desc,2);
    }
    
    public WoodenSword(boolean equipped){
        super(name, stat, desc, 2, equipped);
    }
}

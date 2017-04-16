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
    public WoodenSword(){
        super("Wooden Sword", "Attack +2");
    }
    
    public WoodenSword(boolean equipped){
        super("Wooden Sword", "Attack +2", equipped);
    }
}

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
public class Excalibur extends Weapon{
    private static final String name = "Excalibur";
    private static final String stat = "Attack +5";
    private static final String desc = "It's going to California, fool!";
    private static final String rarity = "epic";
    
    public Excalibur(){
        super(name, stat, desc, rarity, 5);
    }
    
    public Excalibur(boolean equipped){
        super(name, stat, desc, rarity, 5, equipped);
    }
}

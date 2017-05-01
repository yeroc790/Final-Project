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
public class Morgif extends Weapon{
    //Mullem Desoive Eligh Morgif from Kyo Kara Maoh
    //Reccomended by Janelle Lo
    
    private static final String name = "Morgif";
    private static final String stat = "Attack +20";
    private static final String desc = "Your sword said \"What are you looking at? Haven't you seen a fine piece of weaponry before?\"";
    private static final String rarity = "legendary";
    
    public Morgif(){
        super(name, stat, desc, rarity, 20);
    }
    
    public Morgif(boolean equipped){
        super(name, stat, desc, rarity, 20, equipped);
    }
}

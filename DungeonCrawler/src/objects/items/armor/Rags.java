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
public class Rags extends Armor{
    public Rags(){
        super("Rags", "Defense +0");
    }
    
    public Rags(boolean equipped){
        super("Rags", "Defense +0", equipped);
    }
}

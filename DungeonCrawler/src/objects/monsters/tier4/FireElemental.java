/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier4;

/**
 *
 * @author Corey
 */
public class FireElemental extends Tier4{
    private final int ATTACK = 20;
    private final int DEFENSE = 10;
    private final int HEALTH = 10;
    
    public FireElemental(int row, int col) {
        super(row, col, "Fire Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public FireElemental(){
        super(0,0,"Fire Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

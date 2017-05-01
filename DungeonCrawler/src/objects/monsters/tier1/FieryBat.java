/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier1;

/**
 *
 * @author Corey
 */
public class FieryBat extends Tier1{
    private final int ATTACK = 5;
    private final int DEFENSE = 0;
    private final int HEALTH = 15;
    
    public FieryBat(int row, int col) {
        super(row, col, "Fiery Bat");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public FieryBat(){
        super(0,0,"Fiery Bat");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

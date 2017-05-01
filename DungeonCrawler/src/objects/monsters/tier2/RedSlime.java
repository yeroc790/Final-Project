/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier2;

/**
 *
 * @author Corey
 */
public class RedSlime extends Tier2{
    private final int ATTACK = 8;
    private final int DEFENSE = 0;
    private final int HEALTH = 20;
    
    public RedSlime(int row, int col) {
        super(row, col, "Red Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public RedSlime(){
        super(0,0,"Red Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

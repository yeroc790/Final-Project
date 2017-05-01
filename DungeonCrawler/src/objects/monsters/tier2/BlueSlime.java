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
public class BlueSlime extends Tier2{
    private final int ATTACK = 6;
    private final int DEFENSE = 0;
    private final int HEALTH = 20;
    
    public BlueSlime(int row, int col) {
        super(row, col, "Blue Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public BlueSlime(){
        super(0,0,"Blue Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

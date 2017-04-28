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
public class GreenSlime extends Tier2{
    private final int ATTACK = 10;
    private final int DEFENSE = 0;
    private final int HEALTH = 15;
    
    public GreenSlime(int row, int col) {
        super(row, col, "Green Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public GreenSlime(){
        super(0,0,"Green Slime");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

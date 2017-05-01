/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier3;

/**
 *
 * @author hansenc
 */
public class Goblin extends Tier3{
    private final int ATTACK = 10;
    private final int DEFENSE = 5;
    private final int HEALTH = 15;
    
    public Goblin(int row, int col) {
        super(row, col, "Goblin");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public Goblin(){
        super(0,0,"Goblin");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

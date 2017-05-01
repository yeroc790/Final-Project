/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier3;

/**
 *
 * @author Corey
 */
public class GoblinArcher extends Tier3{
    private final int ATTACK = 12;
    private final int DEFENSE = 0;
    private final int HEALTH = 15;
    
    public GoblinArcher(int row, int col) {
        super(row, col, "Goblin Archer");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public GoblinArcher(){
        super(0,0,"Goblin Archer");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

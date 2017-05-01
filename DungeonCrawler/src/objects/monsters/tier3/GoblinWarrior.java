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
public class GoblinWarrior extends Tier3{
    private final int ATTACK = 10;
    private final int DEFENSE = 5;
    private final int HEALTH = 20;
    
    public GoblinWarrior(int row, int col) {
        super(row, col, "Goblin Warrior");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public GoblinWarrior(){
        super(0,0,"Goblin Warrior");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

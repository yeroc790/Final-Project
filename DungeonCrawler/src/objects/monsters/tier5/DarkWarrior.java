/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier5;

/**
 *
 * @author Corey
 */
public class DarkWarrior extends Tier5{
    private final int ATTACK = 20;
    private final int DEFENSE = 15;
    private final int HEALTH = 25;
    
    public DarkWarrior(int row, int col) {
        super(row, col, "Dark Warrior");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public DarkWarrior(){
        super(0,0,"Dark Warrior");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

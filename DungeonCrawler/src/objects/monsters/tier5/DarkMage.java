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
public class DarkMage extends Tier5{
    private final int ATTACK = 40;
    private final int DEFENSE = 0;
    private final int HEALTH = 20;
    
    public DarkMage(int row, int col) {
        super(row, col, "Dark Mage");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public DarkMage(){
        super(0,0,"Dark Mage");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

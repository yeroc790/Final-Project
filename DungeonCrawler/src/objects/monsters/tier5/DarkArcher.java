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
public class DarkArcher extends Tier5{
    private final int ATTACK = 30;
    private final int DEFENSE = 0;
    private final int HEALTH = 25;
    
    public DarkArcher(int row, int col) {
        super(row, col, "Dark Archer");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public DarkArcher(){
        super(0,0,"Dark Archer");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

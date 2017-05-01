/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier4;

/**
 *
 * @author Corey
 */
public class IceElemental extends Tier4{
    private final int ATTACK = 25;
    private final int DEFENSE = 0;
    private final int HEALTH = 15;
    
    public IceElemental(int row, int col) {
        super(row, col, "Ice Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public IceElemental(){
        super(0,0,"Ice Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

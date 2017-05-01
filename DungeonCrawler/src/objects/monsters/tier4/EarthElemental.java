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
public class EarthElemental extends Tier4{
    private final int ATTACK = 10;
    private final int DEFENSE = 15;
    private final int HEALTH = 15;
    
    public EarthElemental(int row, int col) {
        super(row, col, "Earth Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public EarthElemental(){
        super(0,0,"Earth Elemental");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

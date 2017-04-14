/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier1;

import objects.monsters.tier1.Tier1;

/**
 *
 * @author hansenc
 */
public class CaveBat extends Tier1{
    private final int ATTACK = 3;
    private final double DEFENSE = 0;
    private final int HEALTH = 15;
    
    public CaveBat(int row, int col) {
        super(row, col, "Cave Bat");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public CaveBat(){
        super(0,0,"Cave Bat");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

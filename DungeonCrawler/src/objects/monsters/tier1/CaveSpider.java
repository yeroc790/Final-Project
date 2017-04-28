/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier1;

/**
 *
 * @author Corey
 */
public class CaveSpider extends Tier1{
    private final int ATTACK = 5;
    private final int DEFENSE = 0;
    private final int HEALTH = 15;
    
    public CaveSpider(int row, int col) {
        super(row, col, "Cave Spider");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public CaveSpider(){
        super(0,0,"Cave Spider");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

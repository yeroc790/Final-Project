/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Corey
 */
public class Player extends Character{
    private final int ATTACK = 10;
    private final double DEFENSE = 10;
    private final int HEALTH = 100;
    
    /* -- Begin Constructors -- */
    public Player(){
        super(0, 0, 'P', "player");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    
    public Player(int row, int col){
        super(row, col, 'P', "player");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    /* -- End Accessors -- */
    
    /* -- Begin Custom Methods -- */
    /* -- End Custom Methods -- */
}

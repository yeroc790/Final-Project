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
    /* -- Begin Constructors -- */
    public Player(){
        super(0, 0, 'P', "player");
    }
    
    public Player(int row, int col){
        super(row, col, 'P', "player");
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    /* -- End Accessors -- */
    
    /* -- Begin Custom Methods -- */
    /* -- End Custom Methods -- */
}

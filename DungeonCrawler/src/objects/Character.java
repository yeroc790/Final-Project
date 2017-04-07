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
public class Character extends BoardObject{
    public Character(){
        
    }
    
    public Character(int row, int col, char display, String name){
        super(row, col, display, name);
    }
}

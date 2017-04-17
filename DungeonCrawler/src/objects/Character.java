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
    private int attack;
    private int defense;
    private int health;
    
    public Character(){
        
    }
    
    public Character(int row, int col, char display, String name){
        super(row, col, display, name);
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public void setDefense(int defense){
        this.defense = defense;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public int getHealth(){
        return health;
    }
}

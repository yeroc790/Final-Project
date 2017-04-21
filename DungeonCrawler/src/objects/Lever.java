/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author hansenc
 */
public class Lever extends BoardObject{
    private boolean isPulled;
    
    public Lever(int x, int y){
        super(x, y, 'L', "Lever");
        isPulled = false;
    }
    
    public boolean checkLever(){
        return isPulled;
    }
    
    public void flipLever(boolean bool){
        isPulled = bool;
    }
}

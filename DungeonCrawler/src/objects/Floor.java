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
public class Floor extends BoardObject{
    public Floor(){
        super(0, 0, ' ', "floor");
    }
    
    public Floor(int x, int y){
        super(x, y, ' ', "floor");
    }
}

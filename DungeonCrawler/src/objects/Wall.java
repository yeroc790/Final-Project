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
public class Wall extends BoardObject{
    public Wall(){
        super(0, 0, '#', "wall");
    }
    
    public Wall(int x, int y){
        super(x, y, '#', "wall");
    }
}

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
public class Door extends BoardObject{
    private boolean isOpened;
    
    public Door(int x, int y){
        super(x, y, '|', "Door");
        isOpened = false;
    }
    
    public void openDoor(boolean status){
        isOpened = status;
    }
    
    public boolean checkDoor(){
        return isOpened;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Corey
 */
public class InventoryFullException extends Exception{
    public InventoryFullException(){
        super("Inventory is full");
    }
    
    public InventoryFullException(String message){
        super(message);
    }
}

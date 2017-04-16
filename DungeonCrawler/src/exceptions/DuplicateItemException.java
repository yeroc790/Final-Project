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
public class DuplicateItemException extends Exception{
    public DuplicateItemException(){
        super("You already have that item in your inventory");
    }
    
    public DuplicateItemException(String message){
        super(message);
    }
}

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
public class BoardObject {
    protected int x;
    protected int y;
    private char display; //what the map displays
    private char displayCopy; //because the player map changes things
    private String name;
    
    /* -- Begin Constructors -- */
    public BoardObject(){ //to keep the compiler happy
        x = 0;
        y = 0;
        display = ' ';
        name = "";
        displayCopy = display;
    }
    
    public BoardObject(int x, int y, char display, String name){
        this.x = x;
        this.y = y;
        this.display = display;
        this.name = name;
        displayCopy = this.display;
    }
    
    public BoardObject(int x, int y){
        this.x = x;
        this.y = y;
        display = ' ';
        name = "";
        displayCopy = display;
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public char getDisplay(){
        return display;
    }
    
    public char getDisplayCopy(){
        return displayCopy;
    }
    
    public String getName(){
        return name;
    }
    /* -- End Accessors -- */
    
    /* -- Begin Mutators -- */
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setDisplay(char display){
        this.display = display;
    }
    
    public void setDisplayCopy(char display){
        displayCopy = display;
    }
    
    public void setName(String name){
        this.name = name;
    }
    /* -- End Mutators -- */
}

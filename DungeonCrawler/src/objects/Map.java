/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hansenc
 */
public class Map {
    private static final String DEFAULT_GAME = "test"; //filepath for the text file containing the map setup
    
    private int size; //determines the length and width of the map, probably start at 20 or 50
//    private BoardObject[][] map;
    
    public Map(){
        size = 20;
        //load in default map setup into this.map
//        map = new BoardObject[size][size];
//        loadGame(DEFAULT_GAME);
    }
    
    public void loadGame(String filepath){
        Scanner fileIn = null;
        
        try{
            fileIn = new Scanner(new FileInputStream(filepath)); //I need to make sure that this doesn't create an empty file
        }catch(FileNotFoundException e){
            System.out.println("The game resource file could not be found or opened");
            System.exit(0);
        }
        
        
    } 
}

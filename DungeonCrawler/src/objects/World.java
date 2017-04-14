/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import objects.monsters.Monster;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menus.ChestMenu;
import menus.MonsterMenu;
import objects.monsters.tier1.Tier1;
import resources.Clear;

/**
 *
 * @author hansenc
 */
public class World {
    private static final String DEFAULT_GAME = "src\\resources\\map1.txt"; //filepath for the text file containing the map setup
    private int size; //determines the length and width of the map, probably start at 20 or 50
    private BoardObject[][] map;
    private Player player;
    
    /* -- Begin Constructors -- */
    public World(){
        size = 10;
        map = new BoardObject[size][size];
        loadGame(DEFAULT_GAME);
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    public String getDefaultGame(){
        return DEFAULT_GAME;
    }
    
    public int getSize(){
        return size;
    }
    
    public BoardObject[][] getMap(){
        return Arrays.copyOf(map, map.length);
    }
    /* -- End Accessors -- */
    
    /* -- Begin Setup Methods -- */
    public void loadGame(String filepath){
        Scanner fileIn = null;
        String[] file = new String[size]; 
        String temp;
        
        try{
            fileIn = new Scanner(new FileInputStream(filepath)); //I need to make sure that this doesn't create an empty file
        }catch(FileNotFoundException e){
            System.out.println("The game resource file could not be found or opened");
            System.exit(0);
        }
        
        int index = 0;
        while(fileIn.hasNextLine()){
            temp = fileIn.nextLine();
            file[index] = temp;
            index++;
        }
        char objectChar;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                objectChar = file[row].charAt(col);
                if(objectChar=='P'){
                    player = new Player(row, col);
                    map[row][col] = player;
                }else if(objectChar=='C'){
                    map[row][col] = new Chest(row, col);
                }else if(objectChar=='|'){
                    map[row][col] = new Wall(row, col);
                }else{
                    map[row][col] = new BoardObject(row, col, file[row].charAt(col), "default_name");
                }
                if(objectChar!='P')
                    map[row][col].setDisplayCopy('_');
                
                map[row][col].setX(row);
                map[row][col].setY(col);
            }
        }
    }
    /* -- End Setup Methods -- */
    
    /* -- Begin Movement Methods -- */
    public void movePlayer(char dir ){
        int x = player.getX();
        int y = player.getY();
        
        Clear.clrScreen();
        switch(dir){
            case 'u':
                explore(x-1,y);
                if(canMove('u')){
                    map[x-1][y] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setX(x-1);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x-1,y);
                    displayPlayerMap();
                }
                break;
            case 'd':
                explore(x+1,y);
                if(canMove('d')){
                    map[x+1][y] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setX(x+1);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x+1,y);
                    displayPlayerMap();
                }
                break;
            case 'l':
                explore(x,y-1);
                if(canMove('l')){
                    map[x][y-1] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setY(y-1);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x,y-1);
                    displayPlayerMap();
                }
                break;
            case 'r':
                explore(x,y+1);
                if(canMove('r')){
                    map[x][y+1] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setY(y+1);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x,y+1);
                    displayPlayerMap();
                }
                break;
            default:
                System.out.println("Error: Invalid direction");
                System.exit(0);
        }
    }
    
    public boolean canMove(char dir){
        int x = player.getX();
        int y = player.getY();
        
        switch (dir){
            case 'u':
                if(map[x-1][y].getDisplay()==' '){
                    //empty space
                    return true;
                }else{
                    //something there
                    return false;
                }
            case 'd':
                if(map[x+1][y].getDisplay()==' '){
                    //empty space
                    return true;
                }else{
                    //something there
                    return false;
                }
            case 'l':
                if(map[x][y-1].getDisplay()==' '){
                    //empty space
                    return true;
                }else{
                    //something there
                    return false;
                }
            case 'r':
                if(map[x][y+1].getDisplay()==' '){
                    //empty space
                    return true;
                }else{
                    //something there
                    return false;
                }
            default:
                System.out.println("Error: Invalid direction");
                System.exit(0);
        }
        System.out.println("Error: canMove() provided wrong response");
        return false;
    }
    
    public void explore(int x, int y){
        map[x][y].setDisplayCopy(map[x][y].getDisplay());
    }
    
    public void interact(int x, int y){
        
        switch(map[x][y].getDisplay()){
            case '|':
                System.out.println("\n -- There is a wall blocking your path --\n");
                break;
            case 'C':
                displayPlayerMap();
                ChestMenu.run(map[x][y]);
                break;
            case '1':
                //needs to only run the first time
                if(!(map[x][y] instanceof objects.monsters.tier1.Tier1)){
                    Tier1 randMonster = (Tier1)Tier1.getRandomMonster(); //creating the monster
                    map[x][y] = randMonster;
                }
                //map[x][y] is now of type Tier1
                Tier1 randMonster = (Tier1)map[x][y];
                randMonster.setX(x);
                randMonster.setY(y);
//                randMonster.setDisplay('1');
                System.out.println("RandMonster.display: '" + randMonster.getDisplay() + "'");
                MonsterMenu.run(randMonster); //running the menu
                break;
        }
    }
    /* -- End Movement Methods -- */
    
    /* -- Begin Display Methods -- */
    public void displayMap(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j].getDisplay());
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void displayPlayerMap(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j].getDisplayCopy());
            }
            System.out.println();
        }
        System.out.println();
    }
    /* -- End Display Methods -- */
}

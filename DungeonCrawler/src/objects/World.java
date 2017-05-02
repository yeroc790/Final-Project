/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import main.Credits;
import menus.*;
import objects.monsters.boss.Azmodan;
import objects.monsters.tier1.Tier1;
import objects.monsters.tier2.Tier2;
import objects.monsters.tier3.Tier3;
import objects.monsters.tier4.Tier4;
import objects.monsters.tier5.Tier5;
import resources.Clear;

/**
 *
 * @author hansenc
 */
public class World {
    private static final String path = "src/resources/";
    private static final String[] maps = {path+"map1.txt", path+"map2.txt", path+"map3.txt", path+"map4.txt", path+"map5.txt", path+"boss.txt"};
//    private static final String[] maps = {path+"levelTest.txt"};
    private static final String DEFAULT_GAME = maps[0]; //filepath for the text file containing the map setup
    private int currentLevel;
    private int rows;
    private int cols;
    private BoardObject[][] map;
    private Player player;
    private Door door;
    private Lever lever;
//    private SwingGUI window; //deprecated
    
    /* -- Begin Constructors -- */
    public World(){
        loadGame(DEFAULT_GAME);
        currentLevel = 0;
    }
    
    public World(String file){
        loadGame(file);
        currentLevel = 0;
    }
    
    public World(int level){
        loadGame(maps[level]);
        currentLevel = level;
    }
    /* -- End Constructors -- */
    
    /* -- Begin Accessors -- */
    public String getDefaultGame(){
        return DEFAULT_GAME;
    }
    
    public int getRows(){
        return rows;
    }
    
//    public int getCols(){
//        return cols;
//    }
    
    public BoardObject[][] getMap(){
        return Arrays.copyOf(map, map.length);
    }
    
    public Player getPlayer(){
        return player;
    }
    /* -- End Accessors -- */
    
    /* -- Begin Mutators -- */
    public void setMap(BoardObject[][] map){
        this.map = Arrays.copyOf(map, map.length);
    }
    /* -- End Mutators -- */
    
    /* -- Begin Setup Methods -- */
    public void loadGame(String filepath){
        Scanner fileIn = null;
        String[] file;
        String temp;
        
        try{
            fileIn = new Scanner(new FileInputStream(filepath)); //I need to make sure that this doesn't create an empty file
        }catch(FileNotFoundException e){
            System.out.println("The game resource file could not be found or opened");
            System.exit(0);
        }
        
        getSize(filepath);
        file = new String[rows];
        map = new BoardObject[rows][cols];
        
        int index = 0;
        while(fileIn.hasNextLine()){
            temp = fileIn.nextLine();
            file[index] = temp;
            index++;
        }
        
        char objectChar;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                objectChar = file[row].charAt(col);
                switch(objectChar){
                    case 'P':
                        if(currentLevel==0)
                            player = new Player(row, col);
                        map[row][col] = player;
                        player.setX(row);
                        player.setY(col);
                        break;
                    case '#':
                        map[row][col] = new Wall(row, col);
                        break;
                    case 'C':
                        map[row][col] = new Chest(row, col);
                        break;
                    case 'L':
                        map[row][col] = new Lever(row, col);
                        lever = (Lever)map[row][col];
                        break;
                    case '|':
                        map[row][col] = new Door(row, col);
                        door = (Door)map[row][col];
                        break;
                    case ' ':
                        map[row][col] = new Floor(row, col);
                        break;
                    case '1':
                        Tier1 randMonster1 = (Tier1)Tier1.getRandomMonster(row,col); //creating the monster
                        map[row][col] = randMonster1;
                        break;
                    case '2':
                        Tier2 randMonster2 = (Tier2)Tier2.getRandomMonster(row,col); //creating the monster
                        map[row][col] = randMonster2;
                        break;
                    case '3':
                        Tier3 randMonster3 = (Tier3)Tier3.getRandomMonster(row,col); //creating the monster
                        map[row][col] = randMonster3;
                        break;
                    case '4':
                        Tier4 randMonster4 = (Tier4)Tier4.getRandomMonster(row,col); //creating the monster
                        map[row][col] = randMonster4;
                        break;
                    case '5':
                        Tier5 randMonster5 = (Tier5)Tier5.getRandomMonster(row,col); //creating the monster
                        map[row][col] = randMonster5;
                        break;
                    case 'B':
                        Azmodan boss = new Azmodan(row,col);
                        map[row][col] = boss;
                        break;
                    default:
                        map[row][col] = new BoardObject(row, col, file[row].charAt(col), "default_name");
                        break;
                }
                if(objectChar!='P')
                    map[row][col].setDisplayCopy('*');
                
                map[row][col].setX(row);
                map[row][col].setY(col);
            }
        }
        explore(player.getX(), player.getY());
    }
    /* -- End Setup Methods -- */
    
    /* -- Begin Movement Methods -- */
    public void movePlayer(char dir){
        int x = player.getX();
        int y = player.getY();
        
        Clear.clrScreen();
        switch(dir){
            case 'u':
                if(canMove('u')){
                    map[x-1][y] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setX(x-1);
                    explore(x-1,y);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x-1,y);
                    displayPlayerMap();
                }
                break;
            case 'd':
                if(canMove('d')){
                    map[x+1][y] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setX(x+1);
                    explore(x+1,y);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x+1,y);
                    displayPlayerMap();
                }
                break;
            case 'l':
                if(canMove('l')){
                    map[x][y-1] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setY(y-1);
                    explore(x,y-1);
                    displayPlayerMap();
                }else{
                    Clear.clrScreen();
                    interact(x,y-1);
                    displayPlayerMap();
                }
                break;
            case 'r':
                if(canMove('r')){
                    map[x][y+1] = player;
                    map[x][y] = new BoardObject(x, y);
                    player.setY(y+1);
                    explore(x,y+1);
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
        /* -- To explore in a circle around the player -- */
        //left of player
        try{
            map[x-1][y].setDisplayCopy(map[x-1][y].getDisplay());
        }catch(Exception e){};
        
        //above and left of player
        try{
            map[x-1][y-1].setDisplayCopy(map[x-1][y-1].getDisplay());
        }catch(Exception e){};
        
        //above player
        try{
            map[x][y-1].setDisplayCopy(map[x][y-1].getDisplay());
        }catch(Exception e){};
        
        //above and right of player
        try{
            map[x+1][y-1].setDisplayCopy(map[x+1][y-1].getDisplay());
        }catch(Exception e){};
        
        //right of player
        try{
            map[x+1][y].setDisplayCopy(map[x+1][y].getDisplay());
        }catch(Exception e){};
        
        //below and right of player
        try{
            map[x+1][y+1].setDisplayCopy(map[x+1][y+1].getDisplay());
        }catch(Exception e){};
        
        //below player
        try{
            map[x][y+1].setDisplayCopy(map[x][y+1].getDisplay());
        }catch(Exception e){};
        
        //below and left of player
        try{
            map[x-1][y+1].setDisplayCopy(map[x-1][y+1].getDisplay());
        }catch(Exception e){};
    }
    
    public void interact(int x, int y){
        switch(map[x][y].getDisplay()){
            case '#':
                System.out.println("\n -- There is a wall blocking your path --\n");
                break;
            case 'C':
                displayPlayerMap();
                ChestMenu.run(map[x][y], player);
                break;
            case '1':
                Tier1 randMonster = (Tier1)map[x][y];
                MonsterMenu.run(randMonster, getPlayer()); //running the menu
                break;
            case '2':
                Tier2 randMonster2 = (Tier2)map[x][y];
                MonsterMenu.run(randMonster2, getPlayer()); //running the menu
                break;
            case '3':
                Tier3 randMonster3 = (Tier3)map[x][y];
                MonsterMenu.run(randMonster3, getPlayer());
                break;
            case '4':
                Tier4 randMonster4 = (Tier4)map[x][y];
                MonsterMenu.run(randMonster4, getPlayer());
                break;
            case '5':
                Tier5 randMonster5 = (Tier5)map[x][y];
                MonsterMenu.run(randMonster5, getPlayer());
                break;
            case 'B':
                Azmodan boss = (Azmodan)map[x][y];
                MonsterMenu.run(boss, getPlayer());
                break;
            case '|':
                if(door.checkDoor()){
                    //door is open
                    currentLevel++;
                    if(currentLevel>=maps.length){
                        System.out.println("You have defeated Azmodan and escaped the Dungeon!");
                        Credits.rollCredits();
                        System.exit(0);
                    }else{
                        System.out.println("Congratulations, you beat the level");
                        loadGame(maps[currentLevel]);   
                    }   
                }else{
                    System.out.println("This door is locked. Maybe there's a lever somewhere nearby...");
                }
                break;
            case 'L':
                if(lever.checkLever()){
                    //lever is pulled
                    System.out.println("You already pulled that lever, go find the door it opened");
                }else{
                    System.out.println("You pull the lever and hear the faint groaning of large doors swinging open");
                    door.openDoor(true);
                    lever.flipLever(true);
                }
                break;
        }
    }
    /* -- End Movement Methods -- */
    
    /* -- Begin Display Methods -- */
    public void displayMap(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j].getDisplay());
            }
            System.out.println();
        }
        System.out.println();
//        window.displayText(mapString());
    }
    
    public void displayPlayerMap(){
        System.out.println("\n------ Level " + (currentLevel+1) + " ------\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j].getDisplayCopy());
            }
            System.out.println();
        }
        System.out.println();
//        window.displayText(playerMapString());
    }
    
    public String mapString(){
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s+=(map[i][j].getDisplay());
            }
            s+="\n";
        }
        s+="\n";
        return s;
    }
    
    public String playerMapString(){
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s+=(map[i][j].getDisplayCopy());
            }
            s+="\n";
        }
        s+="\n";
        return s;
    }
    /* -- End Display Methods -- */
    
    public void getSize(String filepath){
        Scanner fileIn = null;
        try{
            fileIn = new Scanner(new FileInputStream(filepath)); //I need to make sure that this doesn't create an empty file
        }catch(FileNotFoundException e){
            System.out.println("The game resource file could not be found or opened");
            System.exit(0);
        }
        
        String temp;
        int rows = 0;
        int cols = 0;
        while(fileIn.hasNextLine()){
            temp = fileIn.nextLine();
            cols = temp.length();
            rows++;
        }
        
        this.rows = rows;
        this.cols = cols;
    }
    
    /* -- Begin GUI Methods (Deprecated) -- */
    public void foo(){ //hides block of deprecated code
//    public World(SwingGUI window){
//        size = 10;
//        map = new BoardObject[size][size];
//        loadGame(DEFAULT_GAME);
//        this.window = window;
//    }
    
//    public World(String file, SwingGUI window){
//        size = 10;
//        map = new BoardObject[size][size];
//        loadGame(file);
//        this.window = window;
//    }
    
//    public void addWindow(SwingGUI window){
//        this.window = window;
//    }
    
//    public void playerMapGUI(){
//        window.displayGame(playerMapString());
//    }
    
//    public void mapGUI(){
//        window.displayGame(mapString());
//    }
    
//    public void movePlayerGUI(char dir, SwingGUI window, KeyEvent e){
//        int x = player.getX();
//        int y = player.getY();
//        
//        switch(dir){
//            case 'u':
//                explore(x-1,y);
//                if(canMove('u')){
//                    map[x-1][y] = player;
//                    map[x][y] = new BoardObject(x, y);
//                    player.setX(x-1);
//                }else{
//                    interactGUI(x-1,y, window, e);
//                }
//                playerMapGUI();
//                break;
//            case 'd':
//                explore(x+1,y);
//                if(canMove('d')){
//                    map[x+1][y] = player;
//                    map[x][y] = new BoardObject(x, y);
//                    player.setX(x+1);
//                }else{
//                    interactGUI(x+1,y,window, e);
//                }
//                playerMapGUI();
//                break;
//            case 'l':
//                explore(x,y-1);
//                if(canMove('l')){
//                    map[x][y-1] = player;
//                    map[x][y] = new BoardObject(x, y);
//                    player.setY(y-1);
//                }else{
//                    interactGUI(x,y-1,window, e);
//                }
//                playerMapGUI();
//                break;
//            case 'r':
//                explore(x,y+1);
//                if(canMove('r')){
//                    map[x][y+1] = player;
//                    map[x][y] = new BoardObject(x, y);
//                    player.setY(y+1);
//                }else{
//                    interactGUI(x,y+1,window, e);
//                }
//                playerMapGUI();
//                break;
//            default:
//                System.out.println("Error: Invalid direction");
//                System.exit(0);
//        }
//    }
    
//    public void interactGUI(int x, int y, SwingGUI window, KeyEvent e){
//        switch(map[x][y].getDisplay()){
//            case '#':
//                window.displayText("\n -- There is a wall blocking your path --\n");
//                break;
//            case 'C':
//                window.displayGame(playerMapString());
//                window.setMenu(window.CHEST_MENU);
//                ChestMenu.runGUI(map[x][y], player, window, e);
//                window.setMenu(window.MAIN_MENU);
//                break;
//            case '1':
//                //needs to only run the first time
//                if(!(map[x][y] instanceof objects.monsters.tier1.Tier1)){ //if the object is not a specified monster
//                    Tier1 randMonster = (Tier1)Tier1.getRandomMonster(x,y); //creating the monster
//                    map[x][y] = randMonster;
//                }
//                //map[x][y] is now of type Tier1
//                Tier1 randMonster = (Tier1)map[x][y];
//                window.setMenu(window.CHEST_MENU);
//                MonsterMenu.runGUI(randMonster, getPlayer(), window, e); //running the menu
//                window.setMenu(window.MAIN_MENU);
//                break;
//        }
//    }
    }
    /* -- End GUI Methods -- */
}

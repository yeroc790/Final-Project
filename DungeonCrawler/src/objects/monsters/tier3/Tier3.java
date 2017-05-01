/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier3;

import java.util.Random;
import objects.monsters.Monster;

/**
 *
 * @author Corey
 */
public class Tier3 extends Monster{
    public Tier3(int row, int col, String name) {
        super(row, col, '3', name);
    }
    
    public Tier3(){
        super(0,0,'3',"Test");
    }
    
    public static Object getRandomMonster(int x, int y){
        String path = "objects.monsters.tier3.";
        String monsterNames[] = {path+"Goblin", path+"GoblinArcher", path+"GoblinWarrior"};
        Random r = new Random();
        int low = 0;
        int high = monsterNames.length;
        int rand = r.nextInt(high-low) + low;
        
        try{
            Tier3 object = (Tier3)Class.forName(monsterNames[rand]).newInstance();
            object.setX(x);
            object.setY(y);
            return object;
        }catch(ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }catch(InstantiationException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }catch(IllegalAccessException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        
        //too keep compiler happy
        Object foo = new Object();
        return foo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.tier1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import objects.monsters.Monster;

/**
 *
 * @author hansenc
 */
public class Tier1 extends Monster{
    public Tier1(int row, int col, String name) {
        super(row, col, '1', name);
    }
    
    public Tier1(){
        super(0,0,'1',"Test");
    }
    
    public static Object getRandomMonster(){
        String path = "objects.monsters.tier1.";
        String monsterNames[] = {path+"Goblin", path+"CaveBat"};
        Random r = new Random();
        int low = 0;
        int high = monsterNames.length;
        int rand = r.nextInt(high-low) + low;
        
    //    Class<?> c = Class.forName("mypackage.MyClass");
    //    Constructor<?> cons = c.getConstructor(String.class);
    //    Object object = cons.newInstance("MyAttributeValue");
        try{
//            Class<?> c = Class.forName(monsterNames[rand]);
//            Constructor<?> cons = c.getConstructor();
//            Object object = cons.newInstance();
            Tier1 object = (Tier1)Class.forName(monsterNames[rand]).newInstance(); //running through the Tier1 constructor, not the Goblin or CaveBat constructors
            return object;
        }catch(ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
//        }catch(NoSuchMethodException e){
//            System.out.println("Error: " + e.getMessage());
//            System.exit(0);
        }catch(InstantiationException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }catch(IllegalAccessException e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
//        }catch(InvocationTargetException e){
//            System.out.println("Error: " + e.getMessage());
//            System.exit(0);
        }
        
        //too keep compiler happy
        Object foo = new Object();
        return foo;
    }
    
    public void doFoo(){
        System.out.println("Foo");
    }
}

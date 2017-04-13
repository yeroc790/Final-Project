/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.monsters.Monster;
import objects.monsters.tier1.Tier1;

/**
 *
 * @author hansenc
 */
public class MonsterMenu {
    public static void run(Tier1 monster){
        System.out.println("\n-- There is a " + monster.getName() + " blocking your path! --");
        monster.doFoo();
    }
}

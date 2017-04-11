/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import objects.monsters.Monster;
import objects.monsters.tier1.Tier1;

/**
 *
 * @author hansenc
 */
public class MonsterMenu {
    public static void run(Monster monster){
        Tier1.getRandomMonster();
    }
}

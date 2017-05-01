/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.boss;

import objects.monsters.Monster;

/**
 *
 * @author Corey
 */
public class Boss extends Monster{
    public Boss(int row, int col, String name) {
        super(row, col, 'B', name);
    }
}

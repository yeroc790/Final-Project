/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.monsters.boss;

/**
 *
 * @author Corey
 */
public class Azmodan extends Boss{ //Azmodan, Hope's End
    private final int ATTACK = 40;
    private final int DEFENSE = 10;
    private final int HEALTH = 30;

    public Azmodan(int row, int col) {
        super(row, col, "Azmodan, Hope's End");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }

    public Azmodan(){
        super(0,0,"Azmodan, Hope's End");
        setAttack(ATTACK);
        setDefense(DEFENSE);
        setHealth(HEALTH);
    }
}

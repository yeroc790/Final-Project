/*
 * Notes: World creates an object of type player, everything is run through the map object, or the map.player object
 */
package main;
import objects.*;
import menus.*;

/**
 *
 * @author Corey
 */
public class main {
    public static void main(String[] args) {
        menus.MainMenu.run("src\\resources\\objectTest.txt");
    }
}

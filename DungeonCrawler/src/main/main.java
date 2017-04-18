/*
 * Notes: World creates an object of type player, everything is run through the map object, or the map.player object
 */
package main;

import swing.KeyEventTest;

/**
 *
 * @author Corey
 */
public class main {
    public static void main(String[] args) {
//        menus.MainMenu.run("src\\resources\\objectTest.txt");
//        menus.MainMenu.run("");
//        swing.SwingDemo.main(args);
//        swing.SwingTest.run();
//        swing.KeyEventDemo.main(args);
        KeyEventTest test = new KeyEventTest("test");
        menus.MainMenu.run("", test);
    }
}

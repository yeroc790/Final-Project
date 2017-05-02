/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.Clear;

/**
 *
 * @author Corey
 */
public class Credits {
    public static void rollCredits(){
       Clear.clrScreen();
       Clear.clrScreen();
       
        System.out.println("-- Credits --");
        lineUp(3);
        System.out.println("Design by Corey Hansen");
        lineUp(3);
        System.out.println("Programming by Corey Hansen");
        lineUp(3);
        System.out.println("Food provided by Corey Hansen");
        lineUp(3);
        System.out.println("Special Thanks to:");
        System.out.println("StackOverflow, Google, Janelle Lo");
        lineUp(70);
        System.out.println("Thanks for playing!");
    }
    
    private static void lineUp(int num){
        for(int i=0; i<num; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println();
        }
    }
}

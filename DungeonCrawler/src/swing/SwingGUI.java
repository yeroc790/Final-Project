/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Corey
 */
public class SwingGUI   extends JFrame 
                            implements KeyListener,
                                       ActionListener
{
    JTextArea gameArea;
    JTextField typingArea;
    JTextArea textArea;
    JLabel titleArea;
    static final String newline = System.getProperty("line.seperator");
    private char lastChar;
    private int menu; //0 MainMenu, 1 MonsterMenu, 2 InventoryMenu, 3 ChestMenu
    
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI(){
        //Create and set up the window.
//        KeyEventTest frame = new KeyEventTest("KeyEventTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane();
        setSize(600,400);
        //Display the window.
//        frame.pack();
        setVisible(true);
//        menus.MainMenu.run("");
    }
    
    private void addComponentsToPane(){
        JButton button = new JButton("Start Game");
        button.addActionListener(this);
        
        JPanel topArea = new JPanel();
        topArea.setLayout(new GridLayout(2,1));
        
        
        titleArea = new JLabel("-- Welcome to the Dungeon --");
        titleArea.setHorizontalAlignment(JLabel.CENTER);
        
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        gameArea = new JTextArea();
        gameArea.setEditable(false);
        gameArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        
        topArea.add(titleArea);
        topArea.add(typingArea);
        
        getContentPane().add(topArea, BorderLayout.PAGE_START);
//        getContentPane().add(typingArea, BorderLayout.PAGE_END);
//        getContentPane().add(titleArea, BorderLayout.PAGE_START, SwingConstants.CENTER);
        getContentPane().add(gameArea, BorderLayout.CENTER);
        getContentPane().add(textArea, BorderLayout.PAGE_END);
    }
    
    public SwingGUI(String gameFile){
        super("Dungeon Crawler");
        createAndShowGUI();
        startGame(gameFile);
        menu = 0;
    }
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e){
        processInput(e);
    }
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e){

    }
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e){
        
    }
    
    /** Handle the button click. */
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void processInput(KeyEvent e){
        typingArea.setText("");
        typingArea.requestFocusInWindow();

        switch(menu){ //menu needs to be set to determine where input goes
            case 0:
                menus.MainMenu.guiInput(e, this);
                break;
        }
        
    }
    
    private void startGame(String gameFile){
        menus.MainMenu.runGUI(gameFile, this);
    }
    
    public void displayGame(String text){
        gameArea.setText(text);
    }
    
    public void displayText(String text){
        textArea.setText(text);
    }
    
    public void displayTitle(String text){
        titleArea.setText(text);
    }
    
    public char nextChar(){
        return lastChar;
    }
    
    public int getMenu(){
        return menu;
    }
    
    public void setMenu(int menu){
        this.menu = menu;
    }
}

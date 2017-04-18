/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Corey
 */
public class KeyEventTest   extends JFrame 
                            implements KeyListener,
                                       ActionListener
{
    JTextArea displayArea;
    JTextField typingArea;
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
        
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        
        
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(displayArea, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
    }
    
    public KeyEventTest(String name){
        super(name);
        createAndShowGUI();
        startGame();
        menu = 0;
    }
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e){
//        displayInfo(e, "KEY TYPED: ");
//        processInput(e);
        processInput(e);
    }
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e){
//        displayInfo(e, "KEY PRESSED: ");
    }
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e){
//        displayInfo(e, "KEY RELEASED: ");
    }
    
    /** Handle the button click. */
    public void actionPerformed(ActionEvent e){
        //Clear the text components.
//        displayArea.setText("");
//        typingArea.setText("");
        
        //Return the focus to the typing area.
//        typingArea.requestFocusInWindow();
    }
    
    public void processInput(KeyEvent e){
//        char c = e.getKeyChar();
//        displayArea.setText("You typed '" + c + "'");
        typingArea.setText("");
        typingArea.requestFocusInWindow();
//        lastChar = c;

        switch(menu){ //menu needs to be set to determine where input goes
            case 0:
                menus.MainMenu.processInput(e, this);
                break;
        }
        
    }
    
    private void startGame(){
        displayArea.setText("Welcome to the Dungeon");
    }
    
    public void displayText(String text){
        displayArea.setText(text);
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

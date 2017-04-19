/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import objects.Player;

/**
 *
 * @author Corey
 */
public class SwingGUI   extends JFrame 
                            implements KeyListener,
                                       ActionListener
{
    JTextPane gameArea;
    JTextField typingArea;
    JTextPane textArea;
    JLabel titleArea;
    static final String newline = System.getProperty("line.seperator");
    private char lastChar;
    private int menu; //0 MainMenu, 1 MonsterMenu, 2 InventoryMenu, 3 ChestMenu
    public static final int MAIN_MENU = 0, MONSTER_MENU = 1, INVENTORY_MENU = 2, CHEST_MENU = 3;
    
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI(){
        //Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane();
        setSize(400,560);
        
        if( !isVisible( ) )
            setVisible( true );
        setExtendedState( JFrame.NORMAL );
        toFront( );
        setAlwaysOnTop( true );
        try
        {
            final Point oldMouseLocation = MouseInfo.getPointerInfo( ).getLocation( );

            // simulate a mouse click on title bar of window
            Robot robot = new Robot( );
            robot.mouseMove( getX( ) + 100, getY( ) + 10 );
            robot.mousePress( InputEvent.BUTTON1_DOWN_MASK );
            robot.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );

            // move mouse to old location
            robot.mouseMove( (int) oldMouseLocation.getX( ), (int) oldMouseLocation.getY( ) );
        }
        catch( Exception ex )
        {}
        finally
        {
            setAlwaysOnTop( false );
        }
    }
    
    private void addComponentsToPane(){
        JButton button = new JButton("Start Game");
        button.addActionListener(this);
        
        JPanel topArea = new JPanel();
        topArea.setLayout(new GridLayout(2,1));
        
        
        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontFamily(aSet, "courier new");
        StyleConstants.setFontSize(aSet, 24);
        
        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontFamily(bSet, "lucida typewriter");
        StyleConstants.setFontSize(bSet, 18);
        
        
        
        titleArea = new JLabel("-- Welcome to the Dungeon --");
        titleArea.setHorizontalAlignment(JLabel.CENTER);
        
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
        
        gameArea = new JTextPane();
        gameArea.setEditable(false);
        gameArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        
        
        textArea = new JTextPane();
        textArea.setEditable(false);
        
        StyledDocument textDoc = textArea.getStyledDocument();
        textDoc.setCharacterAttributes(105, textDoc.getLength()-105, bSet, false);
        textDoc.setParagraphAttributes(0, 104, bSet, false);
        
        StyledDocument gameDoc = gameArea.getStyledDocument();
        gameDoc.setCharacterAttributes(105, gameDoc.getLength()-105, aSet, false);
        gameDoc.setParagraphAttributes(0, 104, aSet, false);
        
        
        topArea.add(titleArea);
        topArea.add(typingArea);
        
        getContentPane().add(topArea, BorderLayout.PAGE_START);
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
        
        if(e.getKeyChar()=='0'){
            System.exit(0);
        }else if(e.getKeyChar()=='8'){
            displayText("menu currently selected: " + menu);
        }else if(e.getKeyChar()=='9'){
            getFrameSize();
        }
        switch(menu){ //menu needs to be set to determine where input goes
            case MAIN_MENU:
                menus.MainMenu.guiInput(e, this);
                break;
            case INVENTORY_MENU:
                menus.InventoryMenu.guiInput(e, this);
                setMenu(MAIN_MENU);
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
    
    public void getFrameSize(){
        Rectangle r = getBounds();
        int h = r.height;
        int w = r.width;
        displayText("height: " + h + ", width: " + w);
    }
}

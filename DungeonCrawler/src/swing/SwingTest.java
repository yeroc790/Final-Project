/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Corey
 */
public class SwingTest extends JFrame implements ActionListener{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_CHAR = 30;
    
    private JTextField name;
    private JLabel nameLabel;
    
    public static void run(){
        SwingTest gui = new SwingTest();
        gui.setVisible(true);
    }
    
    public SwingTest(){
        super("Swing Test");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        namePanel.setBackground(Color.WHITE);
        
        name = new JTextField(NUMBER_OF_CHAR);
        namePanel.add(name, BorderLayout.SOUTH);
        nameLabel = new JLabel("Enter your name here:");
        namePanel.add(nameLabel, BorderLayout.CENTER);
        
        add(namePanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.BLUE);
        JButton actionButton = new JButton("Click Me");
        actionButton.addActionListener(this);
        buttonPanel.add(actionButton);
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        
        add(buttonPanel);
    }
    
    public void actionPerformed(ActionEvent e){
        String actionCommand = e.getActionCommand();
        
        if(actionCommand.equals("Click Me")){
//            name.setText("Hello " + name.getText());
            if(name.getText().length()>0)
                nameLabel.setText("Enter your name here: Hello " + name.getText());
        }else if(actionCommand.equals("Clear")){
            nameLabel.setText("Enter your name here:");
            name.setText("");
        }else
            name.setText("Unexpected error.");
    }
}

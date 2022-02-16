/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.todo;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author steven
 */
public class TODOListApplication extends JFrame {
    
    public TODOListApplication() {
        init();
    }
    
    private void init() {
        setTitle("JAD TODO List App v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        
        // Create our panels
        //
        ToDoEntryPanel toDoEntryPanel = new ToDoEntryPanel();
        
        add(toDoEntryPanel);
        
        ToDoListingPanel toDoListingPanel = new ToDoListingPanel();
        
        add(toDoListingPanel);
        
        // Connect the entry panel to the listing panel
        //
        toDoEntryPanel.addSubmitToDoListener(toDoListingPanel);
        
        pack();
    }
       
    public static void main(String[] args) {
        new TODOListApplication().setVisible(true);
    }
    
}

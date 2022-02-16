/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.todo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author steven
 */
public class ToDoEntryPanel extends JPanel {
        
    // List to store all the listeners of new ToDo entries
    //
    private List<SubmitToDoListener> submitToDoListeners = new ArrayList<>();
    
    public ToDoEntryPanel() {
        super();
        init();
    }
    
    private void init() {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBorder(BorderFactory.createTitledBorder("New TODO"));
        
        // Add a title and description text field
        //
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setPreferredSize(new Dimension(200, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleLabel);
        

        JTextField titleTextField = new JTextField("", 20);
        this.add(titleTextField);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setPreferredSize(new Dimension(200, 30));
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);        
        this.add(descriptionLabel);
        
        JTextField descriptionTextField = new JTextField("", 20);
        this.add(descriptionTextField);
        
        // Add a button
        JButton addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(200, 30));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleText = titleTextField.getText(),
                        descriptionText = descriptionTextField.getText();
                
                if(titleText.isBlank() || descriptionText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "TODO entry is empty", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // Create a new ToDo
                    ToDo newToDo = new ToDo(titleText, descriptionText);
                    
                    for(SubmitToDoListener listener : submitToDoListeners) {
                        listener.newToDoEntry(newToDo);
                    }
                
                    // Clear the text fields
                    titleTextField.setText("");
                    descriptionTextField.setText("");
                }
            }
        });
        this.add(addButton);        
    }
    
    // addSubmitToDoListener
    //
    // Adds a reference to an object that implemented the SubmitToDoListener interface
    // to the collection.
    //
    public void addSubmitToDoListener(SubmitToDoListener listener) {
        if(!submitToDoListeners.contains(listener))
            submitToDoListeners.add(listener);
    }
}

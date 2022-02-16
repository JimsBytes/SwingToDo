/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.todo;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author steven
 */
public class ToDoListingPanel extends JPanel implements SubmitToDoListener {
    
    private JPanel todoListing = new JPanel();
    
    public ToDoListingPanel() {
        super();
        
        init();
    }
    
    private void init() {
        
        todoListing.setLayout(new BoxLayout(todoListing, BoxLayout.Y_AXIS));
        
        // Create a scroll pane with the vertical scroll bar always
        // visible.
        JScrollPane sp = new JScrollPane(todoListing);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.add(sp);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(400, 600));        
    }

    @Override
    public void newToDoEntry(ToDo newToDo) {
        String labelText =
                String.format(
                    "<html><body style='width=380px'>"
                            + "ToDo Title: %s<br><br>"
                            + "%s<br><br>"
                            + "Complete %d%%"
                            + "<hr>"
                            + "</body></html>",
                    newToDo.getTitle(),
                    newToDo.getDescription(),
                    newToDo.getPercentageComplete());
        
        JLabel newToDoLabel = new JLabel(labelText);
        
        todoListing.add(newToDoLabel);
        
        todoListing.updateUI();
    }
    
    
    
}

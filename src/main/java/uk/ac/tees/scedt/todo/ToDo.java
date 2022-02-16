/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.scedt.todo;

/**
 *
 * @author steven
 */
public class ToDo {
    private String title;
    private String description;
    private int percentageComplete = 0;
    
    public ToDo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(int percentageComplete) {
        if(percentageComplete >= 0 && percentageComplete <= 100)
            this.percentageComplete = percentageComplete;
    }
    
}

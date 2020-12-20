/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

/**
 *
 * @author turqo
 */
public class Event {
    
 
        
    private String month;
    private String day;
    private String year;
    private String time;
    private String description;
    
    public Event(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        month = passedMonth;
        day = passedDay;
        year = passedYear;
        time = passedTime;
        description = passedDescription;
    }
    
}

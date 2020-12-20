/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author turqo
 */
public class EventHandler {
    //this will hold an arrayList of events and deal with high level functions
    //this class will have functions that start: add event, remove event, list events
    //change events, save events(when the user wants to quit), load events(when the program starts up)
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public EventHandler(){
        
    }
    
    public void AddEvent(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        eventList.add(new Event(passedMonth, passedDay, passedYear, passedTime, passedDescription));
    }
    
    public void RemoveEvent(int indexOfEventToRemove){
        
    }
    
}

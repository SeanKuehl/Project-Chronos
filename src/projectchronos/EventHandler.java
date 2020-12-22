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
    
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public EventHandler(){
        
    }
    
    
    
    public void AddEvent(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        //this one is for adding events from user input
        eventList.add(new Event(passedMonth, passedDay, passedYear, passedTime, passedDescription));
    }
    
    public void AddEvent(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription, int id){
        //this one is for adding events read from a file with their id
        eventList.add(new Event(passedMonth, passedDay, passedYear, passedTime, passedDescription, id));
    }
    
    public void RemoveEvent(int idNumberOfEventToRemove){
        int eventIdNumber = 0;
        
        
        for (int i = 0; i<eventList.size();i++){
            eventIdNumber = eventList.get(i).GetId();
            
            if (eventIdNumber == idNumberOfEventToRemove){
                eventList.remove(i);  //this remove the element at index i
            }
        }
        
    }
    
    public ArrayList<Event> GetEventList(){
        //this is for listing events on list events panel
        return eventList;
    }
    
    public void SaveEvents(){
        
        if (eventList.size() == 0){
            //there are no events to save, do nothing.
        }
        else {
            int firstElementIndex = 0;
            int idBase = eventList.get(firstElementIndex).GetIdBase();  //here using first element, but could use any because they all have the same static id base
            
            FileHandler fh = new FileHandler();
            fh.SaveEventsToFile(eventList, idBase);
        }
        
    }
    
    public void LoadEvents(){
        //also sets the IdBase of the Event class
        FileHandler fh = new FileHandler();
        if (fh.CheckIfFileEmpty()){
            //then the file was empty, nothing to load
        }
        else {
            //load what is there from file
            fh.ReadEventsFromFile();
        }
        
    }
    
    public void SetEventIdBase(int idBase){
        Event event = new Event();
        event.SetIdBase(idBase);
    }
    
    
    
}

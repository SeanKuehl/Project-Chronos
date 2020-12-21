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
    
    public void PrintEvents(){
        for (int i = 0; i< eventList.size();i++){
            eventList.get(i).PrintThis();
        }
    }
    
    public void AddEvent(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        eventList.add(new Event(passedMonth, passedDay, passedYear, passedTime, passedDescription));
    }
    
    public void AddEvent(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription, int id){
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
        return eventList;
    }
    
    public void SaveEvents(){
        
        if (eventList.size() == 0){
            
        }
        else {
            int idBase = eventList.get(0).GetIdBase();
            FileHandler fh = new FileHandler();
            fh.SaveEventsToFile(eventList, idBase);
        }
        
    }
    
    public void LoadEvents(){
        //also sets the IdBase of the Event class
        FileHandler fh = new FileHandler();
        fh.ReadEventsFromFile();
    }
    
    
    
}

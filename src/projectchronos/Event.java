/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import java.io.FileWriter;
import java.io.IOException;

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
    private int idNumber;
    private static int idBase = 0; //so the first event's id is 1
    
    public Event(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        //this one is for creating them from user input
        month = passedMonth;
        day = passedDay;
        year = passedYear;
        time = passedTime;
        description = passedDescription;
        idNumber = NewId();
    }
    
    public Event(){
        //this one is so I can set the idBase without actually creating an event
    }
    
    public Event(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription, int passedId){
        //this one is for loading them in from file
        month = passedMonth;
        day = passedDay;
        year = passedYear;
        time = passedTime;
        description = passedDescription;
        idNumber = passedId;
    }
    
    public void SetIdBase(int baseReadFromFile){
        //this is used when reading from file(don't want multiple events with the same id)
        idBase = baseReadFromFile;
    }
    
    private int NewId(){
        idBase++;
        return idBase;
    }
    
    
    
    public String GetEventAsDisplayString(){
        //this is used to put the event onto the screen in a text area(see list events panel in action)
        String toReturn = " ";
        toReturn += month+" "+day+" "+year+" "+time+"\n";
        toReturn += idNumber+"\n";
        toReturn += description+"\n";
        return toReturn;
    }
    
    public int GetId(){
        return idNumber;
    }
    
    public int GetIdBase(){
        return idBase;
    }
    
    public FileWriter SaveThisEvent(FileWriter writer) throws IOException{
        //saving this event to a file then return the FileWriter to continue the saving
        writer.write(idNumber+"\n");
        writer.write(month+"\n");
        writer.write(day+"\n");
        writer.write(year+"\n");
        writer.write(time+"\n");
        writer.write(description+"\n");
        writer.write("%\n");
        return writer;
        
        
    }
    
    
    
}

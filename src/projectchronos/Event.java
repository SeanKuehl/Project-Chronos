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
    private static int idBase = -100000000;
    
    public Event(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        month = passedMonth;
        day = passedDay;
        year = passedYear;
        time = passedTime;
        description = passedDescription;
        idNumber = NewId();
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
        idBase = baseReadFromFile;
    }
    
    private int NewId(){
        idBase++;
        return idBase;
    }
    
    public void PrintThis(){
        System.out.println(month+" "+day+" "+year+" "+time+" "+description+" "+idNumber);
    }
    
    public String GetEventAsDisplayString(){
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

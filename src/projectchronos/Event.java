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
    private int idNumber;
    private static int idBase = Integer.MIN_VALUE;
    
    public Event(String passedMonth, String passedDay, String passedYear, String passedTime, String passedDescription){
        month = passedMonth;
        day = passedDay;
        year = passedYear;
        time = passedTime;
        description = passedDescription;
        idNumber = NewId();
    }
    
    private int NewId(){
        idBase += 1;
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
    
}

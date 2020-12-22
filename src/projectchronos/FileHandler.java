/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author turqo
 */
public class FileHandler {
    
    //save format:
    //number of events
    //event.idBase
    //(below repeats for each event on file)
    //id number
    //month
    //day
    //year
    //time
    //description
    //% (signals the end of this event)
    
    public void SaveEventsToFile(ArrayList<Event> toSave, int idBase) {
        try {
          FileWriter myWriter = new FileWriter("EventSaveFile.txt");
          myWriter.write(toSave.size()+"\n");   //this is so it knows how many events to expect
          myWriter.write(idBase+"\n");
          
          
          for (int i = 0; i< toSave.size();i++){
              
              myWriter = toSave.get(i).SaveThisEvent(myWriter);
          }
          
          myWriter.close();
          //System.out.println("Successfully wrote to the file.");  //use this for testing, but not for exe
          
        } catch (IOException e) {
          //System.out.println("An error occurred.");   //use this for testing, but not for exe
          //e.printStackTrace();
          System.exit(0);   //for use in the exe where print statements are not preffered
        }
  }
    
    public boolean CheckIfFileEmpty(){
        
        try {
          File myObj = new File("EventSaveFile.txt");
          
          Scanner myReader = new Scanner(myObj);
          
          int test = Integer.parseInt(myReader.nextLine());
          
          myReader.close();
        } catch (Exception e) {
          
          return true;
        }
        
        return false;
    }
    
    public void ReadEventsFromFile(){
        
          try {
          File myObj = new File("EventSaveFile.txt");   //this is the name of the save file
          
          Scanner myReader = new Scanner(myObj);
          
          while (myReader.hasNextLine()) {
            int numberOfEvents = Integer.parseInt(myReader.nextLine());
            int idBase = Integer.parseInt(myReader.nextLine());
            
            EventHandler eh = new EventHandler();
            eh.SetEventIdBase(idBase);  //set event.idbase so that any new events made won't have conflicting ids
            
            int idNumber = -1;
            String month = " ";
            String day = " ";
            String year = " ";
            String time = " ";
            String description = " ";
            String temp = " ";
            
            int firstElementIndex = 0;
            boolean firstTime = true;
            
            for (int i = 0; i<numberOfEvents;i++){
                
                idNumber = Integer.parseInt(myReader.nextLine());
                month = myReader.nextLine();
                day = myReader.nextLine();
                year = myReader.nextLine();
                time = myReader.nextLine();
                
                temp = myReader.nextLine();
                while (temp.charAt(firstElementIndex) != '%'){
                    if (firstTime){
                        description += temp; 
                        firstTime = false;
                    }
                    else {
                        //make description text on new lines actually have new lines
                        description += "\n"+temp;   //the \n is there because it was just smooshing the lines together
                    }
                      
                        
                    
                    
                        
                    
                    
                    if (myReader.hasNextLine()){
                        temp = myReader.nextLine();
                        
                    }
                    else {
                        
                        break;
                    }
                    
                    
                }
                
                eh.AddEvent(month, day, year, time, description, idNumber);
                
                
                
            }
            
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          //System.out.println("An error occurred.");   //use this for testing only and not in the exe
          //e.printStackTrace();
          System.exit(0);   //for use in the exe where print statements are not preffered
        }
          
    }
    
    public void ClearFile(){
        //deletes file and then creates a new one
        
        File myObj = new File("EventSaveFile.txt"); 
        if (myObj.delete()) { 
          //file deleted successfully
        } else {
          System.exit(0);  //exit, normally an exception
        } 
        
            try {
          File newObj = new File("EventSaveFile.txt");
          if (newObj.createNewFile()) {
            //new file was created with no problems
          } else {
            //there was a problem
          }
        } catch (IOException e) {
          System.exit(0);   //exit
        }
     }
    
}


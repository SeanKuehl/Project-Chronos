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
    //this class will take care of reading, checking and writing to files
    public void SaveEventsToFile(ArrayList<Event> toSave, int idBase) {
        try {
          FileWriter myWriter = new FileWriter("EventSaveFile.txt");
          myWriter.write(toSave.size()+"\n");   //this is so it knows how many events to expect
          myWriter.write(idBase+"\n");
          
          
          for (int i = 0; i< toSave.size();i++){
              //the format with % as last line
              myWriter = toSave.get(i).SaveThisEvent(myWriter);
          }
          
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
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
    
    public int ReadEventsFromFile(){
        
          try {
          File myObj = new File("EventSaveFile.txt");
          
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            int numberOfEvents = Integer.parseInt(myReader.nextLine());
            int idBase = Integer.parseInt(myReader.nextLine());
            //wait until later, need an event before we can set event.idBase
            EventHandler eh = new EventHandler();
            
            int idNumber = -1;
            String month = " ";
            String day = " ";
            String year = " ";
            String time = " ";
            String description = " ";
            String temp = " ";
            for (int i = 0; i<numberOfEvents;i++){
                idNumber = Integer.parseInt(myReader.nextLine());
                month = myReader.nextLine();
                day = myReader.nextLine();
                year = myReader.nextLine();
                time = myReader.nextLine();
                
                temp = myReader.nextLine();
                while (temp != "%"){
                    description += temp;
                    if (myReader.hasNextLine()){
                        temp = myReader.nextLine();
                        
                    }
                    else {
                        break;
                    }
                    
                    
                }
                description = description.substring(0, description.length()-1); //removes the percent sign off the end
                eh.AddEvent(month, day, year, time, description, idNumber);
                
                
                
            }
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
          return 1;
    }
    
}

/*

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


*/


/*
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


*/

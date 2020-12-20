/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author turqo
 */
public class ProjectChronos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Date date = new Date();   // given date, gets current date and time
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date 
        //calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        //calendar.get(Calendar.MINUTE);        // gets hour in 12h format
        
        DateHandler dh = new DateHandler();
        System.out.println(dh.GetTodaysDate());
        int month = calendar.get(Calendar.MINUTE); 
        int hour = calendar.get(Calendar.HOUR); //midnight is represented by 0, so I'll need to check for that
        int minute = calendar.get(Calendar.MINUTE); //doesn't add a zero if the minute is say 4, check for that
        int AMOrPM = calendar.get(Calendar.AM_PM);// gets month number, NOTE this is zero based!
        //System.out.println(hour+" "+minute+" "+AMOrPM);   //this works, it's just one too low, there's 0-11 not 1-12
        //day of week counts sunday as the first day of the week
           // long millis=System.currentTimeMillis();  
            //java.util.Date date=new java.util.Date(millis);  
            
           // String stringDate = date.toString();
           // System.out.println(stringDate);  
           // String[] arrOfStr = stringDate.split(" ", 10);
            //I'll use the day of week, month of year, and the current year
           // for (int i = 0; i<arrOfStr.length;i++){
           //     System.out.println(arrOfStr[i]);
           // }
           // Calendar calendar = GregorianCalendar.getInstance();
          //  calendar.setTime(date);
          //  calendar.get(Calendar.HOUR_OF_DAY);
    }
    
}

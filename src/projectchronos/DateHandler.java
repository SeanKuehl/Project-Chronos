/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.String;

/**
 *
 * @author turqo
 */
public class DateHandler {
    
    public DateHandler(){
        
    }
    
    public String GetTodaysDate(){
        Date date = new Date();   // gets current time from system
        Calendar calendar = GregorianCalendar.getInstance(); 
        calendar.setTime(date); //converts date(probably milis) into something with month and other components
        
        return CurrentDay(calendar)+", "+CurrentMonth(calendar)+", "+CurrentYear(calendar)+" "+CurrentTime(calendar);
    }
    
    private String CurrentMonth(Calendar calendar){
        int integerMonth = calendar.get(Calendar.MONTH);
        //the month is between 0-11
        
        //January, February, March, April, May, June, July, August, September, October, November, December
        
        String[] stringMonthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return stringMonthArray[integerMonth];
    }
    
    private String CurrentYear(Calendar calendar){
        int integerYear = calendar.get(Calendar.YEAR);
        return Integer.toString(integerYear);
    }
    
    private String CurrentDay(Calendar calendar){
        int integerDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        //Sunday is counted as a 1, meaning this number must be made -1 to work in an array
        
        String[] daysOfWeekArray = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
        return daysOfWeekArray[integerDay];
    }
    
    private String CurrentTime(Calendar calendar){
        int integerHour = calendar.get(Calendar.HOUR); //midnight is represented by 0, so I'll need to check for that
        String stringHour;
        String stringMinute;
        String stringAMPM;
        
        int midnightRepresentedAs = 0;
        int realMidnight = 12;
        if (integerHour == midnightRepresentedAs){
            integerHour = realMidnight;
        }
        stringHour = Integer.toString(integerHour);
        
        
        int integerMinute = calendar.get(Calendar.MINUTE); //doesn't add a zero if the minute is say 4, check for that(4 vs 04)
        int firstDoubleDigit = 10;
        if (integerMinute < firstDoubleDigit){
            stringMinute = "0"+Integer.toString(integerMinute); //adds the needed leading 0 for formatting
        }
        else {
            stringMinute = Integer.toString(integerMinute); //it doesn't need a leading 0 and is fine the way it is
        }
        
        
        int integerAMPM = calendar.get(Calendar.AM_PM);  
        int AM = 0;
        int PM = 1; //in case I need to know this for changes later
        
        if (integerAMPM == AM){
            stringAMPM = "AM";
        }
        else {
            stringAMPM = "PM";
        }
        
        return stringHour+":"+stringMinute+" "+stringAMPM;
        
    }
    
    
}

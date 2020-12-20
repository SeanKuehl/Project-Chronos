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
        Date date = new Date();   // given date, gets current date and time
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);
        
        return CurrentDay(calendar)+", "+CurrentMonth(calendar)+", "+CurrentYear(calendar)+" "+CurrentTime(calendar);
    }
    
    private String CurrentMonth(Calendar calendar){
        int integerMonth = calendar.get(Calendar.MONTH);
        //the month is between 0-11
        
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
        
        
        int integerMinute = calendar.get(Calendar.MINUTE); //doesn't add a zero if the minute is say 4, check for that
        int firstDoubleDigit = 10;
        if (integerMinute < firstDoubleDigit){
            stringMinute = "0"+Integer.toString(integerMinute);
        }
        else {
            stringMinute = Integer.toString(integerMinute);
        }
        
        
        int integerAMPM = calendar.get(Calendar.AM_PM);  //0 is AM and 1 is PM
        int AM = 0;
        int PM = 1;
        if (integerAMPM == AM){
            stringAMPM = "AM";
        }
        else {
            stringAMPM = "PM";
        }
        
        return stringHour+":"+stringMinute+" "+stringAMPM;
        
    }
    
    
}

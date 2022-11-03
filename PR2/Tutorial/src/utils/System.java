package utils;

import java.util.Calendar;

// a class at defines system-specific functions for used by various programs
public class System {
  // return the system login name of the current user
  public static String getUserName() {
    return java.lang.System.getProperty("user.name");  
  }
  
  // return the hour of day as an integer number
  public static int getHourOfDay() {
    return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
  }
  
}

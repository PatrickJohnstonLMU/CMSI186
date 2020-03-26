/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  A clock.
 *  @author       :  Alissa Volosin
 *  Date          :  2019-08-06
 *  Description   :  Coming soon...
 *  Notes         :  Coming soon...
 *  Warnings      :  None
 *  Exceptions    :  Coming soon...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.3.0  2019-01-05  A. Volosin    Update method code
 *  @version 2.1.0  2020-02-2   A. Volosin    Convert to Playground problem
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

// Use to format string output of a clock
import java.text.DecimalFormat;

public class Clock {
  
  /**
   *  Class field definitions go here
   */

   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
   //private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double MAXIMUM_TIMESLICE_VALUE = 43500.0;
   //Default for wrongly answered code
   private static final double DEFAULT_ERROR_TIMESLICE = 30.0;



  // private fields
   private double[] timeJunque = new double[3];       // [0] = seconds, [1] = minutes, [2] = hours
   private double totalSeconds = 0.0;
   //private double hourHandDegrees = 0.0;
   //private double minuteHandDegrees = 0.0; 

  /**
   *  Constructor
   *   Not really anything to do here, all clocks are the same
   */
   public Clock() {
   }

  /**
   *  Method to calculate the next tick from the time increment
   *   each "tick" will be the number of seconds in the time slice
   *  @param  timeSlice double-precision value of the time slice being used
   *  @return three-element double array containing new seconds, minutes, and hours
   */
   public double[] tick(  double timeSlice ) {
      // Increase total second by timeSlice
      totalSeconds += timeSlice;
      // Update each value in timeJunque
      timeJunque[0] = totalSeconds % 60;
      //min     minutes =(seconds%3600)/60;
      //(int)(totalSeconds % 60) * 60;
      timeJunque[1] = (int)((totalSeconds%3600)/60);
      //hrs   seconds / 3600;
      //(int)(totalSeconds % 3600)
      timeJunque[2] = (int)(totalSeconds / 3600);
      // Optional to have this method return a double for total seconds instead of
      // the time in an array

      return timeJunque;
   }


  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   */
   public double validateTimeSliceArg( String argValue ) {
      double returnValue = 0;

      try {
        returnValue = Double.parseDouble( argValue );
      } catch (NumberFormatException nfe ) {

        returnValue = DEFAULT_ERROR_TIMESLICE;
        System.out.println("the  time slice is not a number, setting timeslice to default of 30 seconds. Try again next time with a number greater than 0 and less than 1800");
      }
      // try to parse the arg to a double
      // catch the correct exception
      // throw number format exception if the time slice value is not a number
      // throw illegal argument exception if the time slice value is out of range
      try{
        if (returnValue <= 0 ){
        throw new IllegalArgumentException("Timeslice must be non-negative");
        }   
      }catch (IllegalArgumentException i){
        returnValue = DEFAULT_ERROR_TIMESLICE;
        System.out.println("the  time slice is supposed to be a positive number, setting timeslice to default of 30 seconds. Try again next time with a number greater than 0 and less than 1800");
        }

      return returnValue;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a string representation of the clock
   *  @return String value of the clock, separated by colons
   */
   public String toString() {
      // This method has been completed for you
      DecimalFormat df  = new DecimalFormat( "00.0000" );
      DecimalFormat dfi = new DecimalFormat( "00" );
      return dfi.format(timeJunque[2]) + ":" + dfi.format(timeJunque[1]) + ":" + df.format(timeJunque[0]);
   }

  /**
   *  The main program starts here and should contain tests.
   *  Be sure to make LOTS of tests!!
   *  Remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println("Testing Tick(60) and to string");
      clock.tick(60);
      System.out.println(clock.toString());
      System.out.println("Testing Tick(1.589) and to string");
      clock.tick(1.589);
      System.out.println(clock.toString());
      System.out.println("Testing getTotalSeconds()");
      System.out.println(clock.getTotalSeconds());
      System.out.println("Testing validateTimeSliceArg(20) with tick ");
      clock.tick(clock.validateTimeSliceArg("20"));
      System.out.println(clock.toString());
      System.out.println("Testing validateTimeSliceArg(input) with tick and input being console input");
      clock.tick(clock.validateTimeSliceArg(args[0]));
      System.out.println(clock.toString());
      System.out.println("Testing validateTimeSliceArg(f): f is a string ");
      System.out.println(clock.validateTimeSliceArg("f"));
      System.out.println(clock.toString());
      System.out.println("Testing validateTimeSliceArg(2) ");
      System.out.println(clock.validateTimeSliceArg("2"));
      System.out.println(clock.toString());
      System.out.println("Testing validateTimeSliceArg(-2) ");
      System.out.println(clock.validateTimeSliceArg("-2"));
      System.out.println(clock.toString());


   }
}

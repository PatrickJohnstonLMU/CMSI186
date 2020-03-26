/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  PlaygroundSoccerSim.java
 *  Purpose       :  A class for kicking an arbitrary number of balls on a playground and detecting a 
 *                   collision or a goal
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
import java.text.DecimalFormat;
import java.lang.Math;
public class PlaygroundSoccerSim {
  // private data for
  //    - default playground height and width
  private static double DEFAULT_PLAYGROUND_HEIGHT = 1000;
  //    - default time slice
  private static double DEFAULT_TIME_SLICE = 1.0;
  // private instance data for
  //    - are any balls still moving (still a chance of a collision)
  //    - time slice
  private double timeSlice = DEFAULT_TIME_SLICE;
  //    - playground size
  private double playGroundHeight = DEFAULT_PLAYGROUND_HEIGHT;
  //    - number of balls
  private int ballCount = 0;
  //    - array of soccer balls
  private Ball[] soccerBalls = null;
  //    - clock
  private Clock c = new Clock();
  private int[] ballsCollided = new int[2];
  private int ballCollided1 = 0;
  private int ballCollided2 = 0;
  double [] collisionb1Loc = null;
  double [] collisionb2Loc = null;
  boolean collisionDetect = false;
  boolean endProgram = false;
  // You can put a private static final String here that includes the intro message
  //  or how to use the program
  Clock clock = new Clock();
   public PlaygroundSoccerSim() {
   }
  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim( String arguments[] )  {
    // if no arguments specified OR if number of arguments is NOT a factor of 4
    // OR if number of arguments is NOT a factor of 4 plus 1
    // then dispay message about how to run this program, how it works
    if (arguments.length == 0 || arguments.length % 4 == 2 ||
        arguments.length % 4 == 3 || arguments.length == 1) {
      try{
      throw new IllegalArgumentException("Arguments are not arranged or inputed properly, it must be numbers that are in doubles or value ie: 20.0 , with it being formated as so: 1 2 3 2 | exiting program");
    }catch (IllegalArgumentException iae){
      System.out.println("Arguments are not arranged or inputed properly, it must be numbers that are in doubles or value ie: 20.0 , with it being formated as so: 1 2 3 2 | exiting program:   ");
      System.exit(0);

    }

    }
    if ( arguments.length % 4 == 1) {
        try {
          timeSlice = clock.validateTimeSliceArg(arguments[arguments.length -1]);
        } catch (NumberFormatException nfe) {
          System.out.println("You entered too many arguments, must be formatted with intergers or doubles  | exiting program");
          System.exit(0);
        } catch (IllegalArgumentException iae) {
          System.out.println("You entered illegal arguments, it must be numbers that are in doubles value ie: 20.0 , with it being formated as so: 1 2 3 2 | exiting program");
          System.exit(0);
        }
    }
    // else if argument count % 4 is 1, assume last is timeslice in seconds
    // try to call validateTimeSliceArg from Clock class
    // else if argument count % 4 is 0, there is no optional time slice, use the defualt
    // now handle and validate the ball arguments
    //    - ballCount
    ballCount = (int)Math.floor(arguments.length / 4);
    // populate soccerBall array, similar to DiceSet
    soccerBalls = new Ball[ballCount];
    for ( int i = 0; i < soccerBalls.length; i++ ){
        try {
          soccerBalls[i] = new Ball(Double.parseDouble(arguments[i * 4]),
                                    Double.parseDouble(arguments[i * 4 + 1]),
                                    Double.parseDouble(arguments[i * 4 + 2]),
                                    Double.parseDouble(arguments[i * 4 + 3]));
        } catch ( NumberFormatException nfe ){
          System.out.println("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
          System.exit(0);
        }
    }
    // converting args to doubles should be in a try / catch
    // java PlaygroungSS 4 4 1 1 5 5 2 2 6 6 3 3
   }
  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   */
   public void report() {
      clock.tick(timeSlice);
      clock.toString();
      for ( int i = 0; i < soccerBalls.length; i++ ){
      this.soccerBalls[i].move(timeSlice);
      String output = soccerBalls[i].toString();
      int ballLabel = i + 1;
      System.out.println(clock.toString()+ "|Ball #" + (i+1) +" :" + output );
    }
   }
  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {
    //  - if the ball is not out of bounds and not at rest, move the ball
    //  - if the ball is out of bounds after the move or at rest, set the ball out of bounds or at rest
        report();
        boolean moveResult = atLeastOneBallStillMoving();
        collisionCheck();
        if (moveResult == false || collisionDetect == true) {
          if (moveResult == false){
            endProgram = true;
            System.out.println("All balls have stopped moving because balls are either out of bounds or not in motion at a time of: " + clock.toString() +" |exiting program");
            System.exit(0);
          }
          if (collisionDetect = true)
            System.out.println("Collision detected with ball " + ballsCollided[0] + " and ball " + ballsCollided[1] + "at their positions of " + collisionb1Loc[0] + "," +collisionb1Loc[1] + "and " +collisionb2Loc[0] + "," +collisionb2Loc[1] + "| time: " + clock.toString());
            System.exit(0);

        }
  }
  /**
   *  method to check for a collision soccerBall array
   *
   */
   public int[] collisionCheck() {
    outer: for ( int i = 0; i < soccerBalls.length - 1; i++ ) {
    for ( int j = i + 1; j < soccerBalls.length; j++) {
      double radius = 4.45;
      double dis;
      double [] ball1Coords = soccerBalls[i].getPosition();
      double [] ball2Coords = soccerBalls[j].getPosition();
      double ball1xloc = ball1Coords[0];
      double ball1yloc = ball1Coords[1];
      double ball2xloc = ball2Coords[0];
      double ball2yloc = ball2Coords[1];
      dis = Math.sqrt((ball2xloc - ball1xloc)*(ball2xloc - ball1xloc) + (ball2yloc - ball1yloc)*(ball2yloc - ball1yloc));
      dis = dis*12; // distance in inches
      if ( dis <= radius * 2) {
        ballCollided1 = i;
        ballCollided2 = j;
        ballsCollided[0] = i;
        ballsCollided[1] = j;
        //saving data for final report
        collisionb1Loc = soccerBalls[ballsCollided[0]].getPosition();
        collisionb2Loc = soccerBalls[ballsCollided[1]].getPosition();
        collisionDetect = true;
        // compare location of ball at index i and j to see if there is a collision
              // if there is a collision, store the ball indexes in a field that you can access outside of the loop to         use in your report
              break outer;   // this will break out of the outer loop if you named it outer above
      }
    }
}
  return ballsCollided;
   }
  /**
   *  method to see if the sim should continue
   *  we need at least one ball moving (in bounds) for the sim to continue
   *
   */
   public boolean atLeastOneBallStillMoving() {
    boolean [] checkarray = new boolean [soccerBalls.length];
    for ( int i = 0; i < soccerBalls.length; i++ ) {
      if (soccerBalls[i].isStillMoving() == true || soccerBalls[i].isBallOutOfBounds(DEFAULT_PLAYGROUND_HEIGHT,DEFAULT_PLAYGROUND_HEIGHT) == true){
        checkarray[i] = false;
      }
      else{
        checkarray[i] =true;
      }
    }
    // Checking all items in the array are not moving
    int counter = 0;
    for (int j = 0; j < checkarray.length; j++){
      if ( checkarray[j] == false ){
        counter ++;
      }
    }
    if (counter < checkarray.length){
      return true;
    }
      return false;
  }
  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments
   */
   public static void main( String args[] ) {
    PlaygroundSoccerSim myPSS = new PlaygroundSoccerSim();
    myPSS.validateArgsAndSetupSim(args);
    while(true){
      myPSS.simUpdate();
    }
    //input in console should be  first 4 attriubutes about a ball
  }
}

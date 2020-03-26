/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  A class for a single ball that has a location and speed.
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

// Use to format string output of location and speed doubles
import java.text.DecimalFormat;

public class Ball {

   // Private class wide data
      private static final double BALL_RADIUS = 4.45;    // radius in inches as given by the problem
      private static final double FRICATION_COEFFICIENT = .99; // one percent slowdown per second due to friction
      private static final int X_INDEX = 0;  // index of X values within location and speed arrays
      private static final int Y_INDEX = 1; // index of Y values within location and speed arrays

   // Private instance data
       private boolean outOfBound = false;  // all balls will start in bounds by default
       private boolean atRest = false;// all balls will start moving by default
       private double[] ballLocation = new double[2];// array containing both coordinate values
       private double[] ballSpeed = new double[2];// array containing both direction speed values

  /**
   * Constructor to make a new Ball
   *  @param xLoc double-precision value of the X location of the ball
   *  @param yLoc double-precision value of the Y location of the ball
   *  @param xSpeed double-precision value for the initial speed of the ball in X direction
   *  @param ySpeed double-precision value for the initial speed of the ball in Y direction
   */
   public Ball( double xLoc, double yLoc, double xSpeed, double ySpeed ) {
    ballLocation[X_INDEX] = xLoc;
    ballLocation[Y_INDEX] = yLoc;
    ballSpeed[X_INDEX]= xSpeed;
    ballSpeed[Y_INDEX] = ySpeed;
      // To create an instance of a ball, set the private instance data equal to argument values
   }

  /**
   *  method to fetch the current speed of the ball
   *  @return  double-precision two-element array of X and Y speed values
   */

  public double[] getSpeed(){
    return ballSpeed;
  }
   public double getSpeed( String xy ) {
      try{
      if ( xy.equals("x") || xy.equals("X")){
        return ballSpeed[X_INDEX];
     }
      else if ( xy.equals("y") || xy.equals("Y")){
         return ballSpeed[Y_INDEX];
      }
      
        else{
        throw new IllegalArgumentException("Error Occured concerning the speed of the ball, exiting program");
        }
   }catch (IllegalArgumentException i){
    System.out.println("Error Occured concerning the input of the request of the speed of the ball, exiting program");
    System.exit(0);
    return 0.0;
    

    
   }




 }

  /**
   *  method to fetch the current position of the ball
   *  @return  double-precision two-element array of X and Y location values
   */
   public double[] getPosition() {
      return ballLocation;
   }

  /**
   *  method to flag the ball as "is still moving"
   *  @return  boolean true if ball is moving, false if at rest
   *  @note    at rest is defined as speed <= 1.0 inch/second
   */
   public boolean isStillMoving() {
      //true its still moving, flags it, false if not moving
    
     
    if ( Math.abs(ballSpeed[X_INDEX] * 12) < 1 && Math.abs(ballSpeed[Y_INDEX] * 12) < 1 ) {
    ballSpeed[X_INDEX] = 0;
    ballSpeed[Y_INDEX] = 0;
    if (atRest != true){
      System.out.println("A ball stopped moving at : " + ballLocation[X_INDEX] +","+ ballLocation[Y_INDEX]);
    }
    atRest = true;


}

    return atRest;
   }


  /**
   *  method to flag the ball as "out of bounds" which will set its speed to zero and its
   *    "outOfBounds" value to true so it will effectively no longer be in the simulation
   *  @param playgroundWidth    double-precision value of 1/2 the designated playground width
   *  @param playgroundHeight   double-precision value of 1/2 the designated playground height
   */
   public boolean isBallOutOfBounds( double playgroundWidth, double playgroundHeight ) {
      if(Math.abs(ballLocation[X_INDEX]) > playgroundWidth / 2 || Math.abs(ballLocation[Y_INDEX]) > playgroundHeight / 2){
        System.out.println("The ball is out of bounds at: " + ballLocation[X_INDEX] +","+ ballLocation[Y_INDEX]);
          ballSpeed[X_INDEX] = 0;
          ballSpeed[Y_INDEX] = 0;
          outOfBound = true;
      } else {
        outOfBound = false;
      }
      return outOfBound;
      //Check to see if ball is out of bounds given a playground size
      // Set out of bounds private instance data
      // Call isStillMoving method
      // Decrease Speed to 0

   }

  /**
   *  method to update the speed of the ball for one slice of time
   *  @param timeSlice     double-precision value of time slace for simulation
   *  @return  double-precision two element array of new velocity values
   */
   public double[] updateSpeedsForOneTick( double timeSlice ) {
      // Update x index of ballSpeed
      ballSpeed[X_INDEX] *= Math.pow(FRICATION_COEFFICIENT,timeSlice);
      // Update y index of ballSpeed
      ballSpeed[Y_INDEX] *= Math.pow(FRICATION_COEFFICIENT,timeSlice);
      return ballSpeed;
   }

  /**
   *  method to update the ball's position and velocity
   *  @param timeSlice     double-precision value of time slace for simulation
   */
   public void move( double timeSlice ) {
      ballSpeed = updateSpeedsForOneTick(timeSlice);
      // Update x index of ballLocation
      ballLocation[X_INDEX] += (ballSpeed[X_INDEX]);
      // Update y index of ballLocation
      ballLocation[Y_INDEX] += (ballSpeed[Y_INDEX]);
      // Update ballSpeed for one tick given the timeslice parameter
   }

  /**
   *  "toString()" representation of this ball
   *  @return  String-y version of what this Ball is
   */
   public String toString() {
      // Use to format ball location
      DecimalFormat dfl = new DecimalFormat( "#0.000");

      // Use to format speed
      DecimalFormat dfs = new DecimalFormat( "#0.0000");
      //Formating code for Location
      




      // location and speed
      // OR
      // Print ball name and Out of bounds
      // OR
      // Print ball name and at rest
      
      return ("Ball Speed (X,Y): " + dfs.format(ballSpeed[X_INDEX]) + ","+ dfs.format(ballSpeed[Y_INDEX]) +"| Ball Location(X,Y): " + dfs.format(ballLocation[X_INDEX]) + "," + dfs.format(ballLocation[Y_INDEX]) + "| Ball at Rest?: " + this.atRest);

   }

  /**
   * a main method for testing -- pretty simple
   *  @param args[] String array of command line arguments
   */
   public static void main( String args[] ) {
      System.out.println( "\n   Testing the Ball class................" );
      Ball b1 = new Ball( 10, 10, -2, -3);
      System.out.println("Testing 1 for toString");
      System.out.println(b1.toString() );
      System.out.println("Testing 1 for move()");
      b1.move( 1.0 );
      System.out.println("Testing 1 for is still moving");
      System.out.println(b1.isStillMoving());
      System.out.println(b1.toString());

      System.out.println("Testing for getPosition");
      double [] coords = b1.getPosition();
      System.out.println(coords[0] + " , " + coords[1]);
      double [] speed = b1.getSpeed();
      System.out.println("Speed of ball 1: " + speed[0]+ "," + speed[1] );  
      b1.ballSpeed[X_INDEX] = 0.0;
      b1.ballSpeed[Y_INDEX] = 0.0;

      System.out.println("Testing after is still moving aftersetting speed to 0: true means stopped moving");
      System.out.println(b1.isStillMoving());

      System.out.println("OutofBounds if boundaries are reduced");
      System.out.println(b1.isBallOutOfBounds(0.5,0.5));
      System.out.println("Testing 1 for GetSpeed with string input: getSpeed(x)");
      System.out.println(b1.getSpeed("x"));
      System.out.println("Testing 2 for GetSpeed with string input: getSpeed(y)");
      System.out.println(b1.getSpeed("y"));
      System.out.println("Testing 3 for GetSpeed with string input: getSpeed(c): Expect error and to shut down");
      System.out.println(b1.getSpeed("c"));

   }

}

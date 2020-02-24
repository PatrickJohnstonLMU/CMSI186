/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  A. Volosin
 *  Date          :  2020-02.03
 *  Description   :  This helper class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then stolen from B.J. Johnson, then modified to show some 
 *                   interesting things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-03  A. Volosin    Update naming conventions and comments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   
   private Die[] ds = null;

   // public constructor:
  /**
   * This constructor is a method you will run to CREATE a DiceSet
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {

      this.ds = new Die[count];
    for (int i = 0; i < count; i++){
      this.ds[i] = new Die(sides);
    }

      if ( sides < 4) {
        throw new IllegalArgumentException ("You have too few sides");
    } else {


       this.sides = sides;
       
    }
    if ( count < 1) {
        throw new IllegalArgumentException ("You have too few dice");
    } else {


       this.count = count;
    
    }
   }

  /**
   * Sums up all dice in the DiceSet
   * @return the sum of all the dice values in the set
   */
   public int sum() {
    int sum = 0;
    for (int i = 0; i < ds.length; i++){
      sum = (ds[i].getValue() + sum);
      
   }
      return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  This method does not return anything, it just rolls new values for all die
   *  in the DiceSet.
   *  You will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    for (int i = 0; i < ds.length; i++){
      ds[i].roll();
      
   }
   }

  /**
   * Rolls a single die of the dice in this set indexed by 'dieIndex' to a random value
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
    if ( this.count < dieIndex - 1) {
        throw new IllegalArgumentException ("You have too few dice to roll that index, try again with different value");
    } else {

      return this.ds[dieIndex].roll();
    }

   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
    int result = this.ds[dieIndex].getValue();
      return result;
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
    String result = "";
    for (int i = 0; i < ds.length; i++){
      result += ds[i].toString();
      
   }
   return result;
 }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
     String result = "";
     for (int i = 0; i < ds.count; i++){
      result += ds.ds[i].toString();
    }
       return result;
   }



  /**
   * A little test main to check things out
   * Write tests that out put results of each method at least twice
   * This main method only serves as a tester.
   */

   public static void main(String[] args ) {
    System.out.println("Constructing a new dice set, length 4 side 6");
    DiceSet set1 = new DiceSet(4,6);
    
    System.out.println("========Roll Test and Non Static toString test============");
    set1.roll(); // roll test
    System.out.println(" Test 1: Here is set1 rolled: " + set1.toString()); // Non Staitc toString test
    set1.roll(); // roll test
    System.out.println(" Test 2: Here is set1 rolled : " + set1.toString()); // Non Staitc toString test
    System.out.println("========Roll Test and Non Static toString test end ============");

//Roll Indiv, get indiv and static toString test
    System.out.println("========Roll Indiviudal, get Indivual  and Static toString test ============");
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 1: Rolling die index at 2");
    System.out.println(set1.rollIndividual(2));// roll individual test
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 1:Rolling die index at 3");
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 1: Getting indiviudal at index 3");
    System.out.println(set1.getIndividual(3)); // get individual test
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 2: Rolling die index at 2");
    System.out.println(set1.rollIndividual(2));// roll individual test
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 2:Rolling die index at 3");
    System.out.println(DiceSet.toString(set1));// Static toString test
    System.out.println("Test 2: Getting indiviudal at index 3");
    System.out.println(set1.getIndividual(3)); // get individual test
    System.out.println("========Roll Indiviudal, get Indivual  and Static toString test end ============");



//Sum Test 
    System.out.println("========Sum and toString test  ============");
    System.out.println(DiceSet.toString(set1));// toString test
    System.out.println("Test 1: Sum of set1");
    System.out.println(set1.sum()); // sum test
    set1.roll(); // roll test
    System.out.println("Test 2: Rerolled Sum of set1: ");
    System.out.println(set1.sum()); // sum test
    System.out.println("========Sum and toString test end ============");

      // You do this part!
   }


}
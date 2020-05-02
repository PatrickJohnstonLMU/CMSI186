/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  A. Volosin
 * Date       :  2019-03-01
 * Description:  @see <a href='http://volosin.lmu.build/alissa-volosin/cmsi-186-programming-lab/cmsi-186-assignments/assignment-06/'>Assignment 06</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A. Volosin    Initial writing and begin coding
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class BrobInt {
/** 
* public instance variable that allows for use of the Halver class
*/
public Halver h = new Halver();
    /**
   * public static final instance data that represents the BrobInt constant zero
   */
   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"

    /**
   * public static final instance data that represents the BrobInt constant one
   */
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
       /**
   * public static final instance data that represents the BrobInt constant tw0
   */
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
       /**
   * public static final instance data that represents the BrobInt constant three
   */
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
       /**
   * public static final instance data that represents the BrobInt constant  four
   */
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
       /**
   * public static final instance data that represents the BrobInt constant five
   */
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
       /**
   * public static final instance data that represents the BrobInt constant six
   */
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
       /**
   * public static final instance data that represents the BrobInt constant seven
   */
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
       /**
   * public static final instance data that represents the BrobInt constant eight
   */
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
       /**
   * public static final instance data that represents the BrobInt constant nine
   */
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
       /**
   * public static final instance data that represents the BrobInt constant ten
   */
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"


  /// Some constants for other intrinsic data types

        /**
   * public instance data that represents the boolean value for stopping recursion
   * true = recursive may continue, false = recursion should halt
   */
   public static boolean recursiveStop = true;
    /**
   * public instance data that represents the boolean value of whether division should stop being recursive
   */
   public static boolean divisionStop = true;

   
  /**
   * public instance data that represents that value for carrying over signs through methods - 0 is positive
   ** 1 is negative, and is carried throughout methods to tell methods if called recursively the sign out the BrobInt
   */
   public static byte signRecursive = -1;
   //Value for carrying over sign through recursion for multiplication 0 - positive , 1 - negative
  ///  these can help speed up the math if they fit into the proper memory space


  /**
   * private instance String that is the backwards version of the internal String representation of the BrobInt
   */
   private String reversed      = "";   


  /**
   * private instance  byte arry that is the backwards byte version of the BrobInt
   */     
   private  byte [] byteVersion; 


   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;


   /**
   * public instance data in String value that is the String representation of this Brobint
   */
   public  String internalValue = "";        // internal String representation of this BrobInt


  /**
   * public instance data in byte form represents whether this BrobInt is either even or odd with 
   * "0" is positive, "1" is negative
   */
   public  byte   sign          = 0;         // "0" is positive, "1" is negative

     /**
   * public instance data  in String value that represnts the internalvalue without signs of this BrobInt
   * 
   */
   public String pureValue = "";


  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
    internalValue = value;
    StringBuffer sb = new StringBuffer(value).reverse();
    reversed = sb.toString();
    if ( value.charAt(0) == '-'){
      sign = 1;
      //remove sign from reversed
      reversed = reversed.substring(0,reversed.length()-1);
        // Complete the code to accomplish what is in the javadoc text
    }
    else if ( value.charAt(0) == '+'){
      sign = 0;
      //remove sign from reversed
      reversed = reversed.substring(0,reversed.length()-1);
        // Complete the code to accomplish what is in the javadoc text
    }
    else{
      sign = 0;
    }
    validateDigits();
    byteVersion = new byte[reversed.length()];
    for (int i = 0; i <reversed.length(); i++){
    byteVersion[i] = (byte)Character.getNumericValue(reversed.charAt(i));
    }
    StringBuffer db = new StringBuffer(reversed).reverse();
    pureValue = db.toString();

   }

  
   /**  
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if value is not a digit
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   */
   public boolean validateDigits() {
    boolean passCheck;
    for(int i = 0; i < (reversed.length()); i ++){
      
        if ((Character.isDigit(reversed.charAt(i)))){
            passCheck = true;
        }else{
          throw new IllegalArgumentException("must have digit values only, that includes no characters or any other symbols. Postive and negative signs must be INFRONT of the number");
        }

      
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    }

    
  return true; 
   
 }

  /**
   *  Method to add the value of a BrobInt passed as argument to this BrobInt
   *  @param  bint         BrobInt for this to be added to 
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  NOTE: Bint and this are switched from the pseudo code given ex: 20+10 is 10.add(20);
   */
   public BrobInt add( BrobInt bint ) {

    //a is 
    // 1 means this is longer than bint, hence larger positive
    //  -1 means bint is longer than this, hence larger positive
     
    int carry = 0;
//0 positive 1 negative
    BrobInt bintfixed = removeLeadingZeros(bint);
    BrobInt thisfixed = removeLeadingZeros(this);


    String possible;
    byte tempsign = 0;
    byte[] a = bintfixed.byteVersion.clone();
    byte[] b = thisfixed.byteVersion.clone();
    byte[] c = new byte[Math.max(a.length,b.length) + 2]; //+2 to account for carrying

  BrobInt bintRecursive = null;
  BrobInt thisRecursive = null;
  //breakout of if loop: 0 = no, 1 = yes
  int breakOut = 0;



      if (recursiveStop == true){
        recursiveStop = false;

  if((((bintfixed.sign == 0) == true && (thisfixed.sign == 1  )== true)) && ((thisfixed.absoluteValue(bintfixed)) == -1) && (breakOut == 0)){
   // System.out.println("a > b   +a –b a-b, result is positive");
    recursiveStop = false;
    breakOut = 1;
  //  System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

    return(thisRecursive.subtract(bintRecursive));
      
      
      
      
    }  
    if(((bintfixed.sign == 0 && thisfixed.sign == 1  )== true) && ((thisfixed.absoluteValue(bintfixed)) == 1) && (breakOut == 0)){
    //System.out.println("a < b +a –b a b-a, result is negative");
    recursiveStop = false;
    breakOut = 1;
   // System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

    return(bintRecursive.subtract(thisRecursive));
      
      
      
    } 
    if(((bintfixed.sign == 0 && thisfixed.sign ==1  )== true) && ((Arrays.equals(a,b)) == true) && (breakOut == 0)){
    //System.out.println(" a = b  +a –b  = 0, ");
    recursiveStop = true;


    return ZERO;

      
      
      
      
    }
    if(((bintfixed.sign == 1 && thisfixed.sign ==1  )== true) && ((thisfixed.absoluteValue(bintfixed)) ==  -1) && (breakOut == 0)){
    //System.out.println(" a > b  -a –b a+b, result is negative");
    recursiveStop = false;
    breakOut = 1;
 //   System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      
      
      
      
    }
        if(((bintfixed.sign == 1 && thisfixed.sign ==1  )== true) && ((thisfixed.absoluteValue(bintfixed)) == 1) && (breakOut == 0)){
    //System.out.println(" a < b  -a –b a+b, result is negative");
    recursiveStop = false;
    breakOut = 1;
   // System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      
      
      
      
    }
        if(((bintfixed.sign == 1 && thisfixed.sign ==1  )== true) && ((Arrays.equals(a,b)) == true) && (breakOut == 0)){
    //System.out.println(" a = b  -a –b a+b, result is negative");
    recursiveStop = false;
    breakOut = 1;
 //   System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      
      
      
      
    }
            if(((bintfixed.sign == 0 && thisfixed.sign == 0  )== true) && ((thisfixed.absoluteValue(bintfixed)) == -1) && (breakOut == 0)){
  //System.out.println(" a > b  +a +b a+b, result is positive");
    recursiveStop = false;
    breakOut = 1;
 //   System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
      
      
    }
            if(((bintfixed.sign == 0 && thisfixed.sign == 0  )== true) && ((thisfixed.absoluteValue(bintfixed)) == -1) && (breakOut == 0)){
   //System.out.println(" a > b  +a + b a+b, result is positive");
    recursiveStop = false;
    breakOut = 1;
   // System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
      
      
    }
            if(((bintfixed.sign == 0 && thisfixed.sign == 0  )== true) && ((thisfixed.absoluteValue(bintfixed)) == 1) && (breakOut == 0)){
   //System.out.println(" a < b  +a + b a+b, result is positive");
    recursiveStop = false;
    breakOut = 1;
   // System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
      
      
    }
            if(((bintfixed.sign == 0 && thisfixed.sign == 0  )== true) && ((Arrays.equals(a,b)) == true) && (breakOut == 0)){
   //System.out.println(" a = b  +a + b a+b, result is positive");
    recursiveStop = false;
    breakOut = 1;
  //  System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
      
      
    }
            if(((bintfixed.sign == 0 && thisfixed.sign == 0  )== true) && ((Arrays.equals(a,b)) == true) && (breakOut == 0)){
   //System.out.println(" a = b  +a + b a+b, result is positive");
    recursiveStop = false;
    breakOut = 1;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
      
      
    }
            if(((bintfixed.sign == 1 && thisfixed.sign == 0  )== true) && ((thisfixed.absoluteValue(bintfixed)) == -1) && (breakOut == 0)){
  // System.out.println(" a > b  -a + b a-b, result is negative");
    recursiveStop = false;
    breakOut = 1;
  //  System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      
      
      
    return(thisRecursive.subtract(bintRecursive));
      
    }
            if(((bintfixed.sign == 1 && thisfixed.sign == 0  )== true) && ((thisfixed.absoluteValue(bintfixed)) == 1) && (breakOut == 0)){
  //  System.out.println(" a < b  -a + b b-a, result is positive");
    recursiveStop = false;
    breakOut = 1;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
    return(bintRecursive.subtract(thisRecursive));
      
      
    }
            if(((bintfixed.sign == 1 && thisfixed.sign == 0  )== true) && ((Arrays.equals(a,b)) == true) && (breakOut == 0)){
    //System.out.println(" a = b  -a + b b-a, result is positive");
    recursiveStop = false;
    breakOut = 1;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      
      
    return ZERO;
      
      
    }
    }// end of subtract recursion check
        
      if (a.length == b.length){
        for(int i = 0; i <= (a.length -1); i++){
          c[i]= (byte)(a[i]+b[i]+carry);
          if (c[i] > 9){
            c[i] = (byte)(c[i]-10);
            carry = (byte)(1);
          }else {
            carry = (byte)(0);
          }
        }
        if(carry == 1){
          c[b.length] = (byte)carry;
        }

        

      }


        if (a.length > b.length){
          for(int i = 0; i <= (b.length - 1); i++ ){
            c[i] = (byte)(a[i] + b[i] + carry);
            if (c[i] > 9) {
                c[i] = (byte)(c[i] - 10);
                carry = (byte)(1);
            } else {
                 carry = (byte)(0);
            }
          }
          for (int i = b.length; i <= a.length-1; i++){
            c[i] = (byte)(a[i] + carry);
            if (c[i] > 9) {
                c[i] = (byte)(c[i] - 10);
                carry = (byte)(1);
            } else {
                 carry = (byte)(0);
            }

          }
          for( int i = a.length; i <= c.length-1; i++){
            c[i] = (byte)(0);
          }
        }
            
            
        


        if (b.length > a.length){
        for(int i = 0; i <= (a.length-1); i++ ){
            c[i] = (byte)(a[i] + b[i] + carry);
            if (c[i] > 9) {
                c[i] = (byte)(c[i] - 10);
                carry = (byte)(1);
            } else {
                 carry = (byte)(0);
            }
          }
          for (int i = a.length; i <= b.length-1; i++){
            c[i] = (byte)(b[i] + carry);
            if (c[i] > 9) {
                c[i] = (byte)(c[i] - 10);
                carry = (byte)(1);
            } else {
                 carry = (byte)(0);
            }
          }
          for( int i = b.length; i <= c.length-1; i++){
            c[i] = (byte)(0);
          }
        }
            
          

        
     

      //reversing byte array
      int i = 0;
      int j = c.length - 1;
      byte tmp;
      while (j > i) {
          tmp = c[j];
          c[j] = c[i];
          c[i] = tmp;
          j--;
          i++;
      }
      //converting byte array to string 
      String result = "";
      for(int z = 0; z <= c.length-1; z++){
      byte x = (c[z]);
      result =  result + (Byte.toString(x));
      }
      // checking signs and making change if signs are needed to be changed
    if(signRecursive == 1 || signRecursive == 0){
      if(signRecursive == 1){
        result = "-" +result;
        signRecursive = 0;
      }
    }else{
      if (tempsign ==1){
        result = "-" +result;

      }

    } 
      String brobcarrier = result;
      BrobInt output = new BrobInt( brobcarrier );

    signRecursive = -10;
    recursiveStop = true;
    divisionStop = true;


    return removeLeadingZeros(output);
   }//end

  /** 
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt for this to be subtracted from
   *  @return BrobInt that is the difference of the value of this  and the bint Brobint
   *  NOTE: Bint and this are switched from the pseudo code given ex: 20-10 is 10.subtract(20);
   */
   public BrobInt subtract( BrobInt bint ) {
  //removing zeroes from values
  BrobInt bintfixed = removeLeadingZeros(bint);
  BrobInt thisfixed = removeLeadingZeros(this);
  Byte tempsign = 0;

  //Storing them as byte array clones using byte array and using .clone() so it does not affect the original array
  byte [] a = new byte[Math.max(bintfixed.byteVersion.length,thisfixed.byteVersion.length)+1];
  for (int i = 0; i <= bintfixed.byteVersion.length -1; i++) {     
           a[i] = (byte)(bintfixed.byteVersion[i]);    
        }

  //making b same length as a except remainder is filled with zeroes so there is no second loop needed

  byte [] b = new byte[Math.max(bintfixed.byteVersion.length,thisfixed.byteVersion.length)+1];
  for (int i = 0; i <= thisfixed.byteVersion.length -1; i++) {     
           b[i] = (byte)(thisfixed.byteVersion[i]);    
        }
  byte[] c = new byte[Math.max(a.length,b.length) + 2]; //+2 to account for carrying

  //Intializing Recusrive figure 
  BrobInt bintRecursive = null;
  BrobInt thisRecursive = null;

   

  //System.out.print("in subtraction" + recursiveStop);

    if (recursiveStop == true){

  if(((bintfixed.sign == 0 && thisfixed.sign == 1 )== true) && (Arrays.equals(bintfixed.byteVersion, thisfixed.byteVersion) == true)){
    //a = b +a –b a+b, result is positive
   // System.out.println("a = b +a –b a+b, result is positive");

    //Telling program to not go into the a =b, +a -b loop when entering addition as doing so would cause a infinite recusrive loop
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    //System.out.println("going into addition method");
    signRecursive = 0;
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());

      return (this.add(bint));
      
      
      
      
    }
    if(((bintfixed.sign == 0 && thisfixed.sign == 0 )== true) && (Arrays.equals(bintfixed.byteVersion, thisfixed.byteVersion) == true)){
      //a = b +a +b =0
    //System.out.println("a = b +a +b =0");

    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
   // System.out.println("going into addition method");
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());


      return (ZERO);
      
      
      
      
    }
    if(((bintfixed.sign == 1 && thisfixed.sign == 1 )== true) && (Arrays.equals(bintfixed.byteVersion, thisfixed.byteVersion) == true)){
    
    //System.out.println("a = b -a –b =0");

    recursiveStop = false;
   // System.out.println("recursive stop is " + recursiveStop);
   // System.out.println("going into addition method");
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;


      return (ZERO);
      
      
      
      
    }
  if(((bintfixed.sign == 1 && thisfixed.sign == 0 )== true) && (Arrays.equals(bintfixed.byteVersion, thisfixed.byteVersion) == true)){
    //System.out.println("a = b -a +b a+b, result is negative");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    //System.out.println("going into addition method");
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      return (this.add(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 0 && thisfixed.sign == 1 )== true) && (thisfixed.absoluteValue(bintfixed)) == -1){
    //System.out.println("a > b +a –b a+b, result is positive");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
   // System.out.println("going into addition method");
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      return (this.add(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 0 && thisfixed.sign ==1  )== true) && (thisfixed.absoluteValue(bintfixed)) == 1 ){
    //System.out.println("a < b +a –b a+b, result is positive");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    //System.out.println("going into addition method");
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      return (this.add(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 1 && thisfixed.sign ==1  )== true) && (thisfixed.absoluteValue(bintfixed)) == -1 ){
    //System.out.println("a > b -a –b a-b, result is negative");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      return (this.subtract(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 1 && thisfixed.sign ==1  )== true) && (thisfixed.absoluteValue(bintfixed)) == 1 ){
    //System.out.println("a < b -a –b b-a, result is positive");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      return (bint.subtract(this));
      
      
      
      
    }
  if(((bintfixed.sign == 0 && thisfixed.sign ==0  )== true) && (thisfixed.absoluteValue(bintfixed)) == -1 ){
    //System.out.println("a > b +a +b a-b, result is positive");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 0;

      return (this.subtract(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 0 && thisfixed.sign ==0  )== true) && (thisfixed.absoluteValue(bintfixed)) == 1 ){
    //System.out.println("a < b +a +b b-a, result is negative");
    recursiveStop = false;
    //System.out.println("recursive stop is " + recursiveStop);
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      return (bint.subtract(this));
      
      
      
      
    }
  if(((bintfixed.sign == 1 && thisfixed.sign ==0  )== true) && (thisfixed.absoluteValue(bintfixed)) == -1 ){
    //System.out.println("a > b -a +b a+b, result is negative");
    recursiveStop = false;
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      return (this.add(bint));
      
      
      
      
    }
  if(((bintfixed.sign == 1 && thisfixed.sign ==0  )== true) && (thisfixed.absoluteValue(bintfixed)) == 1 ){
    //System.out.println("a < b -a +b a+b, result is negative");
    recursiveStop = false;
    bintRecursive = new BrobInt(bintfixed.toString());
    thisRecursive = new BrobInt(thisfixed.toString());
    signRecursive = 1;

      return (this.add(bint));
      
      
      
      
    }
}


    //0 positive 1 negative
    //a is bint number or  being subtracted  
    //b is this or number being taken from 
    //1 means  b is longer than a, hence larger positive
    //-1 means a is longer than b, hence larger positive
    




    //
    int borrow = 0;
    //Subtraction loop
    for(int i = 0; i <= a.length -1; i++){
      if(a[i]==b[i]){
        c[i]= (byte)(0);
      }else if(a[i] < b[i]){
        c[i] = (byte)(a[i] + 10 - b[i]);
        a[i+1] = (byte)(a[i+1] - 1);
      }else{
        c[i] = (byte)(a[i]- b[i]);
      }
    }

 

    

      //reversing byte array
      int i = 0;
      int j = c.length - 1;
      byte tmp;
      while (j > i) {
          tmp = c[j];
          c[j] = c[i];
          c[i] = tmp;
          j--;
          i++;
      }
      //converting byte array to string 
      String result = "";
      for(int z = 0; z <= c.length-1; z++){
      byte x = (c[z]);
      result =  result + (Byte.toString(x));
      }


      // checking signs and making change if signs are needed to be changed
    if(signRecursive == 1 || signRecursive == 0){
      if(signRecursive == 1){
        result = "-" +result;
      }

    }else{
      if (tempsign ==1){
        result = "-" +result;

      }

    } 
      String brobcarrier = result;
      BrobInt output = new BrobInt( brobcarrier );
    signRecursive = -10;
    recursiveStop = true;
    divisionStop = true;

    return removeLeadingZeros(output);
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** 
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to be multiplied by
   *  @return BrobInt that is the end of the value of this BrobInt and the one passed in
   */
   public BrobInt multiply( BrobInt bint ) {
// Idea taken from - https://bjohnson.lmu.build/cmsi186web/homework06.html
//using professor johnsons halver method 

  BrobInt numOne = removeLeadingZeros(this);
  BrobInt numTwo = removeLeadingZeros(bint);
  BrobInt brobBottomNum = ZERO;
  BrobInt finalNum = null;
int signFinal = 0;




if(numOne == ZERO || numTwo == ZERO){
  return ZERO;
}
if((numOne.sign != numTwo.sign)){
  if ((numOne.sign == 1 && numTwo.sign == 0) || (numOne.sign == 0 && numTwo.sign == 1)){
    signFinal = 1;

  }
}else{
    signFinal = 0;
}

if(numOne.pureValue.equals(ONE.pureValue)){
  if(signFinal == 1){
  return numTwo = new BrobInt("-" + byteArrToString(numTwo.byteVersion));
  }else{
  return numTwo = new BrobInt(byteArrToString(numTwo.byteVersion));
}

}
if(numTwo.pureValue.equals(ONE.pureValue)){
 if(signFinal == 1){
  return numOne = new BrobInt("-" + byteArrToString(numOne.byteVersion));
  }else{
  return numOne = new BrobInt(byteArrToString(numOne.byteVersion));
}

}


if ((oddEven(numTwo)==false)) {
                recursiveStop = false;
                brobBottomNum = brobBottomNum.add(numOne);
            }
            while((numTwo.equals(ONE)== false)){
                recursiveStop = false;
              numOne = numOne.add(numOne);
              //using professor johnsons halver method 
              numTwo = new BrobInt(h.halve(numTwo.pureValue));
              if((oddEven(numTwo)==false)){
                recursiveStop = false;
                brobBottomNum = brobBottomNum.add(numOne);
              }
            }
if(signFinal == 1){
finalNum = new BrobInt("-" + byteArrToString(brobBottomNum.byteVersion));
}else{
finalNum = new BrobInt(byteArrToString(brobBottomNum.byteVersion));
}


return finalNum;
}


  /** 
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint  BrobInt to divide this one by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   */
   public BrobInt divide( BrobInt bint ) {
  BrobInt numOne = new BrobInt(this.internalValue);
  BrobInt numTwo = new BrobInt(bint.internalValue);



int signFinal = 0;
if((numOne.sign != numTwo.sign)){
  if ((numOne.sign == 1 && numTwo.sign == 0) || (numOne.sign == 0 && numTwo.sign == 1)){
    signFinal = 1;

  }
  if((numOne.sign == 0 && numTwo.sign == 1)){
    signFinal = 1;

  }
}
if(numOne.sign == numTwo.sign){
    signFinal = 0;
}





  BrobInt dividend = removeLeadingZeros(this);
  BrobInt dividendCheck = new BrobInt(dividend.pureValue);
  BrobInt finalNum = null;

  BrobInt divisor = new BrobInt((removeLeadingZeros(bint).pureValue ));
  dividend.sign = 0;
  dividendCheck.sign = 0;
  divisor.sign = 0;
int counter = 0;
   if(divisor.pureValue.equals(ZERO)){
    throw new IllegalArgumentException("Cannot have 0 as divisor; answer: UNDEFINED");
}

   if(dividend.pureValue.equals(ZERO.pureValue)){
    return ZERO;
}
if(divisor.absoluteValue(dividend) == 0){


 if(signFinal == 1){

finalNum = new BrobInt("-" + ONE.toString());
}else{
finalNum = new BrobInt(ONE.toString());
}
return finalNum;
}




while(divisor.absoluteValue(dividendCheck) == -1){

    dividendCheck  = divisor.subtract(dividendCheck);
  counter++;
    if (dividendCheck.equals(divisor)){
    counter++;
    break;
  }
  if(divisor.absoluteValue(dividendCheck) == 1 ){
    break;
  }



}

 String str2 = Integer.toString(counter);
if(str2.equals("0") == false){
 if(signFinal == 1){

finalNum = new BrobInt("-" + str2);
}else{
finalNum = new BrobInt(str2);
}
}else{
  return finalNum = new BrobInt(str2);
}


return finalNum;

//at end of while set dividend great than divisor
   }






  /** 
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   */
   public BrobInt remainder( BrobInt bint ) {
  BrobInt numOne = new BrobInt(this.internalValue);
  int signCarry = 0;
    String endSign = "";

  if(numOne.sign == 1){
    signCarry = 1;
    endSign = "-";
  }



    if(this == ZERO || bint == ZERO){
  throw new IllegalArgumentException("0 cannot have a remainder");
}




  BrobInt dividend = removeLeadingZeros(this);
  BrobInt dividendCheck = new BrobInt(dividend.pureValue);
  BrobInt finalNum = null;

  BrobInt divisor = new BrobInt((removeLeadingZeros(bint).pureValue ));
  dividend.sign = 0;
  dividendCheck.sign = 0;
  divisor.sign = 0;
if(divisor.pureValue.equals("1")){
  return ZERO;
  
}
if(dividend.pureValue.equals(divisor.pureValue)){
  return ZERO;
}

if(dividend.divide(dividend) == ZERO){
return new BrobInt(endSign +dividend);
}

while(divisor.absoluteValue(dividendCheck) == -1){

    dividendCheck  = divisor.subtract(dividendCheck);
    if (dividendCheck.equals(divisor)){
    dividendCheck  = divisor.subtract(dividendCheck);
    break;
  }
  if(divisor.absoluteValue(dividendCheck) == 1 ){
    break;
  }





}
if(dividendCheck != ZERO){
return new BrobInt(endSign +dividendCheck.pureValue);

}else{
  return ZERO;
}
   }

  /** 
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   */
     public int compareTo( BrobInt bint ) {


     // remove any leading zeros because we will compare lengths
      String me  = removeLeadingZeros( this ).toString();
      String arg = removeLeadingZeros( bint ).toString();

     // handle the signs here
      if( 1 == sign && 0 == bint.sign ) {
         return -1;
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      } else if( 0 == sign && 0 == bint.sign ) {
        // the signs are the same at this point ~ both positive
        // check the length and return the appropriate value
        //   1 means this is longer than bint, hence larger positive
        //  -1 means bint is longer than this, hence larger positive
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? 1 : -1;
         }
      } else {
        // the signs are the same at this point ~ both negative
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? -1 : 1;
         }
      }

     // otherwise, they are the same length, so compare absolute values
      for( int i = 0; i < me.length(); i++ ) {
         Character a = Character.valueOf( me.charAt(i) );
         Character b = Character.valueOf( arg.charAt(i) );
         if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
            return 1;
         } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
            return (-1);
         }
      }
      return 0;
   }

  /** 
   *  Method to compare the absolute value of the BrobInt passed as argument to this BrobInt 
   *  @param  bint  BrobInt to compare to the absolute value of this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using method.
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   */
   public int absoluteValue( BrobInt bint ) {
      String me  = removeLeadingZeros( this ).toStringPure();
      String arg = removeLeadingZeros( bint ).toStringPure();

    BrobInt bintfixed = removeLeadingZeros(bint);
    BrobInt thisfixed = removeLeadingZeros(this);


    String possible;
    byte tempsign = 0;
    byte[] aByte = bintfixed.byteVersion.clone();
    byte[] bByte = thisfixed.byteVersion.clone();

//me is dis

         if( bByte.length != aByte.length ) {
            return (bByte.length > aByte.length )? 1 : -1;
         }
        //   1 means this is longer than bint, hence larger positive
        //  -1 means bint is longer than this, hence larger positive
     // remove any leading zeros because we will compare lengths
      for( int i = 0; i < me.length(); i++ ) {
         Character a = Character.valueOf( me.charAt(i) );
         Character b = Character.valueOf( arg.charAt(i) );
         if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
            return 1;
         } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
            return (-1);
         }
      }
      return 0;


   }

  /**
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   */
   public boolean equals( BrobInt bint ) {
      return ( (this.sign == bint.sign) && (this.toString().equals( bint.toString() )) );
   }

  /**
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @throws NumberFormatException if the value is not a numeric long
   *  @return BrobInt  which is the BrobInt representation of the long
   */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /**
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   */
   public String toString() {
      return internalValue;
   }

    /**
   *  Method to return a the pureValue String representation of this BrobInt 
   *  @return String  which is the String representation of this BrobInt without signs
   */
   public String toStringPure() {
      return pureValue;
   }

  /**
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /**
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /**
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   */
   public void toArray( byte[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /**
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   bint  BrobInt to check if even or odd
   *  @return boolean that is true if BrobInt is even, false if not
   *  NOTE: idea taken from https://beginnersbook.com/2014/02/java-program-to-check-even-or-odd-number/
   */
   public boolean oddEven(BrobInt bint) {
// https://beginnersbook.com/2014/02/java-program-to-check-even-or-odd-number/
    boolean even;
        if (((bint.byteVersion[0] % 2 )== 0) ) {
            even = true;
        }else{
            even = false;
        }
        return even;
    }


  /**
   *  Method to display an string representation  of the reversed byte array
   *  @param   c  byte array from which to to reverse to string
   *  @return String version of c reversed byte array
   */
  public String byteArrToString (byte[] c) {
    
      //reversing byte array
      int i = 0;
      int j = c.length - 1;
      byte tmp;
      while (j > i) {
          tmp = c[j];
          c[j] = c[i];
          c[i] = tmp;
          j--;
          i++;
      }

      //converting byte array to string 
      String result = "";
      for(int z = 0; z <= c.length-1; z++){
      byte x = (c[z]);
      result =  result + (Byte.toString(x));
      }


      // checking signs and making change if signs are needed to be changed

      return result;


  }



  /**
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   */

   public static void main( String[] args ) {
          System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      BrobInt b1 = null;
            BrobInt b2 = null;;

       b1 = new BrobInt( "45" ); 

      b2 = new BrobInt( "72" ); 
       System.out.println( "  and got: " + b1.multiply( b2 ) );


      System.exit( 0 );

   }
}



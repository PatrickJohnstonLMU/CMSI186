/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntTester.java
 * Purpose    :  Test Harness for the BrobInt java class
 * @author    :  A.Volosin
 * Date       :  2019-03-01
 * Description:  
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A.Volosin     Initial writing and release
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntTester {



   //large number strings
   private static String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
   //Same large number
   private static String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
   //large number with random character C in middle
   private static String g03String = "1441279097197106640150924315024408C49849506284148982076191826176553"; 
   //Different large number
   private static String g04String = "473953485739710664015092431502440849849506284148982076191826176553";
   //large number with addition in front
   private static String g05String = "+144127909719710664015092431502440849849506284148982076191826176553";
   //large number with minus in front
   private static String g06String = "-144127909719710664015092431502440849849506284148982076191826176553";
   //large number with addition in middle
   private static String g07String = "1441279097197106640150924315024408+49849506284148982076191826176553";    
   //large number with negative in middle
   private static String g08String = "14412790971971066401509243150244084-9849506284148982076191826176553"; 
   //large number with 2 symbols in front
   private static String g09String = "-+144127909719710664015092431502440849849506284148982076191826176553"; 
   //large number with zeroes in front
   private static String g10String = "-0000144127909719710664015092431502440849849506284148982076191826176553"; 
   //large number with random character C- in front
   private static String g11String = "C-144127909719710664015092431502440849849506284148982076191826176553"; 

   //Testing character string
   private static String g12String = "c"; 
   //character string with symbol in front
   private static String g13String = "-c"; 


   //small number String
   private static String g14String = "012";
   //small number String but different number
   private static String g15String = "13";
   //small number String  and negative in front
   private static String g16String = "-13";
   //small number String  and positive in front
   private static String g17String = "+10";
   //small number String with letter in it
   private static String g18String = "+1c0";
   //addition uses
   private static String g22String = "-2";
   //addition uses
   private static String g23String = "4";
    //addition uses
   private static String g24String = "8";
   //addition uses
   private static String g25String = "12";
   //addition uses
   private static String g26String = "-3";
   //adition uses
   private static String g27String = "10000";
   //addition uses
   private static String g28String = "-10000";
   //adition uses
   private static String g29String = "-00010000";
   //adition uses
   private static String g30String = "-0001";
   //adition uses
   private static String g31String = "0.5";



   //Testing 



   private static BrobInt g1 = null;
   private static BrobInt g2 = null;
   private static BrobInt g3 = null;
   private static BrobInt g4 = null;
   private static BrobInt g5 = null;
   private static BrobInt g6 = null;
   private static BrobInt g7 = null;
   private static BrobInt g8 = null;
   private static BrobInt g9 = null;
   private static BrobInt g10 = null;
   private static BrobInt g11 = null;
   private static BrobInt g12 = null;
   private static BrobInt g13 = null;
   private static BrobInt g14 = null;
   private static BrobInt g15 = null;
   private static BrobInt g16 = null;
   private static BrobInt g17 = null;
   private static BrobInt g18 = null;
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;
   //Student added
   private static BrobInt g21 = null;
   private static BrobInt g22 = null;
   private static BrobInt g23 = null;
   private static BrobInt g24 = null;
   private static BrobInt g25 = null;
   private static BrobInt g26 = null;
   private static BrobInt g27 = null;
   private static BrobInt g28 = null;
   private static BrobInt g29 = null;
   private static BrobInt g30 = null;
   private static BrobInt g31 = null;
   private static BrobInt g32 = null;
   private static BrobInt g33 = null;
   private static BrobInt g34 = null;
   private static BrobInt g35 = null;
   private static BrobInt g36 = null;
   private static BrobInt g37 = null;
   private static BrobInt g38 = null;
   private static BrobInt g39 = null;
   private static BrobInt g40 = null;



   public BrobIntTester() {
      
   }

   public static void main( String[] args ) {
      BrobIntTester git = new BrobIntTester();

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );





      System.out.println( "   1.0 TESTING CONSTRUCTOR :\n" +
                          "    ==================================" );
//Test 1.1
         System.out.println( "    Test 1.01 : Making a new BrobInt with normal input: " );
             System.out.println( "      expecting: " + g01String);
      
      try {
                            g1 = new BrobInt( g01String );
                            System.out.println("        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "Exception thrown:  " + e.getMessage() ); }

//Test 1.2
            System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.02 : Making a new BrobInt with normal input: " );
             System.out.println( "      expecting: " + g02String);
      
      try {
                            g2 = new BrobInt( g02String );
                            System.out.println("        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "Exception thrown:  " + e.getMessage() ); }


//Test 1.3
            System.out.println( "\n\n ===========================\n");

      
         System.out.println( "    Test 1.03 : Making a new BrobInt with a random character C in the number set: " );
                  System.out.println( "      expecting: Exception thrown ");
            try {
                  g3 = new BrobInt( g03String );

         System.out.println( "        and got: " + g3.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Throw:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.4
            System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.04 : Making a new BrobInt with a large number: " );
                  System.out.println( "      expecting:" + g04String );
            try {
                  g4 = new BrobInt( g04String );

         System.out.println( "        and got: " + g4.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}

//Test 1.5
            System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.05 :Making a new BrobInt with a large number with addition in front: " );
                  System.out.println( "      expecting:" + g05String );
            try {
                  g5 = new BrobInt( g05String );

         System.out.println( "        and got: " + g5.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}

//Test 1.6
            System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.06 :Making a new BrobInt with a large number with negative in front: " );
                  System.out.println( "      expecting:" + g06String );
            try {
                  g6 = new BrobInt( g06String );

         System.out.println( "       and got: " + g6.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


   
//Test 1.7
            System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.07: Making a new BrobInt with a large number with addition in middle: " );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g7 = new BrobInt( g07String );

         System.out.println( "       and got: " + g7.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.8
            System.out.println( "\n\n ===========================\n");



         System.out.println( "    Test 1.08 : Making a new BrobInt with a large number with negative in middle:" );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g8 = new BrobInt( g08String );

         System.out.println( "       and got: " + g8.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 

      System.out.println("       Did not pass test");}


 
//Test 1.9
      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.09  :Making a new BrobInt with a large number with negative and addition in front:" );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g9 = new BrobInt( g09String );

         System.out.println( "       and got: " + g9.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.10
      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.10 :Making a new BrobInt with a large number with negative in front: " );
                  System.out.println( "      expecting:" + g10String );
            try {
                  g10 = new BrobInt( g10String );

         System.out.println( "       and got: " + g10.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.11

      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.11 : Making a new BrobInt with a large number with C- infont: " );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g11 = new BrobInt( g11String );

         System.out.println( "       and got: " + g11.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.12

            System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.12 : Making a new BrobInt with  character  C: " );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g12 = new BrobInt( g12String );

         System.out.println( "       and got: " + g12.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.13
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.13 : Making a new BrobInt with  character  -C: " );
                  System.out.println( "      expecting: Exception Thrown" );
            try {
                  g13 = new BrobInt( g13String );

         System.out.println( "       and got: " + g13.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.14
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.14 : Making a new BrobInt with normal small number input: " );
                  System.out.println( "      expecting: " + g14String );
            try {
                  g14 = new BrobInt( g14String );

         System.out.println( "       and got: " + g14.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}





//Test 1.15
            System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.15 : Making a new BrobInt with normal small number input: " );
                  System.out.println( "      expecting: " + g15String );
            try {
                  g15 = new BrobInt( g15String );

         System.out.println( "       and got: " + g15.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}






//Test 1.16

      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.16 : Making a new BrobInt with small number String  and negative in front: " );
                  System.out.println( "      expecting: " + g16String );
            try {
                  g16 = new BrobInt( g16String );

         System.out.println( "       and got: " + g16.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.17
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.17 : Making a new BrobInt with small number String  and positive in front: " );
                  System.out.println( "      expecting: " + g17String );
            try {
                  g17 = new BrobInt( g17String );

         System.out.println( "       and got: " + g17.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.18
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.18 : Making a new BrobInt with small number String with character in middle  and negative in front: " );
                  System.out.println( "      expecting:  Exception Thrown");
            try {
                  g18 = new BrobInt( g18String );

         System.out.println( "       and got: " + g18.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}





//Test 1.19
      System.out.println( "\n\n ===========================\n");

         System.out.println( "\n    Test 1.19: Making a new BrobInt, checking BrobInt.ONE: "  );
                  System.out.println( "      expecting: 1" );
            try {
                  g19 = new BrobInt( "1");

         System.out.println( "       and got: " + g19.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.20
      System.out.println( "\n\n ===========================\n");

         System.out.println( "\n    Test 1.20: Making a new BrobInt, checking BrobInt.TWO: "  );
                  System.out.println( "      expecting: 2"  );
            try {
                  g20 = new BrobInt( "2");

         System.out.println( "       and got: " + g20.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.21

      System.out.println( "\n\n ===========================\n");

         System.out.println( "\n    Test 1.21: Making a new BrobInt, checking BrobInt.THREE: "  );
                  System.out.println( "      expecting: 3"  );
            try {
                  g21 = new BrobInt( "3");

         System.out.println( "       and got: " + g21.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.22

      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.22 : Making a new BrobInt for add method: -2 as interger: " );
                  System.out.println( "      expecting: " + g22String );
            try {
                  g22 = new BrobInt( g22String );

         System.out.println( "       and got: " + g22.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.23
      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.23 : Making a new BrobInt for add method: 4 as interger: " );
                  System.out.println( "      expecting: " + g23String );
            try {
                  g23 = new BrobInt( g23String );

         System.out.println( "       and got: " + g23.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.24
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.24 : Making a new BrobInt for add method: 8 as interger: " );
                  System.out.println( "      expecting: " + g24String );
            try {
                  g24 = new BrobInt( g24String );

         System.out.println( "       and got: " + g24.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}




//Test 1.25

      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.25 : Making a new BrobInt for add method: 12 as interger: " );
                  System.out.println( "      expecting: " + g25String );
            try {
                  g25 = new BrobInt( g25String );

         System.out.println( "       and got: " + g25.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.26
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.26 : Making a new BrobInt for add method: -3 as interger: " );
                  System.out.println( "      expecting: " + g26String );
            try {
                  g26 = new BrobInt( g26String );

         System.out.println( "       and got: " + g26.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}

//Test 1.27
      System.out.println( "\n\n ===========================\n");

         System.out.println( "    Test 1.27 : Making a new BrobInt for add method: 10000 as interger: " );
                  System.out.println( "      expecting: " + g27String );
            try {
                  g27 = new BrobInt( g27String );

         System.out.println( "       and got: " + g27.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}

//Test 1.28
      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.28 : Making a new BrobInt for add method: -10000 as interger: " );
                  System.out.println( "      expecting: " + g28String );
            try {
                  g28 = new BrobInt( g28String );

         System.out.println( "       and got: " + g28.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.29
      System.out.println( "\n\n ===========================\n");



         System.out.println( "    Test 1.29 : Making a new BrobInt for add method: -00010000 as interger: " );
                  System.out.println( "      expecting: " + g29String );
            try {
                  g29 = new BrobInt( g29String );

         System.out.println( "       and got: " + g29.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}


//Test 1.30
      System.out.println( "\n\n ===========================\n");


         System.out.println( "    Test 1.30 : Making a new BrobInt for add method: -0001 as interger: " );
                  System.out.println( "      expecting: " + g30String );
            try {
                  g30 = new BrobInt( g30String );

         System.out.println( "       and got: " + g30.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}



//Test 1.31
      System.out.println( "\n\n ===========================\n");




         System.out.println( "    Test 1.31 : Making a new BrobInt for add method: 0.5 as interger: " );
                  System.out.println( "      expecting: " + g31String );
            try {
                  g31 = new BrobInt( g31String );

         System.out.println( "       and got: " + g31.toString() );
      }
      catch( Exception e ) {          System.out.println( "        and got: Exception Thrown:  " + e.getMessage()); 
      System.out.println("       Did not pass test");}







//21 tests for constructors

      



      System.out.println( "\n\n  2.0 TESTING ADD() METHODS:\n" +
                          "    ==========================" );
//Test 2.01
      try {
         System.out.println( "    Test 2.01: Adding g14 and g15 [012+ 13]: " );
         System.out.println( "      expecting: 25" + "\n" + "      got"  + g15.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.02
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.02: Adding g26 and g25 [12+ -3]: " );
         System.out.println( "      expecting: 9" + "\n" + "      got"  + g26.add( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.03
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.03: Adding g26 and g24 [8 + -3]:" );
         System.out.println( "      expecting: 5" + "\n" + "      got"  + g26.add( g24 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.04
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.04: Adding g26 and g23 [4 + -3]: " );
         System.out.println( "      expecting: 1" + "\n" + "      got"  + g26.add( g23 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.04
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.05: Adding g27 and g28 [10000 + -10000]: " );
         System.out.println( "      expecting: 0" + "\n" + "      got"  + g28.add( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.05
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.06: Adding g27 and g26 [10000 + -3]: " );
         System.out.println( "      expecting: 9997" + "\n" + "      got"  + g26.add( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.06
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.07: Adding g30 and g27 [10000 + -0001]: " );
         System.out.println( "      expecting:9999 " + "\n" + "      got"  + g30.add( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.07
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.08: Adding g29 and g30 [-00010000 + -0001]: " );
         System.out.println( "      expecting:-10001 " + "\n" + "      got"  + g30.add( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.08
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.09: Adding g14 and g30 [012 + -0001]: " );
         System.out.println( "      expecting:11 " + "\n" + "      got"  + g30.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.09
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.10: Adding g26 and g30 [-3 + -0001]: " );
         System.out.println( "      expecting:-4 " + "\n" + "      got"  + g30.add( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.10
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.11: Adding g22 and g30 [-2 + -0001]: " );
         System.out.println( "      expecting:-3 " + "\n" + "      got"  + g30.add( g22 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.11
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.12: Adding g28 and g26 [-3 + -00010000]: " );
         System.out.println( "      expecting:-10003 " + "\n" + "      got"  + g28.add( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.12
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.13: Adding g28 and g15 [13 + -10000]: " );
         System.out.println( "      expecting:-9987 " + "\n" + "      got"  + g28.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.13
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.14: Adding g29 and g15 [13 + -00010000]: " );
         System.out.println( "      expecting:-9987 " + "\n" + "      got"  + g29.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.14
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.15: Adding g29 and g17 [+10 + -00010000]: " );
         System.out.println( "      expecting:-9990 " + "\n" + "      got"  + g29.add( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.15
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.16: Adding g29 and g1 [144127909719710664015092431502440849849506284148982076191826176553 + -00010000]: " );
         System.out.println( "      expecting:144127909719710664015092431502440849849506284148982076191826166553 " + "\n" + "got"  + g29.add( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.16
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.17: Adding g29 and g25 [+12 + -00010000]: " );
         System.out.println( "      expecting:-9988 " + "\n" + "      got"  + g29.add( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
//Test 2.17
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.18: Adding g23 and g24 [4 + 8]: " );
         System.out.println( "      expecting: 12 " + "\n" + "      got"  + g24.add( g23) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.18
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.19: Adding g16 and g17 [+10 +  -13]: " );
         System.out.println( "      expecting: -3 " + "\n" + "      got"  + g16.add( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//Test 2.19
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.20: Adding g17 and g30 [+10 + -0001]: " );
         System.out.println( "      expecting 9: " + "\n" + "      got"  + g30.add( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 2.20
            System.out.println( "\n\n ===========================\n");

      try {
         System.out.println( "    Test 2.21: Adding g30 and g01 [144127909719710664015092431502440849849506284148982076191826176553  +  -0001]: " );
         System.out.println( "      expecting:144127909719710664015092431502440849849506284148982076191826176552" + "\n" + "got"  + g30.add( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }






      System.out.println( "\n\n   3.0 TESTING SUBTRACTION() METHOD:\n" +
                          "    ===========================\n");
//test 3.01
System.out.println( "\n      Test 3.01: Subtracting g14 take away g15 [012 - 13] using bytes: " );
      try {
         System.out.println( "      expecting: -1\n" +
                             "        and got: " + g15.subtract(g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.02
            System.out.println( "\n\n ===========================\n");

System.out.println( "\n      Test 3.02: Subtracting g26 take away g24 [-3 - 8] using bytes: " );
      try {
         System.out.println( "      expecting -11: \n" +
                             "        and got: " + g24.subtract( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.03
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.03: Subtracting g26 take away g25[ -3 - 012] using bytes: " );
      try {
         System.out.println( "      expecting -15: \n" +
                             "        and got: " + g25.subtract( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.04
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.04: Subtracting g26 take away g23 [-3 - 4] using bytes: " );
      try {
         System.out.println( "      expecting -7: \n" +
                             "        and got: " + g23.subtract( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.05
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.05: Subtracting g27 take away g28 [10000 -  -10000 ] using bytes: " );
      try {
         System.out.println( "      expecting 20000: \n" +
                             "        and got: " + g28.subtract( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.06
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.06: Subtracting g27 take away g26 [10000 - -3 ] using bytes: " );
      try {
         System.out.println( "      expecting 10003: \n" +
                             "        and got: " + g26.subtract( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.07
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.07: Subtracting g30 take away g27 [ -0001 -  10000 ] using bytes: " );
      try {
         System.out.println( "      expecting -10001 : \n" +
                             "        and got: " + g27.subtract( g30) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.08
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.08: Subtracting g29 take away g30 [-00010000 - -0001   ] using bytes: " );
      try {
         System.out.println( "      expecting -9999: \n" +
                             "        and got: " + g30.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.09
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.09: Subtracting g14 take away g30 [012 -  -0001 ] using bytes: " );
      try {
         System.out.println( "      expecting 13: \n" +
                             "        and got: " + g30.subtract( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.10
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.10: Subtracting g26 take away g30 [ -3  - -0001] using bytes: " );
      try {
         System.out.println( "      expecting -2: \n" +
                             "        and got: " + g30.subtract( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.11
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.11: Subtracting g22 take away g30 [-2 -  -0001] using bytes: " );
      try {
         System.out.println( "      expecting -1: \n" +
                             "        and got: " + g30.subtract( g22 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.12
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.12: Subtracting g28 take away g26 [ -10000-  -3 ] using bytes: " );
      try {
         System.out.println( "      expecting -9997: \n" +
                             "        and got: " + g26.subtract( g28 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.13
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.13: Subtracting g28 take away g15 [ -10000 - 13 ] using bytes: " );
      try {
         System.out.println( "      expecting -10013 : \n" +
                             "        and got: " + g15.subtract( g28 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.14
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.14: Subtracting g29 take away g15 [ -00010000  - 13 ] using bytes: " );
      try {
         System.out.println( "      expecting -10013: \n" +
                             "        and got: " + g15.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString()); }
//test 3.15
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.15: Subtracting g29 take away g17 [ -00010000  - +10 ] using bytes: " );
      try {
         System.out.println( "      expecting -10010 : \n" +
                             "        and got: " + g17.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.16
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.16: Subtracting g29 take away g25 [ -00010000  -12 ] using bytes: " );
      try {
         System.out.println( "      expecting -10012: \n" +
                             "        and got: " + g25.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.17
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.17: Subtracting g29 take away g1 [ -000010000  - 144127909719710664015092431502440849849506284148982076191826176553 ] using bytes: " );
      try {
         System.out.println( "      expecting -144127909719710664015092431502440849849506284148982076191826166553: \n" +
                             "        and got: " + g1.subtract( g29 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.18
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.18: Subtracting g23 take away g24 [-2  -  4] using bytes: " );
      try {
         System.out.println( "      expecting -6: \n" +
                             "        and got: " + g23.subtract( g22 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//test 3.19
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.19: Subtracting g16 take away g17 [ -13  - +10 ] using bytes: " );
      try {
         System.out.println( "      expecting -23: \n" +
                             "        and got: " + g17.subtract( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }
//test 3.20
            System.out.println( "\n\n ===========================\n");


System.out.println( "\n      Test 3.20: Subtracting g17 take away g30 [ +10 - -0001 ] using bytes: " );
      try {
         System.out.println( "      expecting 11 : \n" +
                             "        and got: " + g30.subtract( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  "  + e.toString()); }








      System.out.println( "\n\n   4.0 TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );
//Test 4.01
      System.out.println( "\n      Test 4.01: Multiplying g14 by g15 [ 012 * 13]: " );
      try {
         System.out.println( "      expecting: 156\n" +
                             "        and got: " + g14.multiply( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.02
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.02: Multiplying g26 by g25 [ -3 * 12]: " );
      try {
         System.out.println( "      expecting: -36\n" +
                             "        and got: " + g26.multiply( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.03
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.03: Multiplying g26 by g14 [-3 * 012]: " );
      try {
         System.out.println( "      expecting: -36\n" +
                             "        and got: " + g26.multiply( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.04
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.04: Multiplying g26 by g23 [ -3 * 4 ]: " );
      try {
         System.out.println( "      expecting:-12 \n" +
                             "        and got: " + g26.multiply( g23 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.05
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.05: Multiplying g27 by g28 [10000 * -10000 ]: " );
      try {
         System.out.println( "      expecting:-100000000 \n" +
                             "        and got: " + g27.multiply( g28 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }


//Test 4.06
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.06: Multiplying g27 by g26 [10000 * -3 ]: " );
      try {
         System.out.println( "      expecting: -30000\n" +
                             "        and got: " + g27.multiply( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.07
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.07: Multiplying g30 by g27 [-0001 * 10000]: " );
      try {
         System.out.println( "      expecting: -10000\n" +
                             "        and got: " + g30.multiply( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.08
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.08: Multiplying g29 by g30 [ -00010000 * -0001 ]: " );
      try {
         System.out.println( "      expecting:10000 \n" +
                             "        and got: " + g29.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.09
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.09: Multiplying g14 by g30 [12 * -0001]: " );
      try {
         System.out.println( "      expecting:-12 \n" +
                             "        and got: " + g14.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.10
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.10: Multiplying g26 by g30 [-3 * -0001 ]: " );
      try {
         System.out.println( "      expecting: 3\n" +
                             "        and got: " + g26.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.11
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.11: Multiplying g22 by g30 [-2 * -0001 ]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + g22.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.12
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.12: Multiplying g28 by g26 [ -10000 * -3]: " );
      try {
         System.out.println( "      expecting:30000 \n" +
                             "        and got: " + g28.multiply( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.13
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.13: Multiplying g28 by g15 [-10000 * 13 ]: " );
      try {
         System.out.println( "      expecting: -130000\n" +
                             "        and got: " + g28.multiply( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.14
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.14: Multiplying g29 by g15 [-00010000 * 13]: " );
      try {
         System.out.println( "      expecting: -130000 \n" +
                             "        and got: " + g29.multiply( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.15
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.15: Multiplying g29 by g17 [-00010000 * +10]: " );
      try {
         System.out.println( "      expecting:-100000 \n" +
                             "        and got: " + g29.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.16
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.16: Multiplying g29 by g1 [-00010000 * 144127909719710664015092431502440849849506284148982076191826176553]: " );
      try {
         System.out.println( "      expecting: -1441279097197106640150924315024408498495062841489820761918261765530000\n" +
                             "        and got: " + g29.multiply( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.17
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.17: Multiplying g29 by g25 [-00010000 * 12 ]: " );
      try {
         System.out.println( "      expecting:-120000 \n" +
                             "        and got: " + g29.multiply( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.18
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.18: Multiplying g23 by g24 [ 4 * 8 ]: " );
      try {
         System.out.println( "      expecting:32 \n" +
                             "        and got: " + g23.multiply( g24 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.19
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.19: Multiplying g16 by g17 [-13 * +10 ]: " );
      try {
         System.out.println( "      expecting:-130 \n" +
                             "        and got: " + g16.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



//Test 4.20
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 4.20: Multiplying g17 by g30 [ -13 * -0001 ]: " );
      try {
         System.out.println( "      expecting: 13 \n" +
                             "        and got: " + g16.multiply( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

     




      System.out.println( "\n\n   5.0 TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );

//Test 5.01
      System.out.println( "\n      Test 5.01: Dividing g14 by g 15[ 012/ 13]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g14.divide( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.02
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.02 : Dividing g26 by g25 [ -3/ 12]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g26.divide( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.03
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.03 : Dividing g26 by g14 [ -3/ 012]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g26.divide( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.04
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.04 : Dividing g26 by g23 [-3 / 4]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g26.divide( g23) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.05
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.05 : Dividing g27 by g28 [ 10000 / -10000 ]: " );
      try {
         System.out.println( "      expecting: -1 \n" +
                             "        and got: " + g27.divide( g28 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.06
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.06 : Dividing g27 by g26 [10000 / -3]: " );
      try {
         System.out.println( "      expecting: -3333\n" +
                             "        and got: " + g27.divide( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.07
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.07 : Dividing g30 by g27 [-0001 / 10000]: " );
      try {
         System.out.println( "      expecting: 0 \n" +
                             "        and got: " + g30.divide( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.08
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.08 : Dividing g29 by g30 [ -00010000/-0001 ]: " );
      try {
         System.out.println( "      expecting: 10000\n" +
                             "        and got: " + g29.divide( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.09
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.09 : Dividing g14 by g30 [ 12 / -0001 ]: " );
      try {
         System.out.println( "      expecting:-12 \n" +
                             "        and got: " + g14.divide( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.10
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.10 : Dividing g26 by g30 [-3 / -0001]: " );
      try {
         System.out.println( "      expecting: 3\n" +
                             "        and got: " + g26.divide( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.11
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.11: Dividing g22 by g30 [ -2/ -0001]: " );
      try {
         System.out.println( "      expecting: 2" +
                             "        and got: " + g22.divide( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.12
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.12 : Dividing g28 by g26 [-10000 / -3]: " );
      try {
         System.out.println( "      expecting: 3333\n" +
                             "        and got: " + g28.divide( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.13
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.13 : Dividing g28 by g15 [ -10000/13 ]: " );
      try {
         System.out.println( "      expecting: -769 \n" +
                             "        and got: " + g28.divide( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.14
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.14 : Dividing g29 by g15 [ -00010000/ 13 ]: " );
      try {
         System.out.println( "      expecting: -769\n" +
                             "        and got: " + g29.divide( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.15
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.15: Dividing g29 by g17 [-00010000 / +10]: " );
      try {
         System.out.println( "      expecting: -1000\n" +
                             "        and got: " + g29.divide( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.16
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.16 : Dividing g29 by g1 [-00010000 / 144127909719710664015092431502440849849506284148982076191826176553]: " );
      try {
         System.out.println( "      expecting:0 \n" +
                             "        and got: " + g29.divide( g1) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.17
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.17: Dividing g29 by g25 [ -00010000/12 ]: " );
      try {
         System.out.println( "      expecting:-833 \n" +
                             "        and got: " + g29.divide( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
   //Test 5.18
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.18: Dividing g23 by g24 [4 / 8]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g23.divide( g24 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
   //Test 5.19
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.19: Dividing g16 by g17 [-13 / +10 ]: " );
      try {
         System.out.println( "      expecting:-1 \n" +
                             "        and got: " + g16.divide( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 5.20
            System.out.println( "\n\n ===========================\n");


      System.out.println( "\n      Test 5.20: Dividing g17 by g30 [ +10/ -0001 ]: " );
      try {
         System.out.println( "      expecting:-10 \n" +
                             "        and got: " + g17.divide( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }


     




      System.out.println( "\n\n  6.0  TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
//Test 6.01
      System.out.println( "\n      Test 6.01 : Modding g14 by g15 [ 12 % 13 ]: " );
      try {
         System.out.println( "      expecting:12 \n" +
                             "        and got: " + g14.remainder( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.02
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.02 : Modding g26 by g25 [-3 % 12]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g26.remainder( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.03
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.03: Modding g26 by g14 [-3 % 012]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g26.remainder( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.04
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.04 : Modding g26 by g23 [-3 % 4]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g26.remainder( g23 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.05
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.05 : Modding g27 by g28 [10000 % -10000]: " );
      try {
         System.out.println( "      expecting:0 \n" +
                             "        and got: " + g27.remainder( g28 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.06
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.06 : Modding g27 by g26 [10000 % -3: " );
      try {
         System.out.println( "      expecting:1 \n" +
                             "        and got: " + g27.remainder( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.07
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.07 : Modding g30 by g27 [-0001 % 10000]: " );
      try {
         System.out.println( "      expecting: -1 \n" +
                             "        and got: " + g30.remainder( g27 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.08
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.08 : Modding g29 by g30 [ -00010000 % -0001 ]: " );
      try {
         System.out.println( "      expecting:0 \n" +
                             "        and got: " + g29.remainder( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.09
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.09 : Modding g14 by g30 [ 012 %  -0001]: " );
      try {
         System.out.println( "      expecting:0 \n" +
                             "        and got: " + g14.remainder( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.10
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.10 : Modding g26 by g30 [ -3 % -0001]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g26.remainder( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.11
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.11 : Modding g22 by g30 [-2 %  -0001]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + g22.remainder( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.12
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.12 : Modding g28 by g26 [-10000 %-3 ]: " );
      try {
         System.out.println( "      expecting:-1 \n" +
                             "        and got: " + g28.remainder( g26 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.13
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.13 : Modding g28 by g15 [ -10000 % 13 ]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g28.remainder( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.14
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6. 14: Modding g29 by g15 [ -00010000 % 13 ]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g29.remainder( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.15
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.15 : Modding g29 by g17 [ -00010000 % +10 ]: " );
      try {
         System.out.println( "      expecting: 0 \n" +
                             "        and got: " + g29.remainder( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.16
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.16 : Modding g29 by g1 [-00010000 % 144127909719710664015092431502440849849506284148982076191826176553]: " );
      try {
         System.out.println( "      expecting:-10000 \n" +
                             "        and got: " + g29.remainder( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.17
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.17 : Modding g29 by g25 [ -00010000 %  12]: " );
      try {
         System.out.println( "      expecting:-4 \n" +
                             "        and got: " + g29.remainder( g25 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.18
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.18 : Modding g23 by g24 [ 4 %  8]: " );
      try {
         System.out.println( "      expecting:4 \n" +
                             "        and got: " + g23.remainder( g24 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.19
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.19 : Modding g16 by g17 [ -13 %  +10]: " );
      try {
         System.out.println( "      expecting:-3 \n" +
                             "        and got: " + g16.remainder( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
//Test 6.20
      System.out.println( "\n\n ===========================\n");
      System.out.println( "\n      Test 6.20 : Modding g17 by g30 [ +10 %  -0001]: " );
      try {
         System.out.println( "      expecting:0 \n" +
                             "        and got: " + g17.remainder( g30 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

     
      System.exit( 0 );

   }
}
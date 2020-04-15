
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Arrays;



public class SkateRampArea {
 private static final int MINIMUM_ARG_COUNT = 3;
private static final double DEFAULT_PERCENT = 0.01;
private static final boolean DEBUG_MODE = true;
//private instance variables
private double[] coeffs      = null;
private String function      = "";
private double currentArea   = 0.0;
private double epsilon       = DEFAULT_PERCENT;
private double lastArea      = 0.0;
private double prcntChange   = 100.0;
private double lowerB        = 0.0;
private double upperB        = 0.0;
private String[] numCoeff    = null;
private String function1     = "";
private String [] snubArray  = null;
private DecimalFormat df  = new DecimalFormat( "00.0000" );



public SkateRampArea(){

}
public void validateArgsAndSetupIntergration( String [] args){
  
  int i = 0;
  String[] functions = {"poly", "sin"};

  //checks if there are enough areguments to meet the minimum, throw an exception if not
    // if 0 args, throw error
    if (args.length <= 1){
      throw new IllegalArgumentException("IllegalArgumentException: You have placed non-usable amount of arguments in the program with less than 0 arguments, please try again");
    }
 
  function1 = args[0];
  function = function1.toLowerCase();
  System.out.println(function);

  if(function.equals(functions[0]) || function.equals(functions[1])){
    if (function.equals(functions[0])){
        //if function is poly, there must be at least 5 args( func, at least 2 coefficaents of x, lb, ub)
        
          if(args.length <= 4){
            throw new IllegalArgumentException("IllegalArgumentException: Not enough arguments to enact a poly method: must have atleast 5 arguments: ( function, 2 coefficients, lower bound, upper bound, no % )");
          }

    }
    if (function.equals(functions[1])){
        // if function is sin, there must be atleast 3 args( func, lb, ub)
        
          if(args.length <= 2){
            throw new IllegalArgumentException("IllegalArgumentException: Not enough arguments to enact a sin method: must have atleast 3 arguments: ( function, lower bound, upper bound, no % )");
          }
    

    }
   
  }
  else{
    
          
          throw new IllegalArgumentException("Function " + function + " does not exist or is not compatible with program, please use either poly or sin");
  
  }
  
  
  //converts the last arguments to their numbers
  if (args[args.length -1].contains("%")){
   // now that we know there is a % in the last arg, check to make sure you have correct num of args
    // poly - need at least 6 args total
    //sin - need 4 args
   // check to see if there is a % in the last argument
   // if so

if(args.length < 6 && function.equals("poly")){
      throw new IllegalArgumentException("error, less than 6 args for poly if there is an epsilon");
    }
    else if(args.length != 4 && function.equals("sin")){
      throw new IllegalArgumentException("error, not 4 arguments fo sin, please input 4 correct arguments for sin next time");
    }
    try {
        epsilon = (Double.parseDouble( args[args.length - 1].substring( 0, args[args.length - 1].length() - 1 ) )) / 100.0;
    } catch(NumberFormatException nfe) {
       throw new IllegalArgumentException("You have inputted the wrong arguments in the wrong format or values. Please only use numbers for the bounds and coefficients");
    }


   
   try{
   // second to last arg is upper bound
    upperB = (Double.parseDouble(args[args.length - 2]));
    // third to last arg is lower bound
    lowerB = (Double.parseDouble(args[args.length - 3]));
  }catch( NumberFormatException nfe ){
          throw new IllegalArgumentException("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
         
        }
     if(function.equals("poly")){
      snubArray = Arrays.copyOfRange(args, 1, args.length - 3);


    }


   //Code for not epsilon inputted
  }else {
    if (function.equals("sin") && args.length == 4){
      System.out.println("too many arguments for sin, only need 3 if not including epsilon");
      System.exit(0);

    }
    try{
  // last arg is up
    upperB = (Double.parseDouble(args[args.length - 1]));
  //second to last arg is lb
    lowerB = (Double.parseDouble(args[args.length - 2]));
  }catch( NumberFormatException nfe ){
          throw new IllegalArgumentException("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
        }
    if(function.equals("poly")){
      snubArray = Arrays.copyOfRange(args, 1, args.length - 2);

      
    }
  // ub and lb should be parsed to doubles in a try catch
  //make sure that ub and lb are in numerical order or flip them  or throw an error
    double tempup;
    double templow;
    if (upperB < lowerB){
    
        throw new IllegalArgumentException("Upper bound is less than lower bound ( you must put the bounds in order of lower and upper ie; 1 5), or you have not put a % on the epsilon. exiting program");
       



    }

  }
  //if function is poly and there is a %, figure out how many coeff there are based on args.length as  numCoef
  // do some variation of the loop below to populate your coeff array with coefficients of x
  // make sure this is in a try catch since you are using Double.parseDouble()
try{
  if(function.equals("poly")){
    coeffs = new double[snubArray.length];
    System.out.println(Arrays.toString(snubArray));
    for (int z = 0; z <= (snubArray.length-1);z++ ){

    coeffs[z] = (Double.parseDouble(snubArray[z]));
     }

    }

}catch( NumberFormatException nfe ){
          throw new IllegalArgumentException("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
        }

if ( epsilon < 0){
throw new IllegalArgumentException("Optional Value is below 0, not a valid input, pleass try again w");
}


}
public double curvefunc(double coefficients [], double midPoint){ 
 
double result = 0;
for (int z = 0; z <= (coefficients.length-1);z++ ){
    if (z == 0){
      result = coefficients[z];
    }else{
      result = result + (coefficients[z] * Math.pow(midPoint, z));
    }
    }
  
  // Change 2.5 to midPoint
  //double result = ((cof1 * Math.pow(midPoint, 2) + (cof2 * (midPoint)) + cof3));
  return result;
}
public double midpointCalc(double lowB, double lngth, int numofRect) {
     double midpoint =  lowB + (( lngth  / 2 ) * ((numofRect*2)-1));
        return midpoint;
    }


public double CalculateAreaSin(double ub, double lb, int numRect){
double length;
double midpoint;
double yCoord;
double area = 0;
length = (( ub - lb ) / numRect);
for (int i = 1; i <= numRect; i++){
  midpoint = midpointCalc(lb,length,i);
  System.out.println("midpoint is " + midpoint);
  yCoord = Math.sin(midpoint);
  System.out.println("Ycoord is " + yCoord);
  area = area + (length *yCoord);
  System.out.println(area);


}

return area;

}

public double CalculateAreaPoly(double cof [], double ub, double lb, int numRect) {
        double length;
        double midpoint;
        double yCoord;
        double area = 0;
        System.out.println("numRect: " +  numRect);
        length = (( ub - lb ) / numRect);
        for (int i = 1; i <= numRect; i++){


       // System.out.println("Calculating Rect:" + i);
       // System.out.println("numRect: " +  numRect);
       // System.out.println("ub: " + ub);
       // System.out.println("lb: " + lb);
       // System.out.println("length: " + length);
        midpoint =  midpointCalc(lb,length,i);
      // System.out.println("midpoint is " + midpoint);
        yCoord =  curvefunc(cof, midpoint);
       // System.out.println(" Ycoord = " + yCoord);
        area = area + (length * yCoord);
       // System.out.println(area);
      }
      System.out.println(area);

        return area;
    }

public void sin(double upperBound, double lowerBound, double optional,int rectNum){
  double previousArea = CalculateAreaSin(upperBound, lowerBound, rectNum - 1);
  double currentArea = CalculateAreaSin(upperBound, lowerBound, rectNum);
  double diffPercent = 1 - ( currentArea / previousArea );
  if (diffPercent <= optional){
    System.out.println("The area");
    String end = df.format(currentArea);
   
    System.out.println(end);
    System.out.println("Number of rectangles: ");
    System.out.println(rectNum);
    
  }
  else{
    rectNum = rectNum + 1;
    sin(upperBound,lowerBound,optional,rectNum);
  }


  
}
public void poly(double coefficient [], double upperBound, double lowerBound, double optional,int rectNum){

if ( rectNum > 1000){
throw new IllegalArgumentException("Number of rectangles has reach a number of over 1000  that is not safe for the computer, exiting program");
}
  double previousArea = CalculateAreaPoly(coefficient, upperBound, lowerBound, rectNum - 1);
  double currentArea = CalculateAreaPoly(coefficient, upperBound, lowerBound, rectNum);
  double diffPercent = 1 - ( currentArea / previousArea );
  System.out.println(diffPercent);
  if (diffPercent <= optional){
    System.out.println("The area");
    String end = df.format(currentArea);
  
    System.out.println(end);
    System.out.println("Number of rectangles: ");
    System.out.println(rectNum);
  }
  else{
    rectNum = rectNum + 1;
    poly(coefficient, upperBound,lowerBound,optional,rectNum);
  }


  
}
public void runtests(){
  //Testing for curve func and midpoint are called insidee of poly and sinc calculate functions, so they are being individually tested
String argstest10[] = new String[] { "A", "B", "C", "D", "E" };
String argstest9[] = new String[] { "poly", "j", "3", "1", "j" }; 
String argstest8[] = new String[] { "Test"}; 
String argstest7[] = new String[] { }; 
String argstest6[] = new String[] { "sin", "j", "3"}; 
String argstest5[] = new String[] { "sin", "5", "3"}; 
String argstest4[] = new String[] { "sin", "2", "3"}; 
String argstest3[] = new String[] { "poly", "2", "3", "j", "4" }; 
String argstest2[] = new String[] { "cow", "2", "3", "1", "4" }; 
String argstest1[] = new String[] { "poly", "2", "3", "1", "4" };
String polymidpointcurvefun2[] = new String[] { "poly", "2", "3", "1","1","4", "1%" };
String polymidpointcurvefun3[] = new String[] { "poly", "1", "3", "3","1","4", "1%" }; 
String polymidpointcurvefun4[] = new String[] { "poly", "2", "3", "3","1","4", "1%" }; 
String polymidpointcurvefun5[] = new String[] { "poly", "2","2","2","2","2","2", "3", "3","1","4", "1%" };
String polymidpointcurvefun6[] = new String[] { "poly", "-2","2", "3", "-2","1","4", "1%" }; 
String polymidpointcurvefun7[] = new String[] { "poly", "-2","2", "3", "-2","1","4" }; 
String polymidpointcurvefun8[] = new String[] { "poly", "-2","-2", "-3", "-2","1","4" }; 
String polymidpointcurvefun9[] = new String[] { "poly", "-2","2","-1","-4" }; 
String polymidpointcurvefun10[] = new String[] { "poly", "-2","2","-1","6","4" }; 
String sintest1[] = new String[] { "sin", "1", "3"}; 
String sintest2[] = new String[] { "sin", "1", "3", "%1"};
String sintest3[] = new String[] { "sin", "1", "3", "%10"}; 
String sintest4[] = new String[] { "sin", "-2", "3", "%1"}; 
String sintest5[] = new String[] { "sin", "-2", "3"}; 
String sintest6[] = new String[] { "sin", "-2", "9", "2%"};
String sintest7[] = new String[] { "sin", "10", "20", "2%"}; 
String sintest8[] = new String[] { "sin", "-2", "9", "70%"};
String sintest9[] = new String[] { "sin", "2", "9", "20%"}; 
String sintest10[] = new String[] { "sin", "-4", "9", "4%"}; 













System.out.println("test 1 for validate args- all arguments are run through validates args before it can be passed through methods- testing correct args, expect good");
try { 

  validateArgsAndSetupIntergration(argstest1);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }
System.out.println("test 1 for validate args- good");
System.out.println("==============================");
System.out.println("test 2 for validate args - testing function as cow, expect error ");
try { 

  validateArgsAndSetupIntergration(argstest2);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 2 for validate args, expect and error");
System.out.println("==============================");
System.out.println("test 3 for validate args - testing letter as bounds, expect error ");
try { 

  validateArgsAndSetupIntergration(argstest3);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 3 for validate args, expect and error");
System.out.println("==============================");
System.out.println("test 4 for validate args - testing Sin, expect nothing as it is good ");
try { 

  validateArgsAndSetupIntergration(argstest4);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 4 for validate args. good");
System.out.println("==============================");
System.out.println("test 5 for validate args - testing Sin, expect error as bounds are switched");
try { 

  validateArgsAndSetupIntergration(argstest5);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 5 for validate args, error expected");
System.out.println("==============================");
System.out.println("test 6 for validate args - testing Sin, expect error as bounds are letters");
try { 

  validateArgsAndSetupIntergration(argstest6);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 6 for validate args, error expected");
System.out.println("==============================");
System.out.println("test 7 for validate args - testing Sin, no args, error expected");
try { 

  validateArgsAndSetupIntergration(argstest7);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 7 for validate args, error expected");
System.out.println("==============================");

System.out.println("test 8 for validate args - testing non function, no args, error expected");
try { 

  validateArgsAndSetupIntergration(argstest8);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 8 for validate args, error expected");
System.out.println("==============================");
System.out.println("test 9 for validate args - testing poly, letters as coeffeicent and bound");
try { 

  validateArgsAndSetupIntergration(argstest9);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 9 for validate args, error expected");
System.out.println("==============================");
System.out.println("test 10 for validate args - testing all letter args");
try { 

  validateArgsAndSetupIntergration(argstest9);   
   } catch (IllegalArgumentException iae) {
    System.out.println("===============not passed=====================");

      System.out.println(iae.getMessage());
   }  
System.out.println("test 10 for validate args, error expected");
System.out.println("====================================");

System.out.println("test 1 for testing poly, curve func, and midpoint without 1%  correct");
 try{
        validateArgsAndSetupIntergration(argstest1);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 2 for testing poly, curve func, and midpoint with 1% - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun2);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 3 for testing poly, curve func, and midpoint with 1% - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun3);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 4 fortesting poly, curve func, and midpoint with 1%, changing numbers - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun4);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 5 for testing poly, curve func, and midpoint with 1%, 10 coeffeicents - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun5);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 6 for testing poly, curve func, and midpoint with 1%, many coeffeicents and negtaitv intergers - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun6);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 6 for testing poly, curve func, and midpoint with 1%, many coeffeicents and negtaitv intergers - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun6);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 7 for testing poly, curve func, and midpoint with no 1% and negtaitive intergers - correct ");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun7);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 8 for testing poly, curve func, and midpoint with no 1% and negtaitive intergers, including bounds - correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun8);
      }catch (IllegalArgumentException iae){
                System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
                System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 8 for testing poly, curve func, and midpoint with no 1% and negtaitive intergers, including bounds -correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun8);
      }catch (IllegalArgumentException iae){
                System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
                System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 9 for testing poly, curve func, and midpoint with 5 args including bounds- correct ");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun9);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println(nfe.getMessage());

      }
System.out.println("====================================");
System.out.println("test 10 for testing poly, curve func, and midpoint with 7 args including bounds -correct");
  try{
        validateArgsAndSetupIntergration(polymidpointcurvefun10);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 1 for testing sin, curve func, correct args - correct ");
  try{
        validateArgsAndSetupIntergration(sintest1);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("===============not passed=====================");
System.out.println("test 2 for testing sin, curve func, correct args with % -correct");
  try{
        validateArgsAndSetupIntergration(sintest2);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 3 for testing sin, curve func, correct args with % 10 - correct");
  try{
        validateArgsAndSetupIntergration(sintest3);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 4 for testing sin, curve func,  with negative correct args with % 5 - correct");
  try{
        validateArgsAndSetupIntergration(sintest4);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 5 for testing sin, curve func,  with negative correct args with % 10 - correct");
  try{
        validateArgsAndSetupIntergration(sintest5);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 6 for testing sin, curve func,  with negative correct args with % 1 - correct");
  try{
        validateArgsAndSetupIntergration(sintest6);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");
System.out.println("test 7 for testing sin, curve func,  with negative correct args with % 1 - correct");
  try{
        validateArgsAndSetupIntergration(sintest7);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");

System.out.println("test 8 for testing sin, curve func,  with negative correct args with % 1 - correct");
  try{
        validateArgsAndSetupIntergration(sintest8);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");

System.out.println("test 9 for testing sin, curve func,  with negative correct args with % 1 - correct");
  try{
        validateArgsAndSetupIntergration(sintest9);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");

System.out.println("test 10 for testing sin, curve func,  with negative correct args with % 1 - correct");
  try{
        validateArgsAndSetupIntergration(sintest10);
      }catch (IllegalArgumentException iae){
        System.out.println("===============not passed=====================");

        System.out.println(iae.getMessage());
      }try{
        if(function.equals("poly")){
          poly(coeffs,upperB,lowerB,epsilon,2);
        }
        if(function.equals("sin")){
          sin(upperB,lowerB,epsilon,2);
        }
      }catch(NumberFormatException nfe){
        System.out.println("===============not passed=====================");

        System.out.println("error found");
      }
System.out.println("====================================");













}
   public static void main( String arg[] ) {
        SkateRampArea myPSS = new SkateRampArea();
        System.out.println(arg[0]);
        if(arg[0].equals("runtests")){
          System.out.println("got to here");
          myPSS.runtests();

          System.exit(0);
        }
        try{
        myPSS.validateArgsAndSetupIntergration(arg);
      }catch (IllegalArgumentException iae){
        System.out.println(iae.getMessage());
        System.exit(0);
      }
        if(myPSS.function.equals("poly")){
          myPSS.poly(myPSS.coeffs,myPSS.upperB,myPSS.lowerB,myPSS.epsilon,2);
        }
        if(myPSS.function.equals("sin")){
          myPSS.sin(myPSS.upperB,myPSS.lowerB,myPSS.epsilon,2);
        }
       
   }
}
  
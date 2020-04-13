
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
  try{
    if (args.length <= 1){
      throw new IllegalArgumentException();
    }
  }catch(IllegalArgumentException iae){
    System.out.println("IllegalArgumentException: You have placed non-usable amount of arguments in the program with less than 0 arguments, please try again");
    System.exit(0);
    //catch exception
  }
  function1 = args[0];
  function = function1.toLowerCase();
  System.out.println(function);

  if(function.equals(functions[0]) || function.equals(functions[1])){
    if (function.equals(functions[0])){
        //if function is poly, there must be at least 5 args( func, at least 2 coefficaents of x, lb, ub)
        try{
          if(args.length <= 4){
            throw new IllegalArgumentException();
          }
        }catch(IllegalArgumentException iae){
          System.out.println("IllegalArgumentException: Not enough arguments to enact a poly method: must have atleast 5 arguments");
          System.exit(0);
        }

    }
    if (function.equals(functions[1])){
        // if function is sin, there must be atleast 3 args( func, lb, ub)
        try{
          if(args.length <= 2){
            throw new IllegalArgumentException();
          }
        }catch(IllegalArgumentException iae){
          System.out.println("IllegalArgumentException: Not enough arguments to enact a sin method: must have atleast 3 arguments");
          System.exit(0);
        }

    }
   
  }
  else{
    try{
          System.out.println("Function " + function + " does not exist or is not compatible with program, please use either poly or sin");
          throw new IllegalArgumentException();

    }catch(IllegalArgumentException iae){
      System.exit(0);
    }

  
  }
  
  
  //converts the last arguments to their numbers
  if (args[args.length -1].contains("%")){
   // now that we know there is a % in the last arg, check to make sure you have correct num of args
    // poly - need at least 6 args total
    //sin - need 4 args
   // check to see if there is a % in the last argument
   // if so
   try{
    if(args.length < 6 && function.equals("poly")){
      throw new IllegalArgumentException();
    }
    if(args.length != 4 && function.equals("sin")){
      throw new IllegalArgumentException();
    }

    epsilon = (Double.parseDouble( args[args.length - 1].substring( 0, args[args.length - 1].length() - 1 ) )) / 100.0;
    
   } catch(IllegalArgumentException iae) {
   System.out.println("You have inputted the wrong arguments in the wrong format or values. Please only use numbers for the bounds and coefficients");
   System.exit(0);
   }
   try{
   // second to last arg is upper bound
    upperB = (Double.parseDouble(args[args.length - 2]));
    // third to last arg is lower bound
    lowerB = (Double.parseDouble(args[args.length - 3]));
  }catch( NumberFormatException nfe ){
          System.out.println("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
          System.exit(0);
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
          System.out.println("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
          System.exit(0);
        }
    if(function.equals("poly")){
      snubArray = Arrays.copyOfRange(args, 1, args.length - 2);

      
    }
  // ub and lb should be parsed to doubles in a try catch
  //make sure that ub and lb are in numerical order or flip them  or throw an error
    if (upperB < lowerB){
      try{
        System.out.println("Upper bound is less than lower bound, exiting program and or epsilon must have a % at the end");
        throw new IllegalArgumentException();
      } catch(IllegalArgumentException iae) {
        System.exit(0);
         }



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
          System.out.println("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
          System.exit(0);
        }
try{
if(function.equals("poly")){
if(coeffs.length > 3){
  throw new NumberFormatException();

}
}

}catch(NumberFormatException nfe){
  System.out.println("you have inputed too many values for the polynomial, exiting program");
  System.exit(0);
}



}
public double curvefunc(double coefficients [], double midPoint){ 
  double cof1 = coefficients[2];
  double cof2 = coefficients[1];
  double cof3 = coefficients[0];
  System.out.println("cof1: " + cof1);
  System.out.println("cof2: " + cof2);
  System.out.println("cof3: " + cof3);
  // Change 2.5 to midPoint
  double result = ((cof1 * Math.pow(midPoint, 2) + (cof2 * (midPoint)) + cof3));
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
    
  }
  else{
    rectNum = rectNum + 1;
    sin(upperBound,lowerBound,optional,rectNum);
  }


  
}
public void poly(double coefficient [], double upperBound, double lowerBound, double optional,int rectNum){

  double previousArea = CalculateAreaPoly(coefficient, upperBound, lowerBound, rectNum - 1);
  double currentArea = CalculateAreaPoly(coefficient, upperBound, lowerBound, rectNum);
  double diffPercent = 1 - ( currentArea / previousArea );
  if (diffPercent <= optional){
    System.out.println("The area");
    String end = df.format(currentArea);
  
    System.out.println(end);
  }
  else{
    rectNum = rectNum + 1;
    poly(coefficient, upperBound,lowerBound,optional,rectNum);
  }


  
}
   public static void main( String arg[] ) {
        SkateRampArea myPSS = new SkateRampArea();
        myPSS.validateArgsAndSetupIntergration(arg);
        if(myPSS.function.equals("poly")){
          myPSS.poly(myPSS.coeffs,myPSS.upperB,myPSS.lowerB,myPSS.epsilon,2);
        }
        if(myPSS.function.equals("sin")){
          myPSS.sin(myPSS.upperB,myPSS.lowerB,myPSS.epsilon,2);
        }
       
   }
}
  
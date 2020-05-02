import java.io.Console;
public class Collatz {
  public static void main(String[] args){
System.out.println("=======Welcome to Collatz Conjecture! Proccessing your input now=======");
BrobInt brob = null; 
      String passToBrob = args[0];
            if (args.length > 1 ) {
      System.out.println("Please input a single even number");
      System.out.println("Exiting program");
      System.exit(0);
    }
    try{
    brob = new BrobInt(passToBrob);
  }catch( Exception e ) {          System.out.println( "Please follow Directions! Exception Thrown:  " + e.getMessage());
  System.out.println("Exiting program");
  System.exit(0);
}
if(brob.sign == 1){
  System.out.println("Please input a non-negative number");
  System.out.println("Exiting program");
  System.exit(0);
}
if(brob.allZeroDetect(brob) == true){
  System.out.println("Please do not enter zero");
  System.out.println("Exiting program");
  System.exit(0);
}

BrobInt one = new BrobInt("1");
BrobInt two = new BrobInt("2");
BrobInt three = new BrobInt("3");


int steps = 0;
BrobInt numberWorked = brob;
while((numberWorked.toString().equals(one.toString())) == false){
  if (numberWorked.oddEven(numberWorked) == true){
      //Even loop
    String outputEven = (numberWorked.divide( two )).toString();
    numberWorked = new BrobInt(outputEven);
    System.out.println(outputEven);
    
    steps++;
  }
  if(numberWorked.oddEven(numberWorked) == false && (numberWorked.toString().equals(one.toString())) == false ){
  numberWorked = numberWorked.multiply(three);
  String outputOdd  = (numberWorked.add(one)).toString();
  numberWorked = new BrobInt(outputOdd);
  System.out.println(outputOdd);
  //Odd loop

  steps++;
  }
}
System.out.println("It took " + steps + " step(s) to go from " + passToBrob + " to " + numberWorked.toString() );





  }




  
}
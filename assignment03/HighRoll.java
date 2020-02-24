import java.io.Console;
public class HighRoll {
  public static void main(String[] args){
    int highScore = 0;
    int currentScore = 0;
    int count = 0;
    int sides = 0;
    if (args.length != 2) {
      System.out.println("Please input usable values");
      System.exit(0);
    }
    try {
      count = Integer.parseInt(args[0]);
      sides = Integer.parseInt(args[1]);
      if (count < 1){
      System.out.println(" Too few dice, exiting program, run again and put in more dice");
      System.exit(0);
    }

    } catch (NumberFormatException nfe){
      System.out.println("Format unacceptable");
      System.exit(0);
    }
    DiceSet set = new DiceSet(count, sides);
       while(true){
      System.out.println( "\n   Welcome to the HighRoll program!!\n" );      
      Console console = System.console();

      while( true ) {
        // System.out.print( ">>" );

         try {
            
            System.out.println("Options:");
            System.out.println(" R – Rolls all the dice, then prints the DiceSet\n D – Asks the user which Die they want to roll, rolls it, then prints the DiceSet\n C – Calculates the current score and prints it\n S – Saves current score as the high score\n Y – Displays the current high score\n Q – Quits the program\n");
            String command = console.readLine("Input Letter Option!( Must be uppercase ) ").trim();
            /*if( 'q' == command.charAt(0) ) {
               break;
                } */

            switch (command) {
               case "R": System.out.println("===============\n You have Chosen R - Rolling DiceSet -");
                         set.roll();  
                         System.out.println(" Here is the dice Set: " + set.toString());
                         System.out.println("===============\n");
                          break;
               case "D": System.out.println("===============\n You have Chosen D - Input Dice Index you want to roll, with the first die having an index of 1 -");
                         String index = console.readLine("Input: ").trim();
                         Integer indexInt = (Integer.valueOf(index)-1);
                         System.out.println("Here is the value of the die you rolled: " + set.rollIndividual(indexInt));
                         System.out.println(" Here is the dice Set: " + set.toString());
                         System.out.println("===============\n");
                         break;
               case "C": System.out.println("===============\n You have Chosen C - Finding Current Score -"); 
                         currentScore = set.sum();
                         System.out.println("Current Score: " + currentScore);
                         System.out.println("===============\n"); 
                         break;
               case "S": System.out.println("===============\n You have Chosen S - Saving your Current Score as the high score -");
                         currentScore = set.sum();
                         System.out.println("Your Current Score: " + currentScore);
                         System.out.println("The Current High Score: " + highScore);
                         highScore = currentScore;
                         System.out.println("Current High score is now: " + highScore);
                         System.out.println("===============\n ");
                         break;
                       
               case "Y": System.out.println("===============\n You have Chosen Y - Printing current high score -");
                         System.out.println("Current High score is now: " + highScore);
                         System.out.println("===============\n ");
                         break;
               case "Q": System.out.println("You chose to quit, but in life, never quit. Remeber you are great and nothing can stop you! Bye!");System.exit(0);
               default: System.out.println("Incorrect Value inputed, please input a menu Ooption");
            }

         } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("You have entered an incorrect value for whatever action you were trying to complete, please read more carefully and try again");
         }  
      }
    }










  }




  
}

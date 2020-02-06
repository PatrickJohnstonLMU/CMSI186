/**
 * By Ray Toal
 */

public class PiEstimator {
    public static void main(String[] args) {
        int totalDarts = 10000;
        System.out.println("WELCOME TO THE PI ESTIMATOR PROGRAM");
        if (args.length != 1) {


            System.out.println("Variable number of darts was set to 0, default number of darts shall now be 10,000");

        } else {


            try {
                totalDarts = Integer.parseInt(args[0]);

            } catch (NumberFormatException nfe) {
                System.out.println("   Sorry, bad input: must be an integer number!  Please try again...");
                System.exit(0);
            }
        }

        double circleEstimate = (estimate(totalDarts));
        System.out.println("The estimate of Pi is : " + circleEstimate);
    }

    public static double estimate(int darts) {
        double aSq = 4;
        double aCir = 3.14;
        double dartCounter = darts;
        double numInCir = 0;


        do {
            double x1 = Math.random() * 2;
            double y1 = Math.random() * 2;
            double dstnceFrmCntr = Math.sqrt(Math.pow((1 - x1), 2) + Math.pow((1 - y1), 2));
            dartCounter--;
            if (dstnceFrmCntr <= 1.0) {
                numInCir++;
            } else {
                numInCir = numInCir;
            }
        } while (dartCounter > 0);
        System.out.println(4 * (numInCir / darts));
        System.out.println("The number of darts that have landed in the circle is " + numInCir + " darts");
        double cirEst = 4 * (numInCir / darts);
 







        return cirEst;
    }


    // Don't be afraid to put in some private "helper" methods. You don't have to, of
    // course, but they could be useful and keep your code modular.
    //
}
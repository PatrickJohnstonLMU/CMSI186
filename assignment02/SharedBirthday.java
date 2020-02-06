public class SharedBirthday {
    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    public static double probabilityEstimate(int people, int days, int trials) {
        int[] daysArray = new int[days];
        int successfulTrial = 0;
        for (int i = 0; i < trials; i++) {
            int sharedBdayCount = 0;    // variables should start with a lowercase. Classes start with uppercase.
            for (int y = 0; y < daysArray.length; y++) {
             daysArray[y] = 0;
            }
            for (int x = 0; x < people; x++){
            int bdayindividual =  (int)Math.floor(Math.random()*days);
            daysArray[bdayindividual]++;
            }
            for(int z = 0; z < daysArray.length; z ++){
                if (daysArray[z] > 1) {     // this loop counts number of days with a shared birthday
                                            // so it should check to see if there is more than 1
                                            // birthday on a given day
                    sharedBdayCount ++;
                }
            }
            if (sharedBdayCount >= 1) {
                successfulTrial++;
            }
        }
        
        return (double)successfulTrial/ trials;
    }
    //
    // TODO: Don't be afraid to write private helper methods to keep your code modular.
    //
}
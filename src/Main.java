import data.Trip;
import state.TripStateLoop;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TripStateLoop tripStateLoop = new TripStateLoop();
        Trip trip;

        try {
            trip = tripStateLoop.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("Simulate trip reload to correct state? [yes]");

            if (scanner.nextLine().toLowerCase().trim().equals("yes")){
                try {
                    tripStateLoop.execute(trip);
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                    break;
                }
            } else {
                System.out.println("Exiting...");
                break;
            }

        }
    }
}

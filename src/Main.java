import data.Trip;
import data.TripRepository;
import state.TripStateLoop;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TripRepository tripRepository = new TripRepository();

        TripStateLoop tripStateLoop = new TripStateLoop();
        Trip trip;

        try {
            trip = tripStateLoop.execute();
            tripRepository.storeTrip(trip.getId(), trip);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.println("Would you like simulate a trip by ID?");

            if (scanner.nextLine().toLowerCase().trim().equals("yes")){
                try {
                    tripRepository.printTrips();
                    System.out.println("Enter the ID: ");
                    String id = scanner.nextLine();


                    if (tripRepository.isTripInRepo(id)) {
                        trip = tripRepository.retrieveTrip(id);
                    }

                    tripStateLoop.execute(trip);
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                    break;
                }

            } else {

                System.out.println();
                System.out.println("Simulate trip reload to correct state? [yes] or [no] or [exit]");

                String input = scanner.nextLine().toLowerCase().trim();

                if (input.equals("yes")) {
                    try {
                        tripStateLoop.execute(trip);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                } else if (input.equals("no")) {
                    try {
                        trip = tripStateLoop.execute();
                        tripRepository.storeTrip(trip.getId(), trip);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (input.equals("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
            }

        }
    }
}

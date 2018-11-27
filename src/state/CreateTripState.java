package state;

import data.TravelAgent;
import data.TravelAgents;
import data.Trip;
import state.TripContext;
import state.TripState;
import state.TripStateLoop;

import java.util.List;
import java.util.Scanner;

public class CreateTripState extends TripState {
    protected CreateTripState(TripContext tripContext) {
        super(tripContext);

        Trip trip = new Trip();
        trip.setStatus(Status.CreateTrip);

        getTripContext().setTrip(trip);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("*** NEW TRIP CREATED ***");


        while (true) {
            List<TravelAgent> agents = TravelAgents.retrieveAgents();
            System.out.println("Select which agent you are: ");
            for (int i = 0; i < agents.size(); i++) {
                System.out.println(i + ". " + agents.get(i));
            }
            try {
                int agentIndex = scanner.nextInt();
                if (agentIndex < 0 || agents.size() <= agentIndex) {
                    throw new NumberFormatException();
                }
                getTripContext().getTrip().setReserver(agents.get(agentIndex));
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input entered.");
                scanner.nextLine();
            }
        }

        getTripContext().changeState(new AddTravellersState(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}

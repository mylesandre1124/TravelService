package state;

import data.*;
import data.Package;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddTravellersState extends TripState {
    protected AddTravellersState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("*** ADD TRAVELLERS TO TRIP ***");
        System.out.println();

        boolean addPackages = true;

        while (addPackages) {
            System.out.print(
                    "- COMMAND: [later] to return later, [done] to finish adding travellers, [continue] to add travellers: ");

            TripState.Command command = getCommand(scanner.next().trim());
            switch (command) {
                case LATER:
                    return TripStateLoop.Status.Stop;
                case DONE:
                    if (getTripContext().getTrip().isNumberOfTravellersValid()) {
                        getTripContext().changeState(new AddPackagesState(getTripContext()));
                        return TripStateLoop.Status.Continue;
                    }
                    System.out.println("There are not enough packages in trip to finish");
                    break;
                case CONTINUE:
                    break;
                default:
                    System.out.println("Invalid Input Entered. Please Try Again.");
                    return TripStateLoop.Status.Continue;
            }

            System.out.println();

            List<Traveller> travellers = Travellers.retrieveTravellers();

            System.out.println("Enter a number to select a traveller to add to Trip:");
            try {
                for (int i = 0; i < travellers.size(); i++) {
                    System.out.println(i + ") " + travellers.get(i));
                }

                int travellersIndex = scanner.nextInt();

                if (travellersIndex >= 0 && travellersIndex < travellers.size()) {
                    Traveller traveller = travellers.get(travellersIndex);
                    getTripContext().getTrip().addTraveller(traveller);
                    System.out.println("- Added Traveller [" + traveller + "]");
                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Invalid Input Received");
            }
        }

        getTripContext().changeState(new ChoosePaymentState(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}

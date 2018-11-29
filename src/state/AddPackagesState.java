package state;

import data.Package;
import data.Packages;
import data.Place;
import data.Places;
import data.Trip;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddPackagesState extends TripState {
    protected AddPackagesState(TripContext tripContext) {
        super(tripContext, Status.AddPackages);
    }

    @Override
    public TripStateLoop.Status execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("*** ADD PACKAGES TO TRIP ***");
        System.out.println();

        boolean addPackages = true;

        while (addPackages) {
            System.out.print(
                    "- COMMAND: [later] to return later, [done] to finish adding packages, [continue] to add packages: ");

            TripState.Command command = getCommand(scanner.next().trim());
            switch (command) {
                case LATER:
                    return TripStateLoop.Status.Stop;
                case DONE:
                    if (getTripContext().getTrip().isNumberOfPackagesValid()) {
                        getTripContext().changeState(new ChoosePaymentState(getTripContext()));
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

            List<Package> packages = Packages.retrievePackages();

            System.out.println("Enter a number to select a package to add to Trip:");
            try {
                for (int i = 0; i < packages.size(); i++) {
                    System.out.println(i + ") " + packages.get(i));
                }

                int packageIndex = scanner.nextInt();

                if (packageIndex >= 0 && packageIndex < packages.size()) {
                    Package aPackage = packages.get(packageIndex);
                    getTripContext().getTrip().addPackage(aPackage);
                    System.out.println("- Added Package [" + aPackage + "]");
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

package decorator;

import data.Package;
import data.Payment;

import java.util.List;

public class BillingDetailsDecorator extends ItineraryDecorator {
    public BillingDetailsDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        List<Package> packages = decoratedItinerary.getTrip().getPackages();

        System.out.println("Billing Details");

        System.out.println("Total Cost: $" + String.format("%.2f", decoratedItinerary.getTrip().getTotal()));

        System.out.println("Paid in full by the Money Guy using " + decoratedItinerary.getTrip().getPayment());

        for (int i = 0; i < packages.size(); i++) {
            System.out.println(i + ". " + packages.get(i).toString() + "\n" + String.format("%.2f", packages.get(i).getPrice()));

        }
        System.out.println(System.lineSeparator());
    }

}

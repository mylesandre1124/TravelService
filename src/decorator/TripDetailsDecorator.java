package decorator;

import data.Package;

import java.util.List;

public class TripDetailsDecorator extends ItineraryDecorator {
    public TripDetailsDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        List<Package> packages = decoratedItinerary.getTrip().getPackages();

        System.out.println("Trip Details");

        for (int i = 0; i < packages.size(); i++) {
            System.out.println(i + ". " + packages.get(i).toString());
        }
        System.out.println(System.lineSeparator());

    }
}

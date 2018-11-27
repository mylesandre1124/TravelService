package decorator;

import data.Package;
import data.Packages;
import data.Places;
import data.Repository;
import data.Traveller;

import java.util.List;

public class TravellersDecorator extends ItineraryDecorator {


    public TravellersDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        List<Traveller> travellerList = decoratedItinerary.getTrip().getTravellers();
        System.out.println(travellerList.size() + " Traveller(s)");

        for (int i = 0; i < travellerList.size(); i++) {
            System.out.println(i + ") " + travellerList.get(i).getName());
        }

        System.out.println();

        Repository repository = new Packages();
        repository.retrieveData();

        repository = new Places();
        repository.retrieveData();

    }
}

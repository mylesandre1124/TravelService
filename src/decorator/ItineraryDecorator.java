package decorator;

public abstract class ItineraryDecorator extends Itinerary {

    protected final Itinerary decoratedItinerary;

    public ItineraryDecorator(Itinerary itinerary) {
        decoratedItinerary = itinerary;
        trip = decoratedItinerary.trip;
    }

    public void printItineraryComponent() {
        decoratedItinerary.printItineraryComponent();
    }

}

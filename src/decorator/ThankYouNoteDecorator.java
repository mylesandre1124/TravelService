package decorator;

public class ThankYouNoteDecorator extends ItineraryDecorator {


    public ThankYouNoteDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        System.out.println(decoratedItinerary.getTrip().getThankYouNote());
    }
}

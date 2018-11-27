package state;

import decorator.*;

public class ShowItineraryState extends TripState {
    protected ShowItineraryState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Itinerary itinerary = new ItineraryImpl(getTripContext().getTrip());
        itinerary = new WelcomeMessageDecorator(itinerary);
        itinerary = new TravellersDecorator(itinerary);
        itinerary = new TripDetailsDecorator(itinerary);
        itinerary = new BookingDetailsDecorator(itinerary);
        itinerary = new BillingDetailsDecorator(itinerary);
        itinerary = new ThankYouNoteDecorator(itinerary);
        itinerary.printItineraryComponent();
        getTripContext().changeState(new CompleteState(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}

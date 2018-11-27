package decorator;

public class BookingDetailsDecorator extends ItineraryDecorator {
    public BookingDetailsDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        System.out.println("Every detail your trip was booked with care by " + decoratedItinerary.getTrip().getReserver().getName() +
                " If you have any questions or problems, call " + decoratedItinerary.getTrip().getReserver().getName() + " at " + decoratedItinerary.getTrip().getReserver().getPhoneNumber() + " anytime, 24 hours a day.\n ");
    }
}

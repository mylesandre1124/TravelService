package decorator;

public class WelcomeMessageDecorator extends ItineraryDecorator {
    public WelcomeMessageDecorator(Itinerary itinerary) {
        super(itinerary);
    }

    @Override
    public void printItineraryComponent() {
        super.printItineraryComponent();
        System.out.println("Itinerary by " + decoratedItinerary.getTrip().getReserver().getName() + ", "
                + decoratedItinerary.getTrip().getReserver().getPhoneNumber() +"\n" +
                decoratedItinerary.getTrip().getMainTraveller().getName() + " – Your trip to Fiji is all set. " +
                "I have booked top-quality transport for every leg of your trip. " +
                "I am including a fine bottle of your favorite drink, Boones Farm Sunshine Pink, " +
                "to enjoy along the way. If you have any questions or problems, call me anytime. " +
                "Safe travels! " + decoratedItinerary.getTrip().getReserver().getName() + "Certified Premium Travel Service Agent\n");
    }


}

package state;

public class TripContextStateFactory {

    public static TripState get(TripContext context) throws Exception {
        assert context != null;
        assert context.getTrip() != null;

        TripState.Status tripStatus = context.getTrip().getStatus();

        switch (tripStatus) {
            case CreateTrip:
                return new CreateTripState(context);
            case AddTravellers:
                return new AddTravellersState(context);
            case AddPackages:
                return new AddPackagesState(context);
            case AcceptPaymentCash:
                return new AcceptPaymentCashState(context);
            case AcceptPaymentCheck:
                return new AcceptPaymentCheckState(context);
            case AcceptPaymentCreditCard:
                return new AcceptPaymentCreditCardState(context);
            case AddThankYou:
                return new AddThankYouState(context);
            case ShowItinerary:
                return new ShowItineraryState(context);
            case Complete:
                return new CompleteState(context);
            default:
                throw new Exception(tripStatus + " is an invalid state");
        }
    }
}

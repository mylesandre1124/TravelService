package state;


import data.Trip;

public class TripContext {

    private Trip trip;
    private TripState tripState;

    public TripContext() {
        this.tripState = new CreateTripState(this);
    }

    public TripContext(Trip trip) throws Exception {
        this.trip = trip;
        this.tripState = TripContextStateFactory.get(this);
    }

    public void changeState(TripState state) {
        tripState = state;
    }

    public void reset() {
        changeState(null);
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public TripStateLoop.Status execute() { return tripState.execute(); }
}

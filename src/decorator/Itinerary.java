package decorator;

import data.Trip;

public abstract class Itinerary {

    protected Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public abstract void printItineraryComponent();
}

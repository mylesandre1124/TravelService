package data;

import java.util.List;
import java.util.Random;

public class Package {

    private Reservation reservation;
    private double hoursOfTravelTime;
    private Place origin;
    private Place destination;
    private double price;
    private TransportType transportType;

    public Package(Place origin, Place destination, TransportType transportType) {
        this.hoursOfTravelTime = Math.random() * 10;
        this.origin = origin;
        this.destination = destination;
        this.price = Math.random() * 100000;
        this.transportType = transportType;
        this.reservation = new Reservation();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return transportType.getName() +
                " from " +
                origin.getName() +
                " to " +
                destination.getName() +
                " " +
                reservation.getDepartingOn() +
                " arriving " +
                reservation.getArrivingOn();
    }
}

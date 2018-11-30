package data;

import java.util.HashMap;

public class TripRepository extends Repository<HashMap<String, Trip>> {

    private HashMap<String, Trip> tripHashMap = new HashMap<>();
    @Override
    public HashMap<String, Trip> retrieveData() {
        return tripHashMap;
    }

    public void storeTrip(String id, Trip trip) {
        this.tripHashMap.put(id, trip);
    }

    public Trip retrieveTrip(String id) {
        return tripHashMap.getOrDefault(id, null);
    }

    public boolean isTripInRepo(String id) {
        return tripHashMap.containsKey(id);
    }

    public void printTrips() {
        for (Trip trip: tripHashMap.values()) {
            System.out.println(trip.getId());
        }
    }
}

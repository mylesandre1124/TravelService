package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelAgents {

    private static List<TravelAgent> travelAgents;

    public static List<TravelAgent> retrieveAgents() {
        if (travelAgents == null) {
            travelAgents = getTravelAgents();
        }
        return travelAgents;
    }

    private static ArrayList<TravelAgent> getTravelAgents() {
        TravelAgent bill = new TravelAgent("Bill Bryson", 3908279873L);
        TravelAgent myles = new TravelAgent("Myles Andre", 7639973021L);
        TravelAgent jeff = new TravelAgent("Jeff Adkisson", 7359027643L);

        return new ArrayList<>(Arrays.asList(bill, myles, jeff));
    }

}

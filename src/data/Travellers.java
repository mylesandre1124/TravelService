package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Travellers {

    private static List<Traveller> travellers;

    public static List<Traveller> retrieveTravellers() {
        if (travellers == null) {
            travellers = getTravellers();
        }
        return travellers;
    }

    private static ArrayList<Traveller> getTravellers() {
        Traveller bill = new Traveller("Bill Bryson", 3908279873L);
        Traveller myles = new Traveller("Myles Andre", 7639973021L);
        Traveller jeff = new Traveller("Jeff Adkisson", 7359027643L);

        return new ArrayList<>(Arrays.asList(bill, myles, jeff));
    }


}

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
        Traveller poePickles = new Traveller("Poe Pickles", 3908732839L);
        Traveller guest1 = new Traveller("Guest #1", 7639390873L);
        Traveller guest2 = new Traveller("Guest #2", 7353939083L);
        Traveller guest3 = new Traveller("Guest #3", 7723932917L);
        Traveller guest4 = new Traveller("Guest #4", 7013017924L);

        return new ArrayList<>(Arrays.asList(poePickles, guest1, guest2, guest3, guest4));
    }


}

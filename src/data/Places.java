package data;

import java.util.*;

public class Places extends Repository<HashMap<Places.PlaceEnum,Place>> {

    private static HashMap<PlaceEnum, Place> places;

    public static HashMap<PlaceEnum, Place> retrievePlaces() {
        if (places == null) {
            places = getPlaces();
        }
        return places;
    }

    private static HashMap<PlaceEnum, Place> getPlaces() {
        Place fijiAirport = new Place("Fiji Airport");
        Place casaPickles = new Place("Casa Pickles");
        Place fijiMarina = new Place("Fiji Marina");
        Place picklesPrivateIsland = new Place("Paradise Pickles Private Island");
        Place sanDiegoAirport = new Place("San Diego Airport");
        Place palacePickles = new Place("Palace Pickles");

        HashMap<PlaceEnum, Place> places = new HashMap<>();
        places.put(PlaceEnum.FijiAirport, fijiAirport);
        places.put(PlaceEnum.CasaPickles, casaPickles);
        places.put(PlaceEnum.FijiMarina, fijiMarina);
        places.put(PlaceEnum.ParadisePrivateIsland, picklesPrivateIsland);
        places.put(PlaceEnum.SanDiegoAirport, sanDiegoAirport);
        places.put(PlaceEnum.PalacePickeles, palacePickles);

        return places;
    }

    enum PlaceEnum {
        FijiAirport,
        CasaPickles,
        FijiMarina,
        ParadisePrivateIsland,
        SanDiegoAirport,
        PalacePickeles
    }


    @Override
    public HashMap<PlaceEnum, Place> retrieveData() {
        return retrievePlaces();
    }
}

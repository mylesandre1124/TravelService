package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Packages extends Repository<List<Package>> {

    private static List<Package> packages;

    public static List<Package> retrievePackages() {
        if (packages == null) {
            packages = getPackages();
        }
        return packages;
    }

    private static List<Package> getPackages() {
        HashMap<Places.PlaceEnum, Place> places = Places.retrievePlaces();
        Package fijiAirportPackage = new Package(places.get(Places.PlaceEnum.CasaPickles), places.get(Places.PlaceEnum.FijiAirport), TransportType.PRIVATE_JET);
        Package sanDiegoPackage = new Package(places.get(Places.PlaceEnum.CasaPickles), places.get(Places.PlaceEnum.SanDiegoAirport), TransportType.PRIVATE_JET);

        return new ArrayList<>(Arrays.asList(fijiAirportPackage, sanDiegoPackage));
    }

    @Override
    public List<Package> retrieveData() {
        return retrievePackages();
    }
}

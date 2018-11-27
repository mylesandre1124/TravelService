package data;

public class Reservation {

    private String departingOn;
    private String arrivingOn;

    public Reservation() {
        departingOn = "" + ((int) (Math.random() * 12) + 1) + "/" + ((int) (Math.random() * 31) + 1) + " at " + ((int) (Math.random() * 12) + 1) + " pm";
        arrivingOn = "" + ((int) (Math.random() * 12) + 1) + "/" + ((int) (Math.random() * 31) + 1) + " at " + ((int) (Math.random() * 12) + 1) + " pm";
    }

    public String getDepartingOn() {
        return departingOn;
    }

    public String getArrivingOn() {
        return arrivingOn;
    }
}

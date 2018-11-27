package data;

public enum TransportType {

    HELICOPTER("Helicopter"),
    PRIVATE_JET("Private Jet"),
    LIMOSINE("Limosine"),
    YACHT("Yacht");


    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

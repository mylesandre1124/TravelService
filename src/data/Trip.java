package data;

import state.TripState;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    private long id;
    private List<Traveller> travellers = new ArrayList<>();
    private List<Package> packages = new ArrayList<>();
    private Bill bill = new Bill();
    private Payment payment;
    private TripState.Status status;
    private String thankYouNote;
    private Person reserver;

    public Trip() {
        //this.id =
    }

    public void addTraveller(Traveller traveller) {
        if (!travellers.contains(traveller)) {
            travellers.add(traveller);
        }
    }

    public void addPackage(Package packageItem) {
        bill.addPriceToBill(packageItem.getPrice());
        packages.add(packageItem);
    }

    public TripState.Status getStatus() {
        return status;
    }

    public void setStatus(TripState.Status status) {
        this.status = status;
    }

    public boolean isNumberOfPackagesValid() {
        return (packages != null && packages.size() > 0);
    }

    public boolean isNumberOfTravellersValid() {
        return (travellers != null && travellers.size() > 0);
    }

    public Payment getPayment() {
        return bill.getPayment();
    }

    public void setPayment(Payment payment) {
        this.bill.setPayment(payment);
    }

    public double getTotal() {
        return bill.getTotalPrice();
    }

    public String getThankYouNote() {
        return thankYouNote;
    }

    public void setThankYouNote(String thankYouNote) {
        this.thankYouNote = thankYouNote;
    }

    public Person getReserver() {
        return reserver;
    }

    public void setReserver(Person reserver) {
        this.reserver = reserver;
    }

    public Person getMainTraveller() {
        return travellers.get(0);
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}

package data;


public class Bill {

    private double totalPrice = 0;
    private boolean isPaidInFull = false;
    private Payment payment;

    public double getTotalPrice() {
        return totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if (payment.getAmountPaid() == totalPrice) {
            isPaidInFull = true;
        }
        this.payment = payment;
    }

    public void addPriceToBill(double price) {
        totalPrice += Double.parseDouble(String.format("%.2f", price));
    }
}

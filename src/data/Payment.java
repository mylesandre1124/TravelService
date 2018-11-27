package data;

public class Payment {

    private double amountPaid;
    private PaymentType paymentType;

    public Payment(double amount, PaymentType paymentType) {
        this.amountPaid = amount;
        this.paymentType = paymentType;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public enum PaymentType {
        CASH,
        CHECK,
        CREDIT
    }

}

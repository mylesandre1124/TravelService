package data;

public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount, PaymentType.CASH);
    }
}

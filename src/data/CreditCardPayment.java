package data;

public class CreditCardPayment extends Payment {

    private long cardNumber;
    private String expirationDate;

    public CreditCardPayment(double amount, long cardNumber, String expiration) {
        super(amount, PaymentType.CREDIT);
        this.cardNumber = cardNumber;
        this.expirationDate = expiration;
    }

    @Override
    public String toString() {
        return "Credit Card: \nCard Number: " + cardNumber
                + "\nExpiration Date: " + expirationDate +
                "\nAmount: " + getAmountPaid() + "\n";
    }
}

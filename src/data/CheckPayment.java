package data;

public class CheckPayment extends Payment {
    public CheckPayment(double amount) {
        super(amount, PaymentType.CHECK);
    }

    public CheckPayment(double amount, long checkNumber) {
        super(amount, PaymentType.CHECK);
        this.checkNumber = checkNumber;
    }

    private long checkNumber;

    public long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(long checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Check #: " + getCheckNumber();
    }
}

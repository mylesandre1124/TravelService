package state;

import data.CashPayment;
import data.Payment;

import java.util.Scanner;

public class AcceptPaymentCashState extends TripState {
    protected AcceptPaymentCashState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        double amountDue = getTripContext().getTrip().getTotal();
        double amountEntered = -1;

        while (amountDue != amountEntered) {
            System.out.print("Amount Due: ");
            System.out.println(amountDue);
            System.out.println();

            System.out.println("Enter the amount due: ");

            amountEntered = scanner.nextDouble();

            if (amountDue == amountEntered) {
                Payment payment = new CashPayment(amountEntered);
                getTripContext().getTrip().setPayment(payment); //Sets Payment Method
                getTripContext().changeState(new AddThankYouState(getTripContext())); //Moves to next state
                break;
            }

            System.out.println("Invalid payment amount entered");
        }
        return TripStateLoop.Status.Continue;
    }
}

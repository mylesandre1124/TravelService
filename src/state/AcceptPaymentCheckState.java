package state;

import data.CheckPayment;
import data.Payment;

import java.util.Scanner;

public class AcceptPaymentCheckState  extends TripState {
    protected AcceptPaymentCheckState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        double amountDue = getTripContext().getTrip().getTotal(); //Gets cart total
        double amountEntered = -1;

        //Takes input from user
        while (amountDue != amountEntered) {
            System.out.print("Enter a check number: ");
            long checkNumber = scanner.nextLong();

            System.out.print("Amount Due: ");
            System.out.println(amountDue);
            System.out.println();

            System.out.println("Enter the amount due: ");

            amountEntered = scanner.nextDouble();

            if (amountDue == amountEntered) {
                Payment payment = new CheckPayment(amountEntered, checkNumber);
                getTripContext().getTrip().setPayment(payment); //Sets payment method
                getTripContext().changeState(new AddThankYouState(getTripContext())); //Moves to next state
                break;
            }

            System.out.println("Invalid payment amount entered");
        }
        return TripStateLoop.Status.Continue;
    }
}


package state;

import data.CreditCardPayment;
import data.Payment;

import java.util.Scanner;

public class AcceptPaymentCreditCardState extends TripState {
    protected AcceptPaymentCreditCardState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        double amountDue = getTripContext().getTrip().getTotal(); //Gets cart total
        double amountEntered = -1;

        //Takes input from user
        while (amountDue != amountEntered) {
            System.out.print("Enter a credit card number: ");
            long creditCardNumber = scanner.nextLong();

            System.out.print("Enter a expiration date: ");
            String expirationDate = scanner.nextLine();

            System.out.print("Amount Due: ");
            System.out.println(amountDue
            );
            System.out.println();

            System.out.println("Enter the amount due: ");

            amountEntered = scanner.nextDouble();

            if (amountDue == amountEntered) {
                Payment payment = new CreditCardPayment(amountEntered, creditCardNumber, expirationDate);
                getTripContext().getTrip().setPayment(payment); //Sets payment method
                getTripContext().changeState(new AddThankYouState(getTripContext())); //Moves to next state
                break;
            }

            System.out.println("Invalid payment amount entered");
        }
        return TripStateLoop.Status.Continue;
    }

}

package state;

import java.util.Scanner;

public class ChoosePaymentState extends TripState {

    private static final String CASH = "cash";
    private static final String CHECK = "check";
    private static final String CREDIT_CARD = "credit";

    protected ChoosePaymentState(TripContext tripContext) {
        super(tripContext, Status.ChoosePayment);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("*** CHOOSE PAYMENT TYPE ***");
        System.out.println();

        boolean choosePayment = true;

        TripState state = null;

        while (choosePayment) {
            System.out.println(
                    "- COMMAND: [later] to return later or [continue] to choose payment");

            switch (getCommand(scanner.nextLine().trim())) {
                case LATER:
                    return TripStateLoop.Status.Stop;
                case CONTINUE:
                    break;
                default:
                    //If input is not later or continue. It breaks and loops back
                    System.out.println("Invalid Input Entered. Please Try Again.");
                    return TripStateLoop.Status.Continue;
            }

            System.out.print("Enter the payment type [cash], [check], [credit]: ");
            state = getPaymentState(scanner.nextLine().trim());

            //If the state is found, it will move on
            if (state != null) {
                break;
            }
            System.out.println("Invalid payment type entered. Please try again.");
        }

        getTripContext().changeState(state);

        return TripStateLoop.Status.Continue;
    }

    //Gets payment state based on input
    public TripState getPaymentState(String type) {
        switch (type.toLowerCase()) {
            case CASH:
                return new AcceptPaymentCashState(getTripContext());
            case CHECK:
                return new AcceptPaymentCheckState(getTripContext());
            case CREDIT_CARD:
                return new AcceptPaymentCreditCardState(getTripContext());
            default:
                return null;
        }
    }
}

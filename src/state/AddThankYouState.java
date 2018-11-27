package state;


import java.util.Scanner;

public class AddThankYouState extends TripState {
    protected AddThankYouState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        String thankYouNote = "";

        while (thankYouNote.length() == 0) {
            System.out.print("Enter a thank you note: ");
            thankYouNote = scanner.nextLine();

            if (thankYouNote.length() == 0) {
                System.out.println("Invalid input entered. Try again");
            }
        }

        getTripContext().getTrip().setThankYouNote(thankYouNote);
        getTripContext().changeState(new ShowItineraryState(getTripContext()));

        return TripStateLoop.Status.Continue;

    }
}

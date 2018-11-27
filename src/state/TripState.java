package state;

import state.TripContext;
import state.TripStateLoop;

public abstract class TripState {

    private TripContext tripContext;

    protected TripState(TripContext tripContext) {
        this.tripContext = tripContext;
    }

    public TripContext getTripContext() {
        return tripContext;
    }

    public abstract TripStateLoop.Status execute();

    public enum Status {
        CreateTrip,
        AddTravellers,
        AddPackages,
        AcceptPaymentCash,
        AcceptPaymentCheck,
        AcceptPaymentCreditCard,
        AddThankYou,
        ShowItinerary,
        Complete
    }

    public Command getCommand(String command) {
        switch (command.toLowerCase()) {
            case "later":
                return Command.LATER;
            case "done":
                return Command.DONE;
            case "continue":
                return Command.CONTINUE;
            default:
                return Command.NOT_FOUND;
        }
    }

    public enum Command {
        LATER,
        DONE,
        CONTINUE,
        NOT_FOUND
    }
}

package state;

public class CompleteState extends TripState {
    protected CompleteState(TripContext tripContext) {
        super(tripContext, Status.Complete);
    }

    @Override
    public TripStateLoop.Status execute() {
        return null;
    }
}

package state;

public class CompleteState extends TripState {
    protected CompleteState(TripContext tripContext) {
        super(tripContext);
    }

    @Override
    public TripStateLoop.Status execute() {
        return null;
    }
}

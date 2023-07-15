import org.jetbrains.annotations.NotNull;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id) {
        super(id);
    }
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger);
    }
    public boolean removePassenger(@NotNull Passenger passenger) {
        if (!passenger.isVip()) {
            return passengers.remove(passenger);
        }
        return false;
    }
}

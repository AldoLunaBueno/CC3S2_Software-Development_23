import org.jetbrains.annotations.NotNull;

public class BusinessFlight extends Flight {
    public BusinessFlight(String id) {
        super(id);
    }
    public boolean addPassenger(@NotNull Passenger passenger) {
        if (passenger.isVip())
            return passengers.add(passenger);
        return false;
    }
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EconomyFlight extends Flight {

    private String id;
    private List<Passenger> passengers = new ArrayList<Passenger>();

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

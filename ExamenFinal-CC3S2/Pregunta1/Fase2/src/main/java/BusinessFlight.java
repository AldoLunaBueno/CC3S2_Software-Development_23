import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessFlight extends Flight {
    private List<Passenger> passengers = new ArrayList<Passenger>();

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
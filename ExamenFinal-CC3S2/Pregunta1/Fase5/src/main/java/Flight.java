import java.util.*;

public abstract class Flight {
    private String id;
    Set<Passenger> passengers = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() { 
        return id; 
    }
    public List<Passenger> getPassengersList() { 
        return new ArrayList<Passenger>(passengers);
    }
    abstract public boolean addPassenger(Passenger passenger);
    abstract public boolean removePassenger(Passenger passenger);}

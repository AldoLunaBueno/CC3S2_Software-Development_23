import java.util.ArrayList;
import java.util.Collections; 
import java.util.List; 

public abstract class Flight {
    private String id;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() { 
        return id; 
    }
    public List<Passenger> getPassengersList() { 
        return Collections.unmodifiableList(passengers); 
    }
    abstract public boolean addPassenger(Passenger passenger);
    abstract public boolean removePassenger(Passenger passenger);}

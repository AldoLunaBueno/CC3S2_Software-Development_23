import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    @Test
    @DisplayName("Dado un vuelo económico, " +
            "cuando tenemos un pasajero regular, " +
            "podemos agregarlo y eliminarlo de un vuelo económico")
    public void testEconomyFlightRegularPassenger() {
        Flight economyFlight = new Flight("1", "Economico");
        Passenger mari = new Passenger("Mari", false);
        assertAll(
                () -> assertEquals(true, economyFlight.addPassenger(mari)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals(true, economyFlight.removePassenger(mari)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }
    @Test
    @DisplayName("Dado un vuelo económico, " +
            "cuando tenemos un pasajero VIP, " +
            "podemos agregarlo, pero no eliminarlo de un vuelo económico")
    public void testEconomyFlightVipPassenger() {
        Flight economyFlight = new Flight("1", "Economico");
        Passenger crespo = new Passenger("Crespo", true);
        assertAll(
                () -> assertEquals(true, economyFlight.addPassenger(crespo)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals(false, economyFlight.removePassenger(crespo)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }
    @Test
    @DisplayName("Dado un vuelo de negocios, " +
            "cuando tenemos un pasajero regular, " +
            "no podemos agregarlo ni eliminarlo de un vuelo de negocios")
    public void testBusinessFlightRegularPassenger() {
        Flight businessFlight = new Flight("2", "Negocios");
        Passenger mari = new Passenger("Mari", false);
        assertAll(
                () -> assertEquals(false, businessFlight.addPassenger(mari)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(mari)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
    }
    @Test
    @DisplayName("Dado un vuelo de negocios, " +
            "cuando tenemos un pasajero VIP, " +
            "podemos agregarlo, pero no eliminarlo de un vuelo económico")
    public void testBusinessFlightVipPassenger() {
        Flight businessFlight = new Flight("2", "Negocios");
        Passenger crespo = new Passenger("Crespo", true);
        assertAll(
                () -> assertEquals(true, businessFlight.addPassenger(crespo)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(crespo)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }
}

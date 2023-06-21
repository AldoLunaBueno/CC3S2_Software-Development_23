package Pregunta_2;

import javax.management.RuntimeOperationsException;
import java.util.ArrayList;

public class HoursReserve {
    private static ArrayList<Integer> hoursReserved = new ArrayList<>();

    public ArrayList<Integer> getListHours() {
        return hoursReserved;
    }

    /**
     * Añade una hora a la lista de horas reservadas hoursReserved.
     * @params
     * hour - Es un valor entero que representa una hora en el sistema militar.
     *      0 <= hour <= 23
     */
    public void addHourReserved(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("No se puede ingresar un valor negativo o mayor a 23.");
        }
        if (hoursReserved.contains(hour)) {
            throw new RuntimeException("No se puede reservar una misma hora dos veces.");
        }
        hoursReserved.add(hour);
    }
}

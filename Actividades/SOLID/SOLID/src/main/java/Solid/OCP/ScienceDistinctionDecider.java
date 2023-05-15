package Solid.OCP;

import java.util.Arrays;
import java.util.List;

public class ScienceDistinctionDecider implements DistinctionDecider {
    List<String> science = Arrays.asList("Ciencia de la Computación", "Física");
    @Override
    public void evaluateDistinction(Estudiante estudiante) {
        if (!science.contains(estudiante.department))
            return;
        if (estudiante.score <= 80)
            return;

        System.out.println(estudiante.regNumber + " ha recibido una distinción en ciencias.");
    }
}

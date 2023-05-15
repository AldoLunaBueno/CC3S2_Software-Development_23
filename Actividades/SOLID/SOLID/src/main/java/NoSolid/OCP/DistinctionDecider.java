package NoSolid.OCP;
import java.util.Arrays;
import java.util.List;

public class DistinctionDecider {
    List<String> science = Arrays.asList("Ciencia de la Computación", "Física");
    List<String> arts = Arrays.asList("Historia", "Literatura");
    List<String> trade = Arrays.asList("Fontanería", "Carpintería");
    public void evaluateDistinction(Estudiante estudiante) {

        if (science.contains(estudiante.department)) {
            if (estudiante.score > 80) {
                System.out.println(estudiante.regNumber+" ha recibido una distinción en ciencias.");
            }
        }

        if (arts.contains(estudiante.department)) {
            if (estudiante.score > 70) {
                System.out.println(estudiante.regNumber+" ha recibido una distinción en artes.");
            }
        }

        if (trade.contains(estudiante.department)) {
            if (estudiante.score > 70) {
                System.out.println((estudiante.regNumber + " ha recibido una distinción en comercio."));
            }
        }
    }

}

package Solid.OCP;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtsDistinctionDecider implements DistinctionDecider{
    List<String> arts = Arrays.asList("Historia", "Literatura");
    @Override
    public void evaluateDistinction(Estudiante estudiante) {
        if (!arts.contains(estudiante.department))
            return;
        if (estudiante.score <= 70)
            return;

        System.out.println(estudiante.regNumber + " ha recibido una distinción en artes.");
    }
}

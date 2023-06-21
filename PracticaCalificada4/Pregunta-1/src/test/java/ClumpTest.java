import Pregunta_1.Clump;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClumpTest {
    /**
     * Si el input no tiene ninguna secuencia de dos o más valores iguales,
     * el método countClumps() retorna 0.
     */
    @Test
    public void zeroClump() {
        Clump clump = new Clump();
        int input[] = new int[]{1};
        int expected = 0;
        assertEquals(expected, clump.countClumps(input));

        int input2[] = new int[]{1, 2, 3};
        int expected2 = 0;
        assertEquals(expected2, clump.countClumps(input2));
    }

    /**
     * Si el input solo tiene el mismo valor repetido más de dos veces,
     * entonces el método countClumps() retorna 1.
     */
    @Test
    public void trivialClump() {
        Clump clump = new Clump();
        int input1[] = new int[]{1, 1};
        int expected1 = 1;
        assertEquals(expected1, clump.countClumps(input1));

        int input2[] = new int[]{1, 1, 1, 1, 1};
        int expected2 = 1;
        assertEquals(expected2, clump.countClumps(input2));
    }

    /**
     * Si el input tiene solo una secuencia de valores repetidos más de dos veces
     * y está entre otros valores que no forman ninguna secuencia de valores iguales,
     * el método retorna 1.
     */
    @Test
    public void oneClumpBetweenOtherValues() {
        Clump clump = new Clump();
        int input[] = new int[]{2, 1, 1, 2, 3, 2};
        int expected = 1;
        assertEquals(expected, clump.countClumps(input));
    }

    /**
     * Si el input contiene más de una secuencia de más de dos valores iguales,
     * el método countClumps() retorna la cantidad exacta de secuencias.
     */
    @Test
    public void moreClumps() {
        Clump clump = new Clump();
        int input1[] = new int[]{1, 2, 2, 3, 4, 4};
        int expected1 = 2;
        assertEquals(expected1, clump.countClumps(input1));

        int input2[] = new int[]{1, 1, 2, 1, 1};
        int expected2 = 2;
        assertEquals(expected2, clump.countClumps(input2));
    }

}
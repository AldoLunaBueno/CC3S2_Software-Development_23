import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest
{
    private static Calculadora calculadora;

    @BeforeAll
    public static void init() {
        calculadora = new Calculadora();
    }
    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        assertTrue(calculadora.getStatus());
    }
    @Test
    public void whenAdditionTwoNumberThenReturnCorrectAnswer() {
        assertEquals( 5, calculadora.addition(2,3));
    }
    @Test
    public void whenSubtractTwoNumbersThenReturnCorrectAnswer() {
        assertEquals(-1, calculadora.subtract(2, 3));
    }
    @Test
    public void whenDivisionThenReturnCorrectAnswer() {
        assertEquals(2, calculadora.division(8, 4));
    }
    @Test
    public void whenDivisionByZeroThenThrowException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { calculadora.division(5, 0); });
        assertEquals("No se puede dividir por cero",
                exception.getMessage());
    }
    @Test
    public void whenMultiplicationThenReturnCorrectAnswer() {
        assertEquals(6, calculadora.multiplication(2, 3));
    }
    @Test
    public void whenSquareRootThenReturnCorrectAnswer() {
        assertEquals(2, calculadora.squareRoot(4));
    }
    @Test
    public void whenSquareRootOfNegativeThenThrowException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { calculadora.squareRoot(-4); }
        );
        assertEquals("No se puede calcular la raíz cuadrada"
                        + " de un argumento negativo", exception.getMessage());

    }
}



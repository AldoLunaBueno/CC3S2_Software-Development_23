import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPiecePlacement {
    private TicTacToe ticTacToe;

    @BeforeEach
    @DisplayName("Dado un tablero vacío")
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }
    @ParameterizedTest
    @DisplayName("Cuando el jugador coloca una pieza en una posición inválida del eje X," +
            "se lanza una excepción.")
    @MethodSource
    public void whenPutPieceInInvalidXAxisThrowsException(int x, int y){
        Throwable exception = assertThrows(RuntimeException.class,
                () -> { ticTacToe.jugar(x,y); }
        );
        assertEquals("Eje X inválido", exception.getMessage());
    }
    static Stream<Arguments> whenPutPieceInInvalidXAxisThrowsException() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(0, 2)
        );
    }

    @ParameterizedTest
    @DisplayName("Cuando el jugador coloca una pieza en una posición inválida del eje Y," +
            "se lanza una excepción.")
    @MethodSource
    public void whenPutPieceInInvalidYAxisThrowsException(int x, int y){
        Throwable exception = assertThrows(RuntimeException.class,
                () -> { ticTacToe.jugar(x,y); }
        );
        assertEquals("Eje Y inválido", exception.getMessage());
    }
    static Stream<Arguments> whenPutPieceInInvalidYAxisThrowsException() {
        return Stream.of(
                Arguments.of(2, 5),
                Arguments.of(2, 0)
        );
    }
    @Test
    @DisplayName("Cuando el jugador coloca una pieza en una posición ocupada," +
            "se lanza una excepción.")
    public void WhenPutPieceInOccupiedPositionThrowsException(){
        ticTacToe.jugar(1, 1);
        Throwable exception = assertThrows(RuntimeException.class,
                () -> { ticTacToe.jugar(1,1); }
        );
        assertEquals("Posición ocupada", exception.getMessage());
    }
}

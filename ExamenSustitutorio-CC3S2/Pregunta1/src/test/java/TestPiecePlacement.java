import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPiecePlacement {
    private TicTacToe ticTacToe;

    @BeforeEach
    @DisplayName("Dado un tablero vacío")
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }
    @Test
    @DisplayName("Cuando el jugador coloca una pieza en una posición inválida del eje X," +
            "se lanza una excepción.")
    public void WhenPutPieceInInvalidXAxisThrowsException(){
        Throwable exception = assertThrows(RuntimeException.class,
                () -> { ticTacToe.jugar(5,2); }
        );
        assertEquals("Eje X inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Cuando el jugador coloca una pieza en una posición inválida del eje Y," +
            "se lanza una excepción.")
    public void WhenPutPieceInInvalidYAxisThrowsException(){
        Throwable exception = assertThrows(RuntimeException.class,
                () -> { ticTacToe.jugar(2,5); }
        );
        assertEquals("Eje Y inválido", exception.getMessage());
    }
}

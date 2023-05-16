import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private TicTacToeBoard board;

    @BeforeEach
    public void beforeEach() throws Exception {
        board = new TicTacToeBoard();
    }
    @Test
    public void whenPutPieceFailsXAxisThrowsRuntimeException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            board.putPiece(4,2);
            board.putPiece(0, 2);
        });
        String expected = "Invalid x axis value";
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void whenPutPieceFailsYAxisThrowsRuntimeException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            board.putPiece(1,4);
            board.putPiece(1,0);
        });
        String expected = "Invalid y axis value";
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void whenPutPieceInOccupiedCellThrowsRuntimeException() {
        board.putPiece(1,1); // Given a piece put on board
        Exception exception = assertThrows(RuntimeException.class,
                () -> board.putPiece(1,1));
        String expected = "Cell occupied";
        assertEquals(expected, exception.getMessage());
    }
    @Test
    public void firstTurnPutX() {
        board.putPiece(1,1); // Expected piece put: X
        assertEquals(board.getPieceFromGrid(1, 1), "X");
    }
    @Test
    public void givenLastTurnXThenPutO() {
        board.putPiece(1, 1); // Expected put piece: X
        board.putPiece(2, 2); // Expected put piece: O
        assertEquals(board.getPieceFromGrid(2, 2), "O");
        board.putPiece(3, 3); // Expected put piece: X
        board.putPiece(1, 2); // Expected put piece: O
        assertEquals(board.getPieceFromGrid(1, 2), "O");
    }
}

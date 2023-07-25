public class TicTacToe {
    private String[][] grid;
    public TicTacToe() {
        initBoard();
    }
    public void jugar(int x, int y) {
        checkBounds(x, y);
        checkOccupied(x, y);
        setPiece(x, y, "X");
    }
    private void setPiece(int x, int y, String piece) {
        grid[x-1][y-1] = piece;
    }
    private String getPiece(int x, int y) {
        return grid[x - 1][y - 1];
    }
    private void initBoard() {
        grid = new String[3][3];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                setPiece(i, j, "");
            }
        }
    }
    private static void checkBounds(int x, int y) {
        checkXAxis(x);
        checkYAxis(y);
    }
    private void checkOccupied(int x, int y) {
        if (!getPiece(x, y).isEmpty()) {
            throw new RuntimeException("Posición ocupada");
        }
    }
    private static void checkYAxis(int y) {
        if (y < 1 || y > 3) {
            throw new RuntimeException("Eje Y inválido");
        }
    }
    private static void checkXAxis(int x) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("Eje X inválido");
        }
    }
}

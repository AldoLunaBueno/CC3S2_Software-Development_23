public class TicTacToeBoard {
    String grid[][] = new String[3][3];
    public TicTacToeBoard() {
        initBoard();
    }
    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = "";
            }
        }
    }
    public void putPiece(int x, int y) throws RuntimeException {
        checkBounds(x, y);
        checkOccupied(x, y);
        setPieceAtGrid(x, y, "X");
    }
    private void checkOccupied(int x, int y) throws RuntimeException{
        if (!getPieceFromGrid(x, y).equals("")) {
           throw new RuntimeException("Cell occupied");
        }
    }
    private String getPieceFromGrid(int x, int y) {
        return grid[x-1][y-1];
    }
    private void setPieceAtGrid(int x, int y, String piece) {
        grid[x-1][y-1] = piece;
    }
    private void checkBounds(int x, int y) throws RuntimeException {
        if (x < 1 || x > 3) {
            throw new RuntimeException("Invalid x axis value");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Invalid y axis value");
        }
    }
}

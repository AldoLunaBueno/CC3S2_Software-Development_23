public class TicTacToeBoard {
    String grid[][] = new String[3][3];
    public TicTacToeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = "";
            }
        }
    }
    public void putPiece(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("Invalid x axis value");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Invalid y axis value");
        }
        if (!grid[x-1][y-1].equals(""))
           throw new RuntimeException("Cell occupied");
        grid[x-1][y-1] = "X";
    }
}

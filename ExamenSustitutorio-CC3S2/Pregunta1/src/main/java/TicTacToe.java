public class TicTacToe {

    private int[][] grid;
    public TicTacToe() {
        grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void jugar(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("Eje X inválido");
        }

        grid[x][y] = 1;
    }
}

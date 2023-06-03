abstract class Board {
    protected int n; // "n" represent size
    protected char[][] grid;

    protected void initialize() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public Board(int n) {
        this.n = n;
        this.grid = new char[n][n];
        initialize();
    }

    public abstract boolean is_validMove(int row, int column);

    public abstract boolean is_gameOver();

    public abstract boolean is_winner();

    public abstract boolean is_draw();

    public abstract void make_move(Player player, int row, int column);

    public char get_grid_value(int x, int y) {
        return grid[x][y];
    }

    public void display_board() {

        System.out.print("    0    1   2");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(i);
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '\0') {
                    System.out.print(" ");
                    System.out.print(" | ");
                } else {
                    System.out.print("  |");
                    System.out.print(grid[i][j]);
                }
            }
            System.out.print("  |\n");
            System.out.print("   -------------\n");
        }
    }
}

import java.util.Scanner;

class XOBoard extends Board {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public XOBoard(int n, Player player1, Player player2) {
        super(n);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    @Override
    public boolean is_validMove(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == '-');
    }

    @Override
    public boolean is_gameOver() {
        return is_winner() || is_draw();
    }

    @Override
    public boolean is_winner() {
        return check_Rows() || check_Columns() || check_Diagonals();
    }

    @Override
    public boolean is_draw() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void make_move(Player player, int x, int y) {
        if (is_validMove(x, y)) {
            grid[x][y] = player.get_symbol();
        }

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private boolean check_Rows() {
        for (int i = 0; i < n; i++) {
            if (grid[i][0] != '-' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean check_Columns() {
        for (int i = 0; i < n; i++) {
            if (grid[0][i] != '-' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean check_Diagonals() {

        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }
        if (grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return true;
        }
        return false;
    }

    public void play_game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game started!");
        display_board();

        while (!is_gameOver()) {
            System.out.print(currentPlayer.get_name() + ", Enter your move (0-2):  ");
            int row, col;

            row = scanner.nextInt();
            col = scanner.nextInt();

            if (!is_validMove(row, col)) {
                System.out.println("invalid move, please try again");
                continue;
            }

            make_move(getCurrentPlayer(), row, col);
            display_board();

            if (is_winner()) {
                System.out.println(currentPlayer.get_name() + " wins!");
                break;
            } else if (is_draw()) {
                System.out.println("It's a draw!");
                break;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
        scanner.close();
    }

}

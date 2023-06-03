
class Game {
    public static void main(String[] args) {

        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        XOBoard game = new XOBoard(3, player1, player2);
        game.play_game();

    }
}
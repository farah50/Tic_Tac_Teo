import java.util.Scanner;

class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String get_name() {
        return name;
    }

    public char get_symbol() {
        return symbol;
    }

    public int[] get_move() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(name + ", enter your next move: ");
            int x = scanner.nextInt(); // "x" represent row
            int y = scanner.nextInt(); // "y" represent column
            return new int[] { x, y };
        }
    }
}

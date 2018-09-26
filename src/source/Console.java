import java.util.Arrays;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter player 1's name:");
        String player1Name = scan.nextLine();
        System.out.println(player1Name + " is X");

        System.out.println("Enter player 2's name:");
        String player2Name = scan.nextLine();
        System.out.println(player2Name + " is O");

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        TicTacToe game = new TicTacToe(player1, player2);

        boolean continuePlaying = true;

        while (!game.isFinished() && continuePlaying) {
            Player currentPlayer = game.currentPlayer();
            System.out.println("It's " + currentPlayer.name + "'s turn:");
            String coordinatesInput = scan.nextLine();
            String[] splitCoordinates = coordinatesInput.split(",");
            int x = Integer.parseInt(splitCoordinates[0]);
            int y = Integer.parseInt(splitCoordinates[1]);
            Coordinate coordinate = new Coordinate(x, y);
            PlayerMoveResponse response = game.nextPlayerMoveAt(coordinate);
            System.out.println(response.message);
            drawGridFrom(game.movesHistory(), player1Name, player2Name);

            if(game.isFinished()) {
                Result result = game.result();
                System.out.println(result.message());
                System.out.println("Continue playing? (y/n):");
                String decision = scan.nextLine();
                if(decision.equals("y")) {
                    game = new TicTacToe(player1, player2);
                }
                else {
                    continuePlaying = false;
                }
            }
        }
    }

    private static void drawGridFrom(MoveHistory moveHistory, String player1, String player2) {
        String[][] grid = new String[3][3];
        for(String[] row : grid) {
            Arrays.fill(row, " ");
        }
        for (Move move : moveHistory.moves()) {
            if (move.player.name.equals(player1)) {
                grid[move.coordinate.x][move.coordinate.y] = "X";
            } else if (move.player.name.equals(player2)) {
                grid[move.coordinate.x][move.coordinate.y] = "O";
            }
        }

        for (int y = 0; y < 3; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < 3; x++) {
                row.append(grid[x][y]);
                if(x < 2) {
                    row.append(" | ");
                }
            }
            System.out.println(row);
        }
    }
}

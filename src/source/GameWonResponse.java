public class GameWonResponse {
    public boolean gameIsFinished;
    public boolean wasADraw;
    public String message;

    private GameWonResponse(boolean gameIsFinished, String message) {
        this.gameIsFinished = gameIsFinished;
        this.message = message;
    }

    public static GameWonResponse playerHasWon(Player winner) {
        return new GameWonResponse(true, winner.name + " wins");
    }

    public static GameWonResponse noWinner() {
        return new GameWonResponse(false, "Nobody has won yet.");
    }

    public static GameWonResponse draw() {
        return new GameWonResponse(true, "It's a draw.");
    }
}

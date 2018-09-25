public class GameWonResponse {
    public boolean hasBeenWon;
    public String message;

    private GameWonResponse(boolean success, String message) {
        this.hasBeenWon = success;
        this.message = message;
    }

    public static GameWonResponse playerHasWon(Player winner) {
        return new GameWonResponse(true, winner.name + " wins");
    }

    public static GameWonResponse noWinner() {
        return new GameWonResponse(false, "Nobody has won yet.");
    }
}

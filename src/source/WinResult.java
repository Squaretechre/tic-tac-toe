public class WinResult implements Result {
    private final Player winner;

    public WinResult(Player winner) {
        this.winner = winner;
    }

    @Override
    public String message() {
        return winner.name + " wins!";
    }
}

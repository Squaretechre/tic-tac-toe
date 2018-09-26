public class DrawResult implements Result {
    private final Player player1;
    private final Player player2;

    public DrawResult(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String message() {
        return "It's a draw for " + player1.name + " and " + player2.name + ".";
    }
}

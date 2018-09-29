public class StateDraw implements GameState {
    private final Player player1;
    private final Player player2;
    private final Player lastPlayerToMove;
    private final MoveHistory moveHistory;

    public StateDraw(Player player1, Player player2, Player lastPlayerToMove, MoveHistory moveHistory) {
        this.player1 = player1;
        this.player2 = player2;
        this.lastPlayerToMove = lastPlayerToMove;
        this.moveHistory = moveHistory;
    }

    @Override
    public Player currentPlayer() {
        return lastPlayerToMove;
    }

    @Override
    public PlayerMoveResponse nextPlayerMoveAt(Coordinate coordinate) {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isInProgress() {
        return false;
    }

    @Override
    public MoveHistory moves() {
        return moveHistory;
    }

    @Override
    public Result result() {
        return new DrawResult(player1, player2);
    }
}

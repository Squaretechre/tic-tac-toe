public class StateWin implements GameState {
    private final Player winner;
    private final MoveHistory moveHistory;

    public StateWin(Player winner, MoveHistory moveHistory) {
        this.winner = winner;
        this.moveHistory = moveHistory;
    }

    @Override
    public Player currentPlayer() {
        return winner;
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
        return new WinResult(winner);
    }
}

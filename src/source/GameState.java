public interface GameState {
    Player currentPlayer();

    PlayerMoveResponse nextPlayerMoveAt(Coordinate coordinate);

    boolean isFinished();

    boolean isInProgress();

    MoveHistory moves();

    Result result();
}

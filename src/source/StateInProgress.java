public class StateInProgress implements GameState {
    private final Player player1;
    private final Player player2;
    private final Grid grid;
    private final MoveHistory moveHistory;
    private final TicTacToe game;
    private Player currentPlayer;

    public StateInProgress(TicTacToe game, Player player1, Player player2, Grid grid, MoveHistory moveHistory) {
        this.game = game;
        this.grid = grid;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.moveHistory = moveHistory;
    }

    @Override
    public Player currentPlayer() {
        return currentPlayer;
    }

    @Override
    public PlayerMoveResponse nextPlayerMoveAt(Coordinate coordinate) {
        PlayerMoveResponse response = attemptMoveTo(coordinate);
        if (failed(response)) return response;

        updateGridWith(coordinate);
        updateMoveHistoryWith(coordinate);
        setNextPlayer();
        updateGameState();

        return response;
    }

    private void updateGameState() {
        if (grid.hasWinningPlayer()) {
            game.setState(new StateWin(grid.winningPlayer(), moveHistory));
        }
        if (grid.hasNoSpacesLeft()) {
            game.setState(new StateDraw(player1, player2, currentPlayer, moveHistory));
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isInProgress() {
        return true;
    }

    @Override
    public MoveHistory moves() {
        return moveHistory;
    }

    @Override
    public Result result() {
        return new InProgressResult();
    }

    private void updateMoveHistoryWith(Coordinate coordinate) {
        moveHistory.addMove(currentPlayer, coordinate);
    }

    private void updateGridWith(Coordinate coordinate) {
        grid.addMove(currentPlayer, coordinate);
    }

    private boolean failed(PlayerMoveResponse attemptedMove) {
        return !attemptedMove.success;
    }

    private PlayerMoveResponse attemptMoveTo(Coordinate coordinate) {
        if (grid.willNotAllowMoveAt(coordinate)) {
            return PlayerMoveResponse.unableToMoveToCoordinate(currentPlayer, coordinate);
        }
        return PlayerMoveResponse.successfulMove(currentPlayer, coordinate);
    }

    private void setNextPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}

class TicTacToe {
    private GameState state;

    TicTacToe(Player player1, Player player2) {
        this(player1, player2, new Grid());
    }

    TicTacToe(Player player1, Player player2, Grid grid) {
        MoveHistory moveHistory = new MoveHistory();
        this.state = new StateInProgress(this, player1, player2, grid, moveHistory);
    }

    void setState(GameState nextState) {
        this.state = nextState;
    }

    Player currentPlayer() {
        return state.currentPlayer();
    }

    PlayerMoveResponse nextPlayerMoveAt(Coordinate coordinate) {
        return state.nextPlayerMoveAt(coordinate);
    }

    boolean isFinished() {
        return state.isFinished();
    }

    boolean isInProgress() {
        return state.isInProgress();
    }

    MoveHistory moves() {
        return state.moves();
    }

    Result result() {
        return state.result();
    }
}

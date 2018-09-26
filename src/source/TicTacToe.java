class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Grid grid;
    private MoveHistory moveHistory;
    private boolean isFinished;

    TicTacToe(Player player1, Player player2) {
        this(player1, player2, new Grid());
    }

    TicTacToe(Player player1, Player player2, Grid grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.grid = grid;
        this.currentPlayer = player1;
        this.moveHistory = new MoveHistory();
        updateGameState();
    }

    Player currentPlayer() {
        return currentPlayer;
    }

    PlayerMoveResponse nextPlayerMoveAt(Coordinate coordinate) {
        PlayerMoveResponse response = attemptMoveTo(coordinate);
        if(failed(response)) return response;

        updateGridWith(coordinate);
        updateMoveHistoryWith(coordinate);
        setNextPlayer();
        updateGameState();

        return response;
    }

    private void updateGameState() {
        if(grid.hasWinningPlayer()) {
            isFinished = true;
        }
    }

    boolean isFinished() {
        return this.isFinished;
    }

    GameWonResponse status() {
        if(grid.hasWinningPlayer()) {
            return GameWonResponse.playerHasWon(grid.winningPlayer());
        }
        if(grid.hasNoSpacesLeft()) {
            return GameWonResponse.draw();
        }
        return GameWonResponse.noWinner();
    }

    MoveHistory movesHistory() {
        return moveHistory;
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
        if(grid.willNotAllowMoveAt(coordinate)) {
            return PlayerMoveResponse.unableToMoveToCoordinate(currentPlayer, coordinate);
        }
        return PlayerMoveResponse.successfulMove(currentPlayer, coordinate);
    }

    private void setNextPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}

import java.util.ArrayList;

class GridLine {
    private Player[] lineOfPlayerMoves;

    GridLine(Player[] lineOfPlayerMoves) {
        this.lineOfPlayerMoves = lineOfPlayerMoves;
    }

    boolean hasWinningPlayer() {
        return winningPlayer() != null;
    }

    Player winningPlayer() {
        ArrayList<Player> playersOnLine = new ArrayList<>();
        int occupiedSpaceOnLine = 0;
        for (Player player : lineOfPlayerMoves) {
            boolean noPlayerHasMovedToThisSpaceYet = player == null;
            if (noPlayerHasMovedToThisSpaceYet) continue;
            occupiedSpaceOnLine++;
            if (playersOnLine.contains(player)) continue;
            playersOnLine.add(player);
        }
        boolean lineIsFullyOccupied = occupiedSpaceOnLine == 3;
        boolean onlyOnePlayerIsOnLine = playersOnLine.size() == 1;
        boolean lineHasWinningPlayer = lineIsFullyOccupied && onlyOnePlayerIsOnLine;
        return lineHasWinningPlayer ? playersOnLine.get(0) : null;
    }
}

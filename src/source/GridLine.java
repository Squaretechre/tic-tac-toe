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
        int occupiedSpacesOnLine = 0;
        for (Player player : lineOfPlayerMoves) {
            boolean noPlayerHasMovedToThisSpaceYet = player == null;
            if (noPlayerHasMovedToThisSpaceYet) continue;
            occupiedSpacesOnLine++;
            if (playersOnLine.contains(player)) continue;
            playersOnLine.add(player);
        }
        boolean lineIsFullyOccupied = occupiedSpacesOnLine == 3;
        boolean onlyOnePlayerIsOnLine = playersOnLine.size() == 1;
        boolean lineHasWinningPlayer = lineIsFullyOccupied && onlyOnePlayerIsOnLine;
        return lineHasWinningPlayer ? playersOnLine.get(0) : null;
    }

    boolean hasEmptySpaces() {
        for (Player player : lineOfPlayerMoves) {
           if (player == null) return true;
        }
        return false;
    }
}

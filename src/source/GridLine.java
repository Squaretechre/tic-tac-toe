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
        ArrayList<Player> playersOnThisLine = new ArrayList<>();
        int occupiedSpacesOnLine = 0;
        for (Player player : lineOfPlayerMoves) {
            boolean noPlayerHasMovedToThisSpaceYet = player == null;
            if (noPlayerHasMovedToThisSpaceYet) continue;
            occupiedSpacesOnLine++;
            if (playersOnThisLine.contains(player)) continue;
            playersOnThisLine.add(player);
        }
        boolean lineIsFullyOccupied = occupiedSpacesOnLine == 3;
        boolean onlyOnePlayerIsOnThisLine = playersOnThisLine.size() == 1;
        boolean lineHasWinningPlayer = lineIsFullyOccupied && onlyOnePlayerIsOnThisLine;
        return lineHasWinningPlayer ? playersOnThisLine.get(0) : null;
    }

    boolean hasEmptySpaces() {
        for (Player player : lineOfPlayerMoves) {
           if (player == null) return true;
        }
        return false;
    }
}

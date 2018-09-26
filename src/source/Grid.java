import java.util.ArrayList;

class Grid {
    private ArrayList<GridLine> gridLines;
    private Player[][] grid = new Player[3][3];

    Grid() {
        this(new Player[3][3]);
    }

    Grid(Player[][] gridArray) {
        grid = gridArray;
        gridLines = new ArrayList<>();
        updateGrid();
    }

    private void updateGrid() {
        GridLine topRow = new GridLine(new Player[]{grid[0][0], grid[1][0], grid[2][0]});
        GridLine middleRow = new GridLine(new Player[]{grid[0][1], grid[1][1], grid[2][1]});
        GridLine bottomRow = new GridLine(new Player[]{grid[0][2], grid[1][2], grid[2][2]});
        GridLine leftColumn = new GridLine(new Player[]{grid[0][0], grid[0][1], grid[0][2]});
        GridLine middleColumn = new GridLine(new Player[]{grid[1][0], grid[1][1], grid[1][2]});
        GridLine rightColumn = new GridLine(new Player[]{grid[2][0], grid[2][1], grid[2][2]});
        GridLine diagonalTopLeftToBottomRight = new GridLine(new Player[]{grid[0][0], grid[1][1], grid[2][2]});
        GridLine diagonalTopRightToBottomLeft = new GridLine(new Player[]{grid[2][0], grid[1][1], grid[0][2]});
        gridLines.clear();
        gridLines.add(topRow);
        gridLines.add(middleRow);
        gridLines.add(bottomRow);
        gridLines.add(leftColumn);
        gridLines.add(middleColumn);
        gridLines.add(rightColumn);
        gridLines.add(diagonalTopLeftToBottomRight);
        gridLines.add(diagonalTopRightToBottomLeft);
    }

    void addMove(Player player, Coordinate coordinate) {
        grid[coordinate.y][coordinate.x] = player;
        updateGrid();
    }

    boolean willNotAllowMoveAt(Coordinate coordinate) {
        return grid[coordinate.y][coordinate.x] != null;
    }

    Player winningPlayer() {
        for (GridLine gridLine : gridLines) {
            if (gridLine.hasWinningPlayer()) return gridLine.winningPlayer();
        }
        return null;
    }

    boolean hasWinningPlayer() {
        return winningPlayer() != null;
    }

    boolean hasNoSpacesLeft() {
        for (GridLine gridLine : gridLines) {
            if (gridLine.hasEmptySpaces()) return false;
        }
        return true;
    }
}

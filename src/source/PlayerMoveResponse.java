public class PlayerMoveResponse {
    final boolean success;
    final String message;

    private PlayerMoveResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static PlayerMoveResponse unableToMoveToCoordinate(Player player, Coordinate coordinate) {
        return new PlayerMoveResponse(false,
                player.name + " can't move to " + coordinate.x + ", " + coordinate.y + ". That coordinate is already occupied.");
    }

    public static PlayerMoveResponse successfulMove(Player currentPlayer, Coordinate coordinate) {
        return new PlayerMoveResponse(true, currentPlayer.name + " made a move at " + coordinate.x + ", " + coordinate.y);
    }
}

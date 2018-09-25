import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    private List<Move> moves;

    public MoveHistory() {
        moves = new ArrayList<>();
    }

    public List<Move> moves() {
        return moves;
    }

    public void addMove(Player player, Coordinate coordinate) {
        moves.add(new Move(player, coordinate));
    }

    public int moveCount() {
        return moves.size();
    }
}

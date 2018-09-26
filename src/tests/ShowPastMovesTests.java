import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShowPastMovesTests {
    private TicTacToe game;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
        game = new TicTacToe(player1, player2);
    }

    @Test
    public void no_moves_returned_when_nobody_has_made_a_move() {
        MoveHistory history = game.moves();
        assertEquals(0, history.moveCount());
    }

    @Test
    public void one_move_returned_when_only_player1_has_made_a_move() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        MoveHistory history = game.moves();
        Move firstMove = history.moves().get(0);

        assertEquals(player1, firstMove.player);
        assertEquals(0, firstMove.coordinate.x);
        assertEquals(0, firstMove.coordinate.y);

        assertEquals(1, history.moveCount());
    }

    @Test
    public void two_moves_returned_when_player1_and_player2_have_made_one_move_each() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(1, 1));
        MoveHistory history = game.moves();
        Move firstMove = history.moves().get(0);
        Move secondMove = history.moves().get(1);

        assertEquals(player1, firstMove.player);
        assertEquals(0, firstMove.coordinate.x);
        assertEquals(0, firstMove.coordinate.y);

        assertEquals(player2, secondMove.player);
        assertEquals(1, secondMove.coordinate.x);
        assertEquals(1, secondMove.coordinate.y);

        assertEquals(2, history.moveCount());
    }
}

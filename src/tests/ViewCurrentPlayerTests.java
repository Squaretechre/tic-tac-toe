import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewCurrentPlayerTests {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe(new Player("Dan"), new Player("Other Dan"), new Grid());
    }

    @Test
    public void current_player_is_player1_when_game_starts() {
        assertEquals("Dan", game.currentPlayer().name);
    }

    @Test
    public void current_player_is_player2_when_player1_has_already_moved() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        assertEquals("Other Dan", game.currentPlayer().name);
    }

    @Test
    public void current_player_is_player1_again_when_player1_and_player2_have_both_moved() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(0, 1));
        assertEquals("Dan", game.currentPlayer().name);
    }
}

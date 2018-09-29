import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameIsADrawTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    @Test
    public void game_is_a_draw_when_there_is_nowhere_left_to_move_and_no_winner() {
        Player[][] grid = {
                { player2, player1, player1 },
                { player1, player2, player2 },
                { player1, player2, null },
        };

        TicTacToe game = new TicTacToe(player1, player2, new Grid(grid));

        Coordinate bottomRight = new Coordinate(2, 2);
        game.nextPlayerMoveAt(bottomRight);
        Result result = game.result();
        assertTrue(game.isFinished());
        assertEquals("It's a draw for Dan and Other Dan.", result.message());
    }

    @Test
    public void neither_player_can_move_again_when_game_is_a_draw() {
        Player[][] grid = {
                { player2, player1, player1 },
                { player1, player2, player2 },
                { player1, player2, null },
        };

        TicTacToe game = new TicTacToe(player1, player2, new Grid(grid));

        Coordinate bottomRight = new Coordinate(2, 2);
        game.nextPlayerMoveAt(bottomRight);

        PlayerMoveResponse response = game.nextPlayerMoveAt(bottomRight);

        assertFalse(response.success);
        assertEquals("Unable to move, this game has finished.", response.message);
    }
}

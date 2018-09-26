import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameInProgressTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    @Test
    public void game_result_is_in_progress_when_there_is_neither_a_win_or_draw_situation() {
        Player[][] grid = {
                {player2, player1, null},
                {null, null, null},
                {null, null, null},
        };

        TicTacToe game = new TicTacToe(player1, player2, new Grid(grid));

        Result result = game.result();
        assertFalse(game.isFinished());
        assertEquals("Game is in progress.", result.message());
    }
}

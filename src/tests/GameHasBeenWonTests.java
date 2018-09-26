import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameHasBeenWonTests {
    private static final String player1WinsMessage = "Dan wins";
    private static final String player2WinsMessage = "Other Dan wins";
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    private void assertWinningGridAndMessage(Player[][] gridArray, String winMessage) {
        TicTacToe game = new TicTacToe(player1, player2, new Grid(gridArray));

        GameWonResponse response = game.status();
        assertTrue(response.gameIsFinished);
        assertEquals(winMessage, response.message);
    }

    @Test
    public void player1_wins_when_all_top_row_occupied() {
        Player[][] grid = {
                { player1, player1, player1 },
                { null, null, null },
                { null, null, null },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_middle_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { player1, player1, player1 },
                { null, null, null },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_bottom_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { null, null, null },
                { player1, player1, player1 },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_left_column_occupied() {
        Player[][] grid = {
                { player1, null, null },
                { player1, null, null },
                { player1, null, null },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_middle_column_occupied() {
        Player[][] grid = {
                { null, player1, null },
                { null, player1, null },
                { null, player1, null },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_right_column_occupied() {
        Player[][] grid = {
                { null, null, player1 },
                { null, null, player1 },
                { null, null, player1 },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_top_left_to_bottom_right_diagonal_occupied() {
        Player[][] grid = {
                { player1, null, null },
                { null, player1, null },
                { null, null, player1 },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player1_wins_when_all_top_right_to_bottom_left_diagonal_occupied() {
        Player[][] grid = {
                { null, null, player1 },
                { null, player1, null },
                { player1, null, null },
        };

        assertWinningGridAndMessage(grid, player1WinsMessage);
    }

    @Test
    public void player2_wins_when_all_first_row_occupied() {
        Player[][] gridArray = {
                { player2, player2, player2 },
                { null, null, null },
                { null, null, null },
        };

        assertWinningGridAndMessage(gridArray, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_middle_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { player2, player2, player2 },
                { null, null, null },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_bottom_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { null, null, null },
                { player2, player2, player2 },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_left_column_occupied() {
        Player[][] grid = {
                { player2, null, null },
                { player2, null, null },
                { player2, null, null },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_middle_column_occupied() {
        Player[][] grid = {
                { null, player2, null },
                { null, player2, null },
                { null, player2, null },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_right_column_occupied() {
        Player[][] grid = {
                { null, null, player2 },
                { null, null, player2 },
                { null, null, player2 },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_top_left_to_bottom_right_diagonal_occupied() {
        Player[][] grid = {
                { player2, null, null },
                { null, player2, null },
                { null, null, player2 },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }

    @Test
    public void player2_wins_when_all_top_right_to_bottom_left_diagonal_occupied() {
        Player[][] grid = {
                { null, null, player2 },
                { null, player2, null },
                { player2, null, null },
        };

        assertWinningGridAndMessage(grid, player2WinsMessage);
    }
}

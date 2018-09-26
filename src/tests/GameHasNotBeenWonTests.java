import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class GameHasNotBeenWonTests {
    private Player player2;
    private Player player1;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    private void assertNotWinningGrid(Player[][] gridArray) {
        TicTacToe game = new TicTacToe(player1, player2, new Grid(gridArray));
        assertFalse(game.isFinished());
    }

    @Test
    public void no_winner_when_both_players_occupy_top_row() {
        Player[][] grid = {
                { player1, player2, player1 },
                { null, null, null },
                { null, null, null },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_middle_row() {
        Player[][] grid = {
                { null, null, null },
                { player1, player2, player1 },
                { null, null, null },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_bottom_row() {
        Player[][] grid = {
                { null, null, null },
                { player1, player2, player1 },
                { null, null, null },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_left_column() {
        Player[][] grid = {
                { player1, null, null },
                { player2, null, null },
                { player1, null, null },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_middle_column() {
        Player[][] grid = {
                { null, player1, null },
                { null, player2, null },
                { null, player1, null },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_right_column() {
        Player[][] grid = {
                { null, null, player1 },
                { null, null, player2 },
                { null, null, player1 },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_top_left_to_bottom_right_diagonal() {
        Player[][] grid = {
                { player1, null, null },
                { null, player2, null },
                { null, null, player1 },
        };

        assertNotWinningGrid(grid);
    }

    @Test
    public void no_winner_when_both_players_occupy_top_right_to_bottom_left_diagonal() {
        Player[][] grid = {
                { null, null, player1 },
                { null, player2, null },
                { player1, null, null },
        };

        assertNotWinningGrid(grid);
    }
}

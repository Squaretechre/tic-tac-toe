import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Player1WinsTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    private void assertWinWhenPlayerNextMovesTo(Coordinate coordinate, Player[][] grid) {
        TicTacToe game = new TicTacToe(player1, player2, new Grid(grid));
        game.nextPlayerMoveAt(coordinate);

        Result result = game.result();
        assertTrue(game.isFinished());
        assertEquals("Dan wins!", result.message());
    }

    @Test
    public void player1_wins_when_all_top_row_occupied() {
        Player[][] grid = {
                { player1, player1, null },
                { null, null, null },
                { null, null, null },
        };

        Coordinate topRightOf = new Coordinate(2,0);
        assertWinWhenPlayerNextMovesTo(topRightOf, grid);
    }

    @Test
    public void player1_wins_when_all_middle_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { player1, player1, null },
                { null, null, null },
        };

        Coordinate middleRightOf = new Coordinate(2,1);
        assertWinWhenPlayerNextMovesTo(middleRightOf, grid);
    }

    @Test
    public void player1_wins_when_all_bottom_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { null, null, null },
                { player1, player1, null },
        };

        Coordinate bottomRightOf = new Coordinate(2,2);
        assertWinWhenPlayerNextMovesTo(bottomRightOf, grid);
    }

    @Test
    public void player1_wins_when_all_left_column_occupied() {
        Player[][] grid = {
                { player1, null, null },
                { player1, null, null },
                { null, null, null },
        };

        Coordinate bottomLeftOf = new Coordinate(0,2);
        assertWinWhenPlayerNextMovesTo(bottomLeftOf, grid);
    }

    @Test
    public void player1_wins_when_all_middle_column_occupied() {
        Player[][] grid = {
                { null, player1, null },
                { null, player1, null },
                { null, null, null },
        };

        Coordinate bottomMiddleOf = new Coordinate(1,2);
        assertWinWhenPlayerNextMovesTo(bottomMiddleOf, grid);
    }

    @Test
    public void player1_wins_when_all_right_column_occupied() {
        Player[][] grid = {
                { null, null, player1 },
                { null, null, player1 },
                { null, null, null },
        };

        Coordinate bottomRightOf = new Coordinate(2,2);
        assertWinWhenPlayerNextMovesTo(bottomRightOf, grid);
    }

    @Test
    public void player1_wins_when_all_top_left_to_bottom_right_diagonal_occupied() {
        Player[][] grid = {
                { player1, null, null },
                { null, player1, null },
                { null, null, null },
        };

        Coordinate bottomRightOf = new Coordinate(2,2);
        assertWinWhenPlayerNextMovesTo(bottomRightOf, grid);
    }

    @Test
    public void player1_wins_when_all_top_right_to_bottom_left_diagonal_occupied() {
        Player[][] grid = {
                { null, null, player1 },
                { null, player1, null },
                { null, null, null },
        };

        Coordinate bottomLeftOf = new Coordinate(0,2);
        assertWinWhenPlayerNextMovesTo(bottomLeftOf, grid);
    }
}

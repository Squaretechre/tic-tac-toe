import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Player2WinsTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Dan");
        player2 = new Player("Other Dan");
    }

    private void assertWinWhenPlayer2Moves(Coordinate player2Move, Coordinate player1Move, Player[][] grid) {
        TicTacToe game = new TicTacToe(player1, player2, new Grid(grid));
        game.nextPlayerMoveAt(player1Move);
        game.nextPlayerMoveAt(player2Move);

        Result result = game.result();
        assertTrue(game.isFinished());
        assertEquals("Other Dan wins!", result.message());
    }

    @Test
    public void player2_wins_when_all_top_row_occupied() {
        Player[][] grid = {
                { player2, player2, null },
                { null, null, null },
                { null, null, null },
        };

        Coordinate player1BottomLeft = new Coordinate(0,2);
        Coordinate player2TopRight = new Coordinate(2,0);
        assertWinWhenPlayer2Moves(player2TopRight, player1BottomLeft, grid);
    }

    @Test
    public void player2_wins_when_all_middle_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { player2, player2, null },
                { null, null, null },
        };
        Coordinate player1BottomLeft = new Coordinate(0,2);
        Coordinate player2MiddleRight = new Coordinate(2,1);
        assertWinWhenPlayer2Moves(player2MiddleRight, player1BottomLeft, grid);
    }

    @Test
    public void player2_wins_when_all_bottom_row_occupied() {
        Player[][] grid = {
                { null, null, null },
                { null, null, null },
                { player2, player2, null },
        };

        Coordinate player1TopLeft = new Coordinate(0,0);
        Coordinate player2BottomRight = new Coordinate(2,2);
        assertWinWhenPlayer2Moves(player2BottomRight, player1TopLeft, grid);
    }

    @Test
    public void player2_wins_when_all_left_column_occupied() {
        Player[][] grid = {
                { player2, null, null },
                { player2, null, null },
                { null, null, null },
        };

        Coordinate player1BottomRight = new Coordinate(2,2);
        Coordinate player2BottomLeft = new Coordinate(0,2);
        assertWinWhenPlayer2Moves(player2BottomLeft, player1BottomRight, grid);
    }

    @Test
    public void player2_wins_when_all_middle_column_occupied() {
        Player[][] grid = {
                { null, player2, null },
                { null, player2, null },
                { null, null, null },
        };

        Coordinate player1BottomRight = new Coordinate(2,2);
        Coordinate player2BottomMiddle = new Coordinate(1,2);
        assertWinWhenPlayer2Moves(player2BottomMiddle, player1BottomRight, grid);
    }

    @Test
    public void player2_wins_when_all_right_column_occupied() {
        Player[][] grid = {
                { null, null, player2 },
                { null, null, player2 },
                { null, null, null },
        };

        Coordinate player1TopLeft = new Coordinate(0,0);
        Coordinate player2BottomRight = new Coordinate(2,2);
        assertWinWhenPlayer2Moves(player2BottomRight, player1TopLeft, grid);
    }

    @Test
    public void player2_wins_when_all_top_left_to_bottom_right_diagonal_occupied() {
        Player[][] grid = {
                { player2, null, null },
                { null, player2, null },
                { null, null, null },
        };

        Coordinate player1TopRight = new Coordinate(0,2);
        Coordinate player2BottomRight = new Coordinate(2,2);
        assertWinWhenPlayer2Moves(player2BottomRight, player1TopRight, grid);
    }

    @Test
    public void player2_wins_when_all_top_right_to_bottom_left_diagonal_occupied() {
        Player[][] grid = {
                { null, null, player2 },
                { null, player2, null },
                { null, null, null },
        };

        Coordinate player1TopLeft = new Coordinate(0,0);
        Coordinate player2BottomLeft = new Coordinate(0,2);
        assertWinWhenPlayer2Moves(player2BottomLeft, player1TopLeft, grid);
    }
}

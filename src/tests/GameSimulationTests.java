import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameSimulationTests {

    private TicTacToe game;

    @Before
    public void setUp() {
        Player player1 = new Player("X");
        Player player2 = new Player("O");
        game = new TicTacToe(player1, player2);
    }

    @Test
    public void game_not_won_when_neither_player1_or_player2_have_winning_lines() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(1, 1));
        game.nextPlayerMoveAt(new Coordinate(1, 0));
        game.nextPlayerMoveAt(new Coordinate(2, 1));

        assertFalse(game.isFinished());
    }

    @Test
    public void game_is_won_when_player1_plays_a_winning_game() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(1, 1));
        game.nextPlayerMoveAt(new Coordinate(1, 0));
        game.nextPlayerMoveAt(new Coordinate(2, 1));
        game.nextPlayerMoveAt(new Coordinate(2, 0));

        assertTrue(game.isFinished());
    }

    @Test
    public void game_is_won_when_player2_plays_a_winning_game() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(0, 1));
        game.nextPlayerMoveAt(new Coordinate(1, 0));
        game.nextPlayerMoveAt(new Coordinate(1, 1));
        game.nextPlayerMoveAt(new Coordinate(0, 2));
        game.nextPlayerMoveAt(new Coordinate(2, 1));

        assertTrue(game.isFinished());
    }
}

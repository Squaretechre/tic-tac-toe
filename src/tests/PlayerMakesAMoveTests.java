import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlayerMakesAMoveTests {

    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe(new Player("Dan"), new Player("Other Dan"), new Grid());
    }

    @Test
    public void player1_can_move_when_it_is_their_turn() {
        PlayerMoveResponse response = game.nextPlayerMoveAt(new Coordinate(0, 0));
        assertTrue(response.success);
        assertEquals("Dan made a move at 0, 0", response.message);
    }

    @Test
    public void player1_can_not_move_to_a_coordinate_when_that_coordinate_is_already_occupied() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        game.nextPlayerMoveAt(new Coordinate(0, 1));
        PlayerMoveResponse response = game.nextPlayerMoveAt(new Coordinate(0, 1));
        assertFalse(response.success);
        assertEquals("Dan can't move to 0, 1. That coordinate is already occupied.", response.message);
    }

    @Test
    public void player2_can_move_when_it_is_their_turn() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        PlayerMoveResponse response = game.nextPlayerMoveAt(new Coordinate(0, 1));
        assertTrue(response.success);
        assertEquals("Other Dan made a move at 0, 1", response.message);
    }

    @Test
    public void player2_can_not_move_to_a_coordinate_when_that_coordinate_is_already_occupied() {
        game.nextPlayerMoveAt(new Coordinate(0, 0));
        PlayerMoveResponse response = game.nextPlayerMoveAt(new Coordinate(0, 0));
        assertFalse(response.success);
        assertEquals("Other Dan can't move to 0, 0. That coordinate is already occupied.", response.message);
    }


}

package um;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class GameTests {

    @Test
    public void setNumPlayersReturnsTrue() {
        Game game = new Game();
        assertTrue(game.setNumPlayers(2));
    }

    @Test
    public void setNumPlayersReturnsFalseWhenTooHigh() {
        Game game = new Game();
        assertFalse(game.setNumPlayers(9));
    }

    @Test
    public void setNumPlayersReturnsFalseWhenZero() {
        Game game = new Game();
        assertFalse(game.setNumPlayers(0));
    }

    @Test
    public void setNumPlayersReturnsFalseWhenNegative() {
        Game game = new Game();
        assertFalse(game.setNumPlayers(-1));
    }
}

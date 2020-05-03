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

    @Test
    public void setMapSizeReturnsTrue() {
        Game game = new Game();
        assertTrue(game.setMapSize(6, 5));
    }

    @Test
    public void setMapSizeReturnsFalseWhenSizeLessThanMin() {
        Game game = new Game();
        assertFalse(game.setMapSize(4, 5));
    }

    @Test
    public void setMapSizeReturnsFalseWhenSizeTooHigh() {
        Game game = new Game();
        assertFalse(game.setMapSize(51, 5));
    }
}

package um;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerTests {

    @Test
    public void setPositionReturnsTrue() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setPosition(position);
    }
}

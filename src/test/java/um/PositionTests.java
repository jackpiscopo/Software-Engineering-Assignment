package um;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PositionTests {

    @Test
    public void settingXPosition() {
        Position position = new Position();
        position.setX(2);
        assertEquals(2, position.getX());
    }

    @Test
    public void settingYPosition() {
        Position position = new Position();
        position.setY(2);
        assertEquals(2, position.getY());
    }
}

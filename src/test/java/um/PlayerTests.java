package um;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class PlayerTests {

    @Test
    public void settingPosition() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setPosition(position);
        assertEquals(position, player.getPosition());
    }

    @Test
    public void settingUncoveredStartup() {
        Player player = new Player();
        player.setUncoveredStartup(5);
        assertFalse(player.getUncovered(2, 3));
    }

    @Test
    public void settingUncoveredTile() {
        Player player = new Player();
        player.setUncoveredStartup(5);
        player.setUncovered(2, 3);
        assertTrue(player.getUncovered(2, 3));
    }

    @Test
    public void settingNextMoveForX() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setUncoveredStartup(5);
        player.setPosition(position);
        player.setStartPosition(position);
        player.setNextMove('l', 5);
        assertEquals(1, player.getNextMove().getX());
    }

    @Test
    public void settingNextMoveForY() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setUncoveredStartup(5);
        player.setPosition(position);
        player.setStartPosition(position);
        player.setNextMove('l', 5);
        assertEquals(3, player.getNextMove().getY());
    }

    @Test
    public void movingPlayerForX() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setUncoveredStartup(5);
        player.setPosition(position);
        player.setStartPosition(position);
        player.setNextMove('l', 5);
        Position nextMove = player.getNextMove();
        player.setPosition(nextMove);
        assertEquals(1, player.getPosition().getX());
    }

    @Test
    public void movingPlayerForY() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setUncoveredStartup(5);
        player.setPosition(position);
        player.setStartPosition(position);
        player.setNextMove('l', 5);
        Position nextMove = player.getNextMove();
        player.setPosition(nextMove);
        assertEquals(3, player.getPosition().getY());
    }

    @Test
    public void settingStartPosition() {
        Player player = new Player();
        Position position = new Position(2, 3);
        player.setUncoveredStartup(5);
        player.setPosition(position);
        player.setStartPosition(position);
        assertEquals(position, player.getStartPosition());
    }

    @Test
    public void settingWinner() {
        Player player = new Player();
        player.setWinner();
        assertTrue(player.getWinner());
    }
}

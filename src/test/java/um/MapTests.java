package um;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;

public class MapTests {

    @Test
    public void mapSizeSetWithValidSize() {
        Map map = new Map();
        assertTrue(map.setMapSize(5, 5));
    }

    @Test
    public void mapSizeSetWithNotEqualSize() {
        Map map = new Map();
        assertFalse(map.setMapSize(5, 6));
    }

    @Test
    public void mapSizeSetWithSizeTooLarge() {
        Map map = new Map();
        assertFalse(map.setMapSize(51, 51));
    }

    @Test
    public void mapSizeSetWithSizeTooSmall() {
        Map map = new Map();
        assertFalse(map.setMapSize(4, 4));
    }

    @Test
    public void getTileTypeReturnsGrassOrWater() {
        Map map = new Map();
        map.setMapSize(5, 5);
        map.generate();
        char tile = map.getTileType(2, 3);
        assertTrue(tile == 'g' || tile == 'w');
    }
}

package um;

import junit.framework.TestCase;

public class MapTypeCreatorTest extends TestCase {

    public void testSetMapTypeForSafeMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        creator.setMapType(1, map);
        int maxWaterTiles = map.getMaxWaterTiles();
        assertTrue(maxWaterTiles <= 10);
    }

    public void testSetMapTypeForHazardousMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        creator.setMapType(2, map);
        int maxWaterTiles = map.getMaxWaterTiles();
        assertTrue((maxWaterTiles >= 25) && (maxWaterTiles <= 35));
    }

    public void testSetMapTypeForInvalidMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        creator.setMapType(0, map);
        int maxWaterTiles = map.getMaxWaterTiles();
        assertEquals(0, maxWaterTiles);
    }

    public void testFindCreatorForTypeForSafeMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        assertNotNull(creator.findCreatorForType(1, map));
    }

    public void testFindCreatorForTypeForHazardousMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        assertNotNull(creator.findCreatorForType(2, map));
    }

    public void testFindCreatorForTypeForInvalidMap() {
        Map map = new Map();
        MapTypeCreator creator = new MapTypeCreator();
        assertNull(creator.findCreatorForType(0, map));
    }
}
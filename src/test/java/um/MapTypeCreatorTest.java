package um;

import junit.framework.TestCase;

public class MapTypeCreatorTest extends TestCase {

    public void testSetMapTypeForSafeMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        creator.setMapType(1);
        int maxWaterTiles = map.getMaxWaterTiles();
        assertTrue(maxWaterTiles <= 10);
    }

    public void testSetMapTypeForHazardousMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        creator.setMapType(2);
        int maxWaterTiles = map.getMaxWaterTiles();
        assertTrue((maxWaterTiles >= 25) && (maxWaterTiles <= 35));
    }

    public void testSetMapTypeForInvalidMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        assertNull(creator.setMapType(0));
    }

    public void testFindCreatorForTypeForSafeMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        assertNotNull(creator.findCreatorForType(1));
    }

    public void testFindCreatorForTypeForHazardousMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        assertNotNull(creator.findCreatorForType(2));
    }

    public void testFindCreatorForTypeForInvalidMap() {
        Map map;
        map = Map.getInstance();
        MapTypeCreator creator = new MapTypeCreator();
        assertNull(creator.findCreatorForType(0));
    }
}
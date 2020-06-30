package um;

public class SafeMapCreator extends MapTypeCreator {

    Map map;

    public SafeMapCreator(Map m) {

        map = m;
    }

    public MapType setMapType() {

        SafeMapType mapType = new SafeMapType();

        mapType.setMapType(map);

        return mapType;
    }
}

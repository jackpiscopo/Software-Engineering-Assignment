package um;

public class HazardousMapCreator extends MapTypeCreator {

    Map map;

    public HazardousMapCreator(Map m) {

        map = m;
    }

    public MapType setMapType() {

        HazardousMapType mapType = new HazardousMapType();

        mapType.setMapType(map);

        return mapType;
    }
}

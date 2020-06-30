package um;

public class MapTypeCreator {

    public MapType setMapType(int type, Map map) {

        MapTypeCreator creator = findCreatorForType(type, map);

        if(creator != null) {
            return creator.setMapType();
        } else {
            return null;
        }
    }

    public MapTypeCreator findCreatorForType(int type, Map map) {

        if(type == 1) {

            return new SafeMapCreator(map);
        } else {
            if(type == 2) {

                return new HazardousMapCreator(map);
            }
        }
        return null;
    }

    public MapType setMapType() {
        return null;
    }
}

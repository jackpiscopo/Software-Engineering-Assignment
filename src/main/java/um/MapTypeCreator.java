package um;

public class MapTypeCreator {

    public MapType setMapType(int type) {

        MapTypeCreator creator = findCreatorForType(type);

        if(creator != null) {
            return creator.setMapType();
        } else {
            return null;
        }
    }

    public MapTypeCreator findCreatorForType(int type) {

        if(type == 1) {

            return new SafeMapCreator();
        } else {
            if(type == 2) {

                return new HazardousMapCreator();
            }
        }
        return null;
    }

    public MapType setMapType() {
        return null;
    }
}

package um;

public class MapTypeCreator {

    public MapType setMapType(String type) {

        MapTypeCreator creator = findCreatorForType(type);

        return creator.setMapType();
    }

    public MapTypeCreator findCreatorForType(String type) {

        if(type.equals("safe")) {

            return new SafeMapCreator();
        }
    }
}

package um;

public class SafeMapType implements MapType {

    //public String type = "safe";

    @Override
    public void setMapType(Map map) {

        // Generates random number from 1 to 10
        int randomNumber = (int) (Math.random() * ((10 - 1) + 1) + 1);

        map.setWaterTileRatio(randomNumber);
    }
}

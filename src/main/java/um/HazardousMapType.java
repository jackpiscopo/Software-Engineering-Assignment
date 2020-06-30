package um;

public class HazardousMapType implements MapType {

    //public String type = "hazardous";

    @Override
    public void setMapType(Map map) {

        // Generates random number from 25 to 35
        int randomNumber = (int) (Math.random() * ((35 - 25) + 1) + 25);

        map.setWaterTileRatio(randomNumber);
    }
}

package um;

public class Map {

    private int size = 0;

    public boolean setMapSize(int x, int y) {
        if(x == y && x >=5 && x <= 50) {
            size = x;
            return true;
        } else {
            return false;
        }
    }

    public void generate() {

    }

    //public char getTileType(int x, int y) {

    //}
}

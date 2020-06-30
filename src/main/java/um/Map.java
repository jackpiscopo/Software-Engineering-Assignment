package um;

public class Map {

    private int size = 0;

    private char[][] mapArray;

    private int maxWaterTiles = 0;

    public boolean setMapSize(int x, int y) {
        // If x and y are equal and size is valid
        if(x == y && x >=5 && x <= 50) {
            size = x;
            return true;
        } else {
            return false;
        }
    }

    public void generate() {
        int i=0;
        int j=0;

        // If map size has been declared
        if(size != 0) {

            mapArray = new char[size][size];

            for(i=0;i<size;i++) {
                for(j=0;j<size;j++) {
                    // Generates random number from 1 to 100
                    int randomNumber = (int) (Math.random() * ((100 - 1) + 1) + 1);

                    // If number is between 1 and max water tiles set, creates water tile
                    if(randomNumber >= 1 && randomNumber <= maxWaterTiles) {
                        mapArray[i][j] = 'w';
                    } else {
                        // Else, creates grass tile
                        mapArray[i][j] = 'g';
                    }
                }
            }
        } else {
            System.out.println("ERROR: Map size not declared.");
        }

        // Generates two random numbers
        int randomNumber1 = (int) (Math.random() * ((size - 1) + 1));
        int randomNumber2 = (int) (Math.random() * ((size - 1) + 1));

        // Creates treasure
        mapArray[randomNumber1][randomNumber2] = 't';
    }

    public char getTileType(int x, int y) {
        return mapArray[x][y];
    }

    public void setWaterTileRatio(int maxWaterTiles) {
        this.maxWaterTiles = maxWaterTiles;
    }

    public int getMaxWaterTiles() {
        return maxWaterTiles;
    }
}

package um;

public class Map {

    private int size = 0;

    private char[][] mapArray;

    public boolean setMapSize(int x, int y) {
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

        if(size != 0) {

            mapArray = new char[size][size];

            for(i=0;i<size;i++) {
                for(j=0;j<size;j++) {
                    int randomNumber = (int) (Math.random() * ((10 - 1) + 1) + 1);

                    if(randomNumber >= 1 && randomNumber <= 7) {
                        mapArray[i][j] = 'g';
                    } else {
                        mapArray[i][j] = 'w';
                    }
                }
            }
        } else {
            System.out.println("ERROR: Map size not declared.");
        }

        int randomNumber1 = (int) (Math.random() * ((size - 1) + 1));
        int randomNumber2 = (int) (Math.random() * ((size - 1) + 1));

        mapArray[randomNumber1][randomNumber2] = 't';
    }

    public char getTileType(int x, int y) {
        return mapArray[x][y];
    }
}

package um;

import java.util.ArrayList;

public class Map {

    private int size = 0;

    //char[][] mapArray;

    //ArrayList<MapTile> mapArray = new ArrayList<MapTile>();
    //ArrayList<ArrayList<MapTile>> mapArray;

    char[][] mapArray;

    int i=0;
    int j=0;

    public boolean setMapSize(int x, int y) {
        if(x == y && x >=5 && x <= 50) {
            size = x;
            return true;
        } else {
            return false;
        }
    }

    public void generate() {
        if(size != 0) {
            //mapArray = new char[size][size];

            //mapArray = new ArrayList<>(size);

            /*for(i=0;i<size;i++) {
                mapArray.add(new ArrayList<MapTile>());
            }*/

            mapArray = new char[size][size];

            for(i=0;i<size;i++) {
                for(j=0;j<size;j++) {
                    int randomNumber = (int) (Math.random() * ((10 - 1) + 1) + 1);

                    if(randomNumber >= 1 && randomNumber <= 7) {
                        mapArray[i][j] = 'g';
                    } else {
                        mapArray[i][j] = 'w';
                    }


                    //MapTile mapTile = new MapTile()
                    //mapArray.get(i).add()
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

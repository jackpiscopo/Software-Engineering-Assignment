package um;

import java.lang.*;

public class Player {
    private Position position = new Position();

    private boolean[][] uncovered;

    public void move(char direction) {
        char d = Character.toLowerCase(direction);

        switch(d) {
            case 'u':
                position.setY(position.getY() + 1);
                break;
            case 'd':
                position.setY(position.getY() - 1);
                break;
            case 'l':
                position.setX(position.getX() - 1);
                break;
            case 'r':
                position.setX(position.getX() + 1);
                break;
        }
    }

    public boolean setPosition(Position p) {
        // to add checks
        position = p;
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public void setUncovered(int mapSize) {
        int i=0;
        int j=0;

        uncovered = new boolean[mapSize][mapSize];

        for(i=0;i<mapSize;i++) {
            for(j=0;j<mapSize;j++) {
                uncovered[i][j] = false;
            }
        }
    }

    public boolean getUncovered(int x, int y) {
        return uncovered[x][y];
    }
}

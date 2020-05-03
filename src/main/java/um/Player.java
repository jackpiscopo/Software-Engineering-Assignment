package um;

import java.lang.*;

public class Player {
    private Position position = new Position();
    private Position nextMove = new Position();

    private boolean[][] uncovered;

    public boolean move(char direction, int mapSize) {
        char d = Character.toLowerCase(direction);

        int currentY;
        int currentX;

        switch(d) {
            case 'u':
                currentY = position.getY();
                if (currentY < (mapSize - 1)) {
                    position.setY(currentY + 1);
                    return true;
                }
                break;
            case 'd':
                currentY = position.getY();
                if (currentY >= 1) {
                    position.setY(currentY - 1);
                    return true;
                }
                break;
            case 'l':
                currentX = position.getX();
                if (currentX >= 1) {
                    position.setX(currentX - 1);
                    return true;
                }
                break;
            case 'r':
                currentX = position.getX();
                if (currentX < (mapSize - 1)) {
                    position.setX(currentX + 1);
                    return true;
                }
                break;
        }
        return false;
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

    public boolean setNextMove(char direction, int mapSize) {
        char d = Character.toLowerCase(direction);

        int currentY = position.getY();
        int currentX = position.getX();

        switch(d) {
            case 'u':
                if (currentY < (mapSize - 1)) {
                    nextMove.setY(currentY + 1);
                    nextMove.setX(currentX);
                    return true;
                }
                break;
            case 'd':
                if (currentY >= 1) {
                    nextMove.setY(currentY - 1);
                    nextMove.setX(currentX);
                    return true;
                }
                break;
            case 'l':
                if (currentX >= 1) {
                    nextMove.setX(currentX - 1);
                    nextMove.setY(currentY);
                    return true;
                }
                break;
            case 'r':
                if (currentX < (mapSize - 1)) {
                    nextMove.setX(currentX + 1);
                    nextMove.setY(currentY);
                    return true;
                }
                break;
        }
        return true;
    }
}

package um;

import java.lang.*;

public class Player {
    private Position position = new Position();
    private Position nextMove = new Position();
    private Position startPosition = new Position();
    private boolean winner = false;

    private boolean[][] uncovered;

    public void setPosition(Position p) {
        position = p;
    }

    public Position getPosition() {
        return position;
    }

    public void setUncoveredStartup(int mapSize) {
        int i=0;
        int j=0;

        uncovered = new boolean[mapSize][mapSize];

        for(i=0;i<mapSize;i++) {
            for(j=0;j<mapSize;j++) {
                uncovered[i][j] = false;
            }
        }
    }

    public void setUncovered(int x, int y) {
        uncovered[x][y] = true;
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
                if (currentY >= 1) {
                    nextMove.setY(currentY - 1);
                    nextMove.setX(currentX);
                    return true;
                }
                break;
            case 'd':
                if (currentY < (mapSize - 1)) {
                    nextMove.setY(currentY + 1);
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
        return false;
    }

    public Position getNextMove() {
        return nextMove;
    }

    public void setStartPosition(Position p) {
        startPosition = p;
        setUncovered(startPosition.getX(), startPosition.getY());
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setWinner() {
        winner = true;
    }

    public boolean getWinner() {
        return winner;
    }
}

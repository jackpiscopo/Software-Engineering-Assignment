package um;

import java.lang.*;

public class Player {
    private Position position = new Position();

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
}

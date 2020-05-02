package um;

public class MapTile {

    private char type;
    private boolean uncovered;

    public MapTile() {

    }

    public MapTile(char type, boolean uncovered) {
        this.type = type;
        this.uncovered = uncovered;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }

    public char getType() {
        return type;
    }

    public boolean getUncovered() {
        return uncovered;
    }
}

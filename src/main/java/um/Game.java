package um;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Game {

    Player[] players;

    static int mapSize = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        int playersCount = 0;

        boolean validAnswer;

        System.out.println("Welcome to the game.");
        System.out.println("Game Setup: ");

        do {
            System.out.println("Number of players (2-8): ");
            playersCount = sc.nextInt();

            validAnswer = game.setNumPlayers(playersCount);

        } while (!validAnswer);

        do {
            int minMapSize = 0;

            if (playersCount <= 4) {
                System.out.println("Map size (5x5)-(50x50): ");
                mapSize = sc.nextInt();

                minMapSize = 5;
            } else {
                System.out.println("Map size (8x8)-(50x50): ");
                mapSize = sc.nextInt();

                minMapSize = 8;
            }

            validAnswer = game.setMapSize(mapSize, minMapSize);

        } while (!validAnswer);

        game.startGame();
    }

    public boolean setNumPlayers(int n) {
        if(n >= 2 && n <= 8) {
            players = new Player[n];
            return true;
        } else {
            System.out.println("ERROR: Invalid number of players.");
            return false;
        }
    }

    public boolean setMapSize(int mapSize, int minMapSize) {
        if (mapSize >= minMapSize && mapSize <= 50) {
            return true;
        } else {
            System.out.println("ERROR: Invalid map size.");
            return false;
        }
    }

    public void startGame() {
        int i=0;

        Map map = new Map();
        map.generate();

        // Set random starting positions
        for(i=0;i<Array.getLength(players);i++) {
            int x=0;
            int y=0;

            do {
                x = (int) (Math.random() * (mapSize + 1));
                y = (int) (Math.random() * (mapSize + 1));
            } while (map.getTileType(x, y) != 'g');

            Position position = new Position(x, y);
            System.out.println("Position for player "+i+" is ("+x+" "+y+")");
            players[i] = new Player();
            players[i].setPosition(position);
        }
    }

    public void generateHTMLFiles() {
        int i=0;

        for(i=0;i<Array.getLength(players);i++) {
            File htmlTemplateFile = new File("../../html/template.html");
            String htmlString = null;
            try {
                htmlString = FileUtils.readFileToString(htmlTemplateFile);
                String playerNumber = Integer.toString(i);
                String gameTable = "";
                htmlString = htmlString.replace("$playerNumber", playerNumber);
                htmlString = htmlString.replace("$gameTable", gameTable);
                String newFileName = "map_player_"+ (i + 1);
                File newHtmlFile = new File("../../html/"+newFileName);
                FileUtils.writeStringToFile(newHtmlFile, htmlString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

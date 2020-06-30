package um;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Game {

    private Player[] players;

    private static int mapSize = 0;

    private Map map = new Map();

    private boolean gameWon = false;

    private int turns=1;

    public static void main(String[] args) {

        Game game = new Game();

        System.out.println("------------------------------------------");
        System.out.println("Welcome to the game.");
        System.out.println("------------------------------------------");
        System.out.println("Game Setup: ");

        game.setupGame();

        game.startGame();
    }

    public boolean setNumPlayers(int n) {
        // If number of players is valid
        if(n >= 2 && n <= 8) {
            // Create array of n players
            players = new Player[n];
            return true;
        } else {
            System.out.println("------------------------------------------");
            System.out.println("ERROR: Invalid number of players.");
            return false;
        }
    }

    public boolean setMapSize(int mapSize, int minMapSize) {
        // If map size is valid
        if (mapSize >= minMapSize && mapSize <= 50) {
            return true;
        } else {
            System.out.println("------------------------------------------");
            System.out.println("ERROR: Invalid map size.");
            return false;
        }
    }

    public void setupGame() {

        Scanner sc = new Scanner(System.in);

        int playersCount = 0;

        int mapType = 0;

        boolean validAnswer;

        // Asks user for number of players
        do {
            System.out.println("Number of players (2-8): ");
            playersCount = sc.nextInt();

            validAnswer = setNumPlayers(playersCount);

        } while (!validAnswer);

        // Asks user for map size
        do {
            int minMapSize = 0;

            // If players count is less than 4, min map size is 5
            if (playersCount <= 4) {
                System.out.println("Map size (5x5)-(50x50): ");
                mapSize = sc.nextInt();

                minMapSize = 5;
            } else {
                // If players count is more than 4, min map size is 8
                System.out.println("Map size (8x8)-(50x50): ");
                mapSize = sc.nextInt();

                minMapSize = 8;
            }

            validAnswer = setMapSize(mapSize, minMapSize);

        } while (!validAnswer);

        do {
            System.out.println("Enter map type: ");
            System.out.println("1. Safe.");
            System.out.println("2. Hazardous.");
            System.out.println("Enter a number (1-2): ");

            mapType = sc.nextInt();

        } while ((mapType != 1) && (mapType != 2));
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        int i=0;

        map.setMapSize(mapSize, mapSize);
        map.generate();

        // Sets random starting positions
        for(i=0;i<Array.getLength(players);i++) {
            int x=0;
            int y=0;

            do {
                x = (int) (Math.random() * ((mapSize - 1) + 1));
                y = (int) (Math.random() * ((mapSize - 1) + 1));
            } while (map.getTileType(x, y) != 'g');

            Position position = new Position(x, y);

            players[i] = new Player();
            players[i].setPosition(position);
            players[i].setUncoveredStartup(mapSize);
            players[i].setStartPosition(position);
        }

        do {
            generateHTMLFiles();

            System.out.println("------------------------------------------");
            System.out.println("Turn "+turns);

            char direction;

            boolean validAnswer;

            // Asks for next move for every player
            for (i = 0; i < Array.getLength(players); i++) {
                do {
                    System.out.println("------------------------------------------");
                    System.out.println("Player " + (i + 1) + " please enter your next move.");
                    System.out.println("(U)p, (D)own, (L)eft, (R)ight");
                    direction = sc.next().charAt(0);

                    validAnswer = players[i].setNextMove(direction, mapSize);

                    if (!validAnswer) {
                        System.out.println("------------------------------------------");
                        System.out.println("ERROR: Invalid answer.");
                    }
                } while (!validAnswer);
            }

            for (i = 0; i < Array.getLength(players); i++) {
                Position nextMove = players[i].getNextMove();
                int nextMoveX = nextMove.getX();
                int nextMoveY = nextMove.getY();

                char nextMoveType = map.getTileType(nextMoveX, nextMoveY);

                //Uncovers next move for every player
                players[i].setUncovered(nextMoveX, nextMoveY);

                switch (nextMoveType) {
                    case 'g':
                        // If next move is grass, move to next tile
                        players[i].setPosition(nextMove);
                        break;
                    case 'w':
                        // If next move is water, move to starting position
                        players[i].setPosition(players[i].getStartPosition());
                        break;
                    case 't':
                        // If next move is treasure, player wins
                        players[i].setPosition(nextMove);
                        players[i].setWinner();
                        gameWon = true;
                        generateHTMLFiles();
                        break;
                }
            }

            turns++;
        } while(!gameWon);

        System.out.println("------------------------------------------");
        System.out.println("Game has been won.");
        System.out.println("Thanks for playing.");
        System.out.println("------------------------------------------");
    }

    public void generateHTMLFiles() {
        int i=0;
        int j=0;
        int k=0;

        String newHTMLFileParent = "";

        for(i=0;i<Array.getLength(players);i++) {
            Position playerPosition = players[i].getPosition();

            try {
                // Reads template HTML file to string
                File htmlTemplateFile = new File("./src/main/html/template.html").getCanonicalFile();
                String htmlString = null;

                htmlString = FileUtils.readFileToString(htmlTemplateFile);
                String playerNumber = Integer.toString((i+1));

                String message = " ";

                // If game is won, set a message for players who won or lost
                if(gameWon) {
                    if(players[i].getWinner()) {
                        message = "<div class=\"message\">You won!</div>";
                    } else {
                        message = "<div class=\"message\">Game over!</div>";
                    }
                }

                StringBuilder buffer = new StringBuilder();

                // Builds string for table
                for(j=0;j<mapSize;j++) {
                    // Creates a new table row
                    buffer.append("<tr class=\"table-row\">");
                    for(k=0;k<mapSize;k++) {
                        boolean isPlayerPosition = (playerPosition.getX() == k && playerPosition.getY() == j);

                        // Creates a new table cell
                        buffer.append("<td class=\"table-data\">");

                        // If tile has been uncovered or is the player's starting position
                        if(players[i].getUncovered(k, j) || isPlayerPosition) {

                            char colour = map.getTileType(k, j);

                            switch (colour) {
                                case 'g':
                                    // If the tile is grass, sets as green in table
                                    buffer.append("<div class=\"game-tile green\"></div>");
                                    break;
                                case 'w':
                                    // If the tile is water, sets as blue in table
                                    buffer.append("<div class=\"game-tile blue\"></div>");
                                    break;
                                case 't':
                                    // If the tile is treasure, sets as yellow in table
                                    buffer.append("<div class=\"game-tile yellow\"></div>");
                                    break;
                            }
                        } else {
                            // If not uncovered or starting position, sets as grey
                            buffer.append("<div class=\"game-tile grey\"></div>");
                        }

                        // If tile is player position, sets player in table
                        if(isPlayerPosition) {
                            buffer.append("<div class=\"player\"></div>");
                        }

                        // Ends table cell
                        buffer.append("</td>");
                    }
                    // Ends table row
                    buffer.append("</tr>");
                }

                // Replaces HTML variables with values
                htmlString = htmlString.replace("$playerNumber", playerNumber);
                htmlString = htmlString.replace("$message", message);
                htmlString = htmlString.replace("$gameTable", buffer);
                String newFileName = "map_player_"+ (i + 1) +".html";
                File newHtmlFile = new File("./src/main/html/"+newFileName).getCanonicalFile();
                FileUtils.writeStringToFile(newHtmlFile, htmlString);

                newHTMLFileParent = newHtmlFile.getParent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------------------------------------------");
        System.out.println("HTML game files have been generated.");
        System.out.println("Please find the game files at " + newHTMLFileParent + "\\map_player_n.html");
        System.out.println("Where n is the player number.");
    }
}

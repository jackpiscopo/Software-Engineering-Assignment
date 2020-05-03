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
        if(n >= 2 && n <= 8) {
            players = new Player[n];
            return true;
        } else {
            System.out.println("------------------------------------------");
            System.out.println("ERROR: Invalid number of players.");
            return false;
        }
    }

    public boolean setMapSize(int mapSize, int minMapSize) {
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

        boolean validAnswer;

        do {
            System.out.println("Number of players (2-8): ");
            playersCount = sc.nextInt();

            validAnswer = setNumPlayers(playersCount);

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

            validAnswer = setMapSize(mapSize, minMapSize);

        } while (!validAnswer);
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        int i=0;

        map.setMapSize(mapSize, mapSize);
        map.generate();

        // Set random starting positions
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

                players[i].setUncovered(nextMoveX, nextMoveY);

                switch (nextMoveType) {
                    case 'g':
                        players[i].setPosition(nextMove);
                        break;
                    case 'w':
                        players[i].setPosition(players[i].getStartPosition());
                        break;
                    case 't':
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
                File htmlTemplateFile = new File("./src/main/html/template.html").getCanonicalFile();
                String htmlString = null;

                htmlString = FileUtils.readFileToString(htmlTemplateFile);
                String playerNumber = Integer.toString((i+1));

                String message = " ";

                if(gameWon) {
                    if(players[i].getWinner()) {
                        message = "<div class=\"message\">You won!</div>";
                    } else {
                        message = "<div class=\"message\">Game over!</div>";
                    }
                }

                StringBuilder buffer = new StringBuilder();

                for(j=0;j<mapSize;j++) {
                    buffer.append("<tr class=\"table-row\">");
                    for(k=0;k<mapSize;k++) {
                        boolean isPlayerPosition = (playerPosition.getX() == k && playerPosition.getY() == j);

                        buffer.append("<td class=\"table-data\">");

                        if(players[i].getUncovered(k, j) || isPlayerPosition) {

                            char colour = map.getTileType(k, j);

                            switch (colour) {
                                case 'g':
                                    buffer.append("<div class=\"game-tile green\"></div>");
                                    break;
                                case 'w':
                                    buffer.append("<div class=\"game-tile blue\"></div>");
                                    break;
                                case 't':
                                    buffer.append("<div class=\"game-tile yellow\"></div>");
                                    break;
                            }
                        } else {
                            buffer.append("<div class=\"game-tile grey\"></div>");
                        }

                        if(isPlayerPosition) {
                            buffer.append("<div class=\"player\"></div>");
                        }

                        buffer.append("</td>");
                    }
                    buffer.append("</tr>");
                }

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

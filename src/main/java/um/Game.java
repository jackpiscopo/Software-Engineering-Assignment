package um;

import java.util.Scanner;

public class Game {

    Player[] players;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        int playersCount = 0;
        int mapSize = 0;

        boolean validAnswer = false;

        System.out.println("Welcome to the game.");
        System.out.println("Game Setup: ");

        do {
            System.out.println("Number of players (2-8): ");
            playersCount = sc.nextInt();

            validAnswer = game.setNumPlayers(playersCount);

        } while (!validAnswer);

        validAnswer = false;

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

            if (mapSize >= minMapSize && mapSize <= 50) {
                validAnswer = true;
            } else {
                System.out.println("ERROR: Invalid map size.");
            }
        } while (!validAnswer);
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
        return true;
    }
}

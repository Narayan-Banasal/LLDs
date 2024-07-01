import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the grid:");
        int length1 = scanner.nextInt();
        System.out.println("Enter the breadth of the grid:");
        int breadth1 = scanner.nextInt();
        Grid player1Grid = new Grid(length1, breadth1);

        Grid player2Grid = null;

        while(true) {
            System.out.println("Enter the length of the grid:");
            int length2 = scanner.nextInt();
            System.out.println("Enter the breadth of the grid:");
            int breadth2 = scanner.nextInt();
            if (length2 > length1 || breadth2 > breadth1) {
                System.out.println("The grid size should be less than or equal to the first player's grid size.");
                continue;
            }
            player2Grid = new Grid(length2, breadth2);
            break;
        }

        while(true) {
            System.out.println("Enter the number of cannons for player 1:");
            int cannonCount1 = scanner.nextInt();
            int val = player1Grid.setCannonCount(cannonCount1);
            if (val == 0) {
                continue;
            }
            break;
        }

        while(true) {
            System.out.println("Enter the number of cannons for player 2:");
            int cannonCount2 = scanner.nextInt();
            int val = player2Grid.setCannonCount(cannonCount2);
            if (val == 0) {
                continue;
            }
            break;
        }

        System.out.println("Enter the positions of the cannons for player 1:");
        for (int i = 0; i < player1Grid.getCannonCount(); i++) {
            System.out.println("Enter the position of cannon " + (i + 1) + ":");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Enter the target position of cannon " + (i + 1) + ":");
            int tx = scanner.nextInt();
            int ty = scanner.nextInt();
            int val = player1Grid.setCannon(x, y, tx, ty, player2Grid.getLength(), player2Grid.getBreadth());
            if (val == 0) {
                System.out.println("The cannon is already set. Enter the positions again.");
                i--;
            } else if (val == -1) {
                System.out.println("The cannon is out of bounds. Enter the positions again.");
                i--;
            } else {
                System.out.println("Cannon set successfully.");
            }
        }

        System.out.println("Enter the positions of the cannons for player 2:");
        for (int i = 0; i < player2Grid.getCannonCount(); i++) {
            System.out.println("Enter the position of cannon " + (i + 1) + ":");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Enter the target position of cannon " + (i + 1) + ":");
            int tx = scanner.nextInt();
            int ty = scanner.nextInt();
            int val = player2Grid.setCannon(x, y, tx, ty, player1Grid.getLength(), player1Grid.getBreadth());
            if (val == 0) {
                System.out.println("The cannon is already set. Enter the positions again.");
                i--;
            } else if (val == -1) {
                System.out.println("The cannon is out of bounds. Enter the positions again.");
                i--;
            } else {
                System.out.println("Cannon set successfully.");
            }
        }

        System.out.println("Enter yes to start the game:");
        String start = scanner.next();
        if (start.equalsIgnoreCase("yes")) {
            String str = StartGame.startGame(player1Grid, player2Grid);
            System.out.println(str);
        }

        scanner.close();

        player1Grid.printGrid();
        player2Grid.printGrid();
    }
}
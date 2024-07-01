import java.util.HashMap;

/**
 * This class represents the grid of each player for the game.
 */

public class Grid {
    private final int length;
    private final int breadth;
    private int cannonCount;
    private HashMap<Integer, Integer> cannonData;

    public Grid(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        cannonData = new HashMap<Integer, Integer>();
    }

    public int setCannonCount(int cannonCount) {
        if (cannonCount > this.length * this.breadth) {
            System.out.println("The number of cannons should be less than or equal to the grid size.");
            return 0;
        }
        this.cannonCount = cannonCount;
        return 1;
    }

    // Set the cannon at the given position.
    // x, y: position of the cannon on the grid.
    // tx, ty: are the targets of the cannon.
    // tLength, tBreadth: dimensions of the other player's grid.
    // Returns 1 if the cannon is set successfully, 0 if the cannon is already set, -1 if the cannon is out of bounds.
    public int setCannon(int x, int y, int tx, int ty, int tLength, int tBreadth) {
        if (tx < 0 || ty < 0 || tx >= tLength || ty >= tBreadth || x < 0 || y < 0 || x >= this.length || y >= this.breadth) {
            return -1;
        }
        if (cannonData.containsKey(x * this.breadth + y)) {
            return 0;
        }
        cannonData.put(x * this.breadth + y, tx * tBreadth + ty);
        return 1;
    }

    public void printGrid() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.breadth; j++) {
                if (cannonData.containsKey(i * this.breadth + j)) {
                    System.out.print("C ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public int getCannonCount() {
        return this.cannonCount;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public HashMap<Integer, Integer> getCannonData() {
        return cannonData;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to start the game.
 */
public class StartGame {

    public static String startGame(Grid player1Grid, Grid player2Grid) {
        int player1CannonCount = player1Grid.getCannonCount();
        int player2CannonCount = player2Grid.getCannonCount();
        int player1Length = player1Grid.getLength();
        int player1Breadth = player1Grid.getBreadth();
        int player2Length = player2Grid.getLength();
        int player2Breadth = player2Grid.getBreadth();
        int player1Destroyed = 0, player2Destroyed = 0;

        HashMap<Integer, Integer> player1CannonData = player1Grid.getCannonData();
        HashMap<Integer, Integer> player2CannonData = player2Grid.getCannonData();

        for (Map.Entry<Integer, Integer> entry : player1CannonData.entrySet()) {
            int x = entry.getKey() / player1Breadth;
            int y = entry.getKey() % player1Breadth;
            int tx = entry.getValue() / player2Breadth;
            int ty = entry.getValue() % player2Breadth;
            if (player2CannonData.containsKey(tx * player2Breadth + ty) && player2CannonData.get(tx * player2Breadth + ty) == x * player1Breadth + y) {
            } else if (player2CannonData.containsKey(tx * player2Breadth + ty)){
                player2Destroyed++;
            }
        }

        for (Map.Entry<Integer, Integer> entry : player2CannonData.entrySet()) {
            int x = entry.getKey() / player2Breadth;
            int y = entry.getKey() % player2Breadth;
            int tx = entry.getValue() / player1Breadth;
            int ty = entry.getValue() % player1Breadth;
            if (player1CannonData.containsKey(tx * player1Breadth + ty) && player1CannonData.get(tx * player1Breadth + ty) == x * player2Breadth + y) {
            } else if (player1CannonData.containsKey(tx * player1Breadth + ty)){
                player1Destroyed++;
            }
        }

        if (player1CannonCount - player1Destroyed > player2CannonCount - player2Destroyed) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }
}

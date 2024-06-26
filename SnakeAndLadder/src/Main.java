import models.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        User user1 = new User("Deepak");
        User user2 = new User("Narayan");
        User user3 = new User("Vivek Vikas");
        User user4 = new User("Vivek Mishra");
        users.add(user1);
        users.add(user2);
//        users.add(user3);
//        users.add(user4);

        Game game = new BoardGame(5, 5, users, 1);

        while(game.move()) {
        }

        // TODO - Undo and redo feature needs to be added
        // TODO - Add the feature to save the game and load the game
        // TODO - For the consecutive 6's the user should get the chance to roll the dice again
     }
}
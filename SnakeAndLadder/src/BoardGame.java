import models.Board;
import models.Dice;
import models.User;

import java.util.*;

public class BoardGame extends Game{
    private LinkList userList;
    private List<Dice> dices;
    // Mapping between a user and a pointer in the user list
    private Map<User, LinkList> userListMapping;

    private static class LinkList {
        private final User user;
        private LinkList prePointer;
        private LinkList nextPointer;

        public LinkList(User user, LinkList prePointer, LinkList nextPointer) {
            this.user = user;
            this.prePointer = prePointer;
            this.nextPointer = nextPointer;
        }
    }

    public BoardGame(int length, int breadth, List<User> users, int diceNum) {
        super(new Board(length, breadth, users));
        this.userList = null;
        this.userListMapping = new HashMap<>();
        this.createUserList(users);
        dices = new ArrayList<>();
        for (int i = 0; i < diceNum; i++) {
            dices.add(new Dice());
        }
    }

    private void createUserList(List<User> users) {
        LinkList pre = null;
        for (int i = 0; i < users.size(); i++) {
            if (i == 0) {
                LinkList user = new LinkList(users.get(i), null, null);
                this.userList = user;
                pre = user;
                userListMapping.put(users.get(i), user);
            } else if (i == users.size()-1){
                LinkList user = new LinkList(users.get(i), pre, this.userList);
                pre.nextPointer = user;
                this.userList.prePointer = user;
                pre = user;
                userListMapping.put(users.get(i), user);
            } else {
                LinkList user = new LinkList(users.get(i), pre, null);
                pre.nextPointer = user;
                pre = user;
                userListMapping.put(users.get(i), user);
            }
            System.out.println(pre.user.getName() + " has joined a game");
        }
        System.out.println();
    }

    public void remove(User user) {
        LinkList link = userListMapping.get(user);
        LinkList previous = link.prePointer;
        previous.nextPointer = link.nextPointer;

        LinkList next = link.nextPointer;
        next.prePointer = previous;

        link.prePointer = null;
        link.nextPointer = null;

        userListMapping.remove(user);

        this.addPosition(link.user);
    }

    @Override
    public Boolean move() {
        User user = nextTurn();

        if (user == null) {
            System.out.println("The game has been ended and the positions are: ");
            int ranking = 1;
            for (User player: super.getPositions()) {
                System.out.println(ranking + ": " + player.getName());
                ranking += 1;
            }
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(user.getName() + "'s turn. Please enter");
        scanner.nextLine();
        int diceSum = this.dicesSum();

        Boolean won = super.getBoard().moveUser(user, diceSum);

        if (won) {
            remove(user);
            System.out.println(user.getName() + " has completed the game at position " + this.getPositions().size());
        }

        return true;
    }

    public int dicesSum() {
        int sumDice = 0;
        for (Dice dice : this.dices) {
            sumDice += dice.getRandom();
        }

        return sumDice;
    }

    public User nextTurn() {
        if (userList == null) return null;
        if (userList.nextPointer == userList) {
            remove(userList.user);
            System.out.println(userList.user
                    .getName() + " has completed the game at position " + this.getPositions().size());
            return null;
        }
        LinkList tempList = userList;
        userList = userList.nextPointer;

        return tempList.user;
    }
}

package models;

import java.util.*;

public class Board {
    private Long id;
    private int length;
    private int breadth;
    private Map<User, Integer> mapping;
    private Map<Integer, Ladder> ladders;
    private Map<Integer, Snake> snakes;

    public Board(int length, int breadth, List<User> users) {
        Random random = new Random();
        this.id = random.nextLong();
        this.length = length;
        this.breadth = breadth;

        mapping = new HashMap<User, Integer>();
        for (User user : users) {
            this.mapping.put(user, 0);
        }
        ladders = new HashMap<>();
        snakes = new HashMap<>();

        this.createLadders();
        this.createSnake();
    }

    private void createSnake() {
        int snakeNum = length * breadth / 10;
        Map<Integer, Snake> snakes = new HashMap<>();
        for (int i = 0; i < snakeNum; i++) {
            Random r = new Random();
            int start = r.nextInt(2, length * breadth);
            int end = r.nextInt(1, start);
            // check for the overlapping condition with ladder and snake, check for the circular condition
            // with the both snake and ladder
            if (snakes.containsKey(start) || ladders.containsKey(start) ||
                    (ladders.containsKey(end) && ladders.get(end).getEnd() == start)) {
                i -= 1;
                continue;
            }
            snakes.put(start, new Snake(start, end));
            System.out.println("Snake start: " + start + " Snake end: " + end);
        }
        this.snakes = snakes;
        System.out.println();
    }

    private void createLadders() {
        int ladderNum = length * breadth / 10;
        Map<Integer, Ladder> ladders = new HashMap<>();
        for (int i = 0; i < ladderNum; i++) {
            Random r = new Random();
            int start = r.nextInt(2, length * breadth);
            if (ladders.containsKey(start) || snakes.containsKey(start)) {
                i -= 1;
                continue;
            }
            int end = r.nextInt(start + 1, length * breadth + 1);
            ladders.put(start, new Ladder(start, end));
            System.out.println("Ladder start: " + start + " Ladder end: " + end);
        }
        this.ladders = ladders;
        System.out.println();
    }

    public int getPositionOfUser(User user) {
        return mapping.get(user);
    }

    public Boolean moveUser(User user, int steps) {
        int currPosition = this.getPositionOfUser(user);
        int newPosition = this.getPositionOfUser(user) + steps;
        System.out.println("Current position: " + currPosition + " New position: " + newPosition);
        // out of the board
        if (newPosition > length * breadth) {
            System.out.println(user.getName() + " stays on the same position as dice sum is out of the board");
            return false;
        }
        System.out.println(user.getName() + " rolled a " + steps + " and moved from " + currPosition + " to " + newPosition);
        // checking for the snake
        if (snakes.containsKey(newPosition)) {
            newPosition = snakes.get(newPosition).getEnd();
            System.out.println(user.getName() + " is bitten by the snake. Would go to " + newPosition);
        }
        // checking fo the ladder
        if (ladders.containsKey(newPosition)) {
            newPosition = ladders.get(newPosition).getStart();
            System.out.println(user.getName() + " is climbing the Ladder. Would go to " + newPosition);
        }
        // checking for the snake
        if (snakes.containsKey(newPosition)) {
            newPosition = snakes.get(newPosition).getEnd();
            System.out.println(user.getName() + " is bitten by the snake. Would go to " + newPosition);
        }

        System.out.println();
        mapping.put(user, newPosition);

        return (newPosition) == (length * breadth);
    }
}

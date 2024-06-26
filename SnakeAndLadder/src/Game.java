import models.Board;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Game {
    private Long id;
    private Board board;
    private List<User> positions;

    public Game(Board board) {
        Random random = new Random();
        this.id = random.nextLong();
        this.board = board;
        this.positions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public Board getBoard() {
        return board;
    }

    public List<User> getPositions() {
        return positions;
    }

    public void addPosition(User user) {
        this.positions.add(user);
    }

    public abstract Boolean move();

    public abstract User nextTurn();
}

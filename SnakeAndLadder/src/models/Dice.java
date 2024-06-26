package models;

import java.util.Random;

public class Dice {
    private final int start;
    private final int end;

    public Dice() {
        this.start = 1;
        this.end = 6;
    }

    public Dice(int start, int end) {
        if (start > end) throw new IllegalArgumentException("Dice start must be lesser than end");
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getRandom() {
        Random random = new Random();
        int ranNum = random.nextInt(this.start, this.end + 1);
        return ranNum;
    }
}

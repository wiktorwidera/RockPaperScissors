import java.util.Random;

public enum Sign {
        ROCK, PAPER, SCISSORS;

    public static Sign generateRandomSign() {
        Sign[] values = Sign.values();
        int length = values.length;
        int rand = new Random().nextInt(length);
        return values[rand];
    }
}

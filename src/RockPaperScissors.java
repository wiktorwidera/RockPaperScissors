public class RockPaperScissors {
    public static void main(String[] args) {
        GameHelper gameHelper = new GameHelper();

        gameHelper.initializeGame();
        gameHelper.gameplay();
        gameHelper.summarizeGame();
    }
}
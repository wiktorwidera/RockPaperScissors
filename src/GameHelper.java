import java.util.Scanner;

public class GameHelper {

    private Player user = new Player();
    private Player computer = new Player();
    private int gameCounter = 0;
    public void initializeGame() {
        System.out.println("Hello, this is Rock, Paper, Scissors game");
        computer.setPlayerName("Computer");

        System.out.print("Enter your name: ");
        setUserName();
    }

    public void summarizeGame() {
        System.out.println("GAMEPLAY SUMMARY");
        System.out.println("-----------------");
        System.out.println(computer.getPlayerName() + " wins " + computer.getWinCounter() + " times.");
        System.out.println(user.getPlayerName() + " wins " + user.getWinCounter() + " times.");
        System.out.println("Draw: " + (gameCounter - computer.getWinCounter() - user.getWinCounter()) + " times.");
    }

    private void setUserName() {
        Scanner scanner = new Scanner(System.in);
        user.setPlayerName(scanner.nextLine());
    }
}

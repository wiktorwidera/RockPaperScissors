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

    public void gameplay() {
        while (true) {
            showMessageToEnterChoice();
            String userChoice = readUserChoice();
            Sign computerSign = Sign.generateRandomSign();
            Sign userSign;
            if (userChoice.toUpperCase().equals("R")) {
                userSign = Sign.ROCK;
            } else if (userChoice.toUpperCase().equals("P")) {
                userSign = Sign.PAPER;
            } else if (userChoice.toUpperCase().equals("S")) {
                userSign = Sign.SCISSORS;
            } else {
                userSign = null;
                break;
            }

            if (userSign == computerSign) {
                showWhoWon(null);
            } else if ((userSign == Sign.ROCK && computerSign == Sign.SCISSORS) ||
                    (userSign == Sign.PAPER && computerSign == Sign.ROCK) ||
                    (userSign == Sign.SCISSORS && computerSign == Sign.PAPER)) {
                user.incrementWinCounter();
                showWhoWon(user);
            } else {
                computer.incrementWinCounter();
                showWhoWon(computer);
            }

            gameCounter++;
        }
    }

    public void summarizeGame() {
        System.out.println("\nGAMEPLAY SUMMARY");
        System.out.println("-----------------");
        System.out.println(computer.getPlayerName() + " won " + computer.getWinCounter() + " times.");
        System.out.println(user.getPlayerName() + " won " + user.getWinCounter() + " times.");
        System.out.println("Draw: " + (gameCounter - computer.getWinCounter() - user.getWinCounter()) + " times.");
    }

    private void setUserName() {
        Scanner scanner = new Scanner(System.in);
        user.setPlayerName(scanner.nextLine());
    }

    private String readUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void showMessageToEnterChoice() {
        System.out.println("\n\nEnter your choice: ");
        System.out.println("(R)ock");
        System.out.println("(P)aper");
        System.out.println("(S)cissors");
        System.out.println("Type any other character to quit the game");
        System.out.print("Your choice: ");
    }

    private void showWhoWon(Player p) {
        if (p == null) {
            System.out.println("Draw!");
        }
        else {
            System.out.println(p.getPlayerName() + " won!");
        }
    }
}

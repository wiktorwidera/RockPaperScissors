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

            computer.setPlayerSign(Sign.generateRandomSign());

            if (userChoice.toUpperCase().equals("R")) {
                user.setPlayerSign(Sign.ROCK);
            } else if (userChoice.toUpperCase().equals("P")) {
                user.setPlayerSign(Sign.PAPER);
            } else if (userChoice.toUpperCase().equals("S")) {
                user.setPlayerSign(Sign.SCISSORS);
            } else {
                user.setPlayerSign(null);
                break;
            }

            Player playerWhoWon = checkWhoWon(user, computer);
            if (playerWhoWon == null) {
                showWhoWon(playerWhoWon);
            }
            else {
                playerWhoWon.incrementWinCounter();
                showWhoWon(playerWhoWon);
            }

            gameCounter++;
        }
    }

    public Player checkWhoWon(Player user, Player computer) {
        Player playerWhoWon;
        if (user.getPlayerSign() == computer.getPlayerSign()) {
            playerWhoWon =  null;
        } else if ((user.getPlayerSign()  == Sign.ROCK && computer.getPlayerSign() == Sign.SCISSORS) ||
                (user.getPlayerSign() == Sign.PAPER && computer.getPlayerSign() == Sign.ROCK) ||
                (user.getPlayerSign() == Sign.SCISSORS && computer.getPlayerSign() == Sign.PAPER)) {
            playerWhoWon = user;
        } else {
            playerWhoWon = computer;
        }
        return playerWhoWon;
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

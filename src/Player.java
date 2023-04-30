public class Player {
    private String playerName;
    private int winCounter = 0;

    public void setPlayerName(String name) {
        playerName = name;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void incrementWinCounter() {
        winCounter++;
    }

    public int getWinCounter() {
        return winCounter;
    }
}

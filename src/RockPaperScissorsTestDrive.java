public class RockPaperScissorsTestDrive {
    public static void main(String[] args) {

        GameHelper gameHelper = new GameHelper();

        Player p1 = new Player();
        Player p2 = new Player();

        p1.setPlayerSign(Sign.ROCK);
        p2.setPlayerSign(Sign.ROCK);

        System.out.println(p1.getPlayerSign().toString());
        System.out.println(p2.getPlayerSign().toString());

        String result = "failed";
        if (gameHelper.checkWhoWon(p1, p2) == null) {
            result = "passed";
        }

        System.out.println(result);
    }
}

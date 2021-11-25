package dev.codefactory.tennis;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Player, Integer> currentScore;

    public Game() {
        currentScore = new HashMap<>();
        currentScore.put(Player.ONE, 0);
        currentScore.put(Player.TWO, 0);
    }

    public Integer getCurrentScore(Player player) {
        return currentScore.get(player);
    }

    public void pointWonBy(Player player) {
        if (isOver()) return;
        currentScore.put(player, currentScore.get(player)+1);
    }

    public boolean isOver() {
        return playerHasAtLeast4Points() && playerHasScore2PointsMore();
    }

    public Player determineWinner() {
        if (!isOver()) return null;
        return currentScore.get(Player.TWO) >= 4 ? Player.TWO : Player.ONE;
    }

    private boolean playerHasAtLeast4Points() {
        return currentScore.get(Player.ONE) >= 4
                || currentScore.get(Player.TWO) >= 4;
    }

    private boolean playerHasScore2PointsMore() {
        return Math.abs(currentScore.get(Player.ONE) - currentScore.get(Player.TWO)) >= 2;
    }
}

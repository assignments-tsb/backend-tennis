package dev.codefactory.tennis;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private static final int MINIMUM_POINTS_TO_WIN = 4;
    private static final int POINTS_TO_BEAT = 2;

    protected final Map<Player, Integer> currentScore;

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
        return playerHasEnoughPointsToWin() && playerIsAhead();
    }

    public Player determineWinner() {
        if (!isOver()) return null;
        return currentScore.get(Player.TWO) >= currentScore.get(Player.ONE)
                ? Player.TWO : Player.ONE;
    }

    protected boolean playerHasEnoughPointsToWin() {
        return currentScore.get(Player.ONE) >= MINIMUM_POINTS_TO_WIN
                || currentScore.get(Player.TWO) >= MINIMUM_POINTS_TO_WIN;
    }

    private boolean playerIsAhead() {
        return Math.abs(currentScore.get(Player.ONE) - currentScore.get(Player.TWO)) >= POINTS_TO_BEAT;
    }
}

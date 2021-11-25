package dev.codefactory.tennis;

import java.util.LinkedList;
import java.util.List;

public class Match {

    private static final int POINTS_TO_WIN = 6;
    private static final int POINTS_TO_ADVANTAGE = 2;

    private final List<Game> set = new LinkedList<>();

    public Game startNewGame() {
        var newGame = new Game();
        set.add(newGame);

        return newGame;
    }

    public boolean isTie() {
        return aPlayerHasEnoughPointsToWin()
                && countWinsForPlayer(Player.ONE)==countWinsForPlayer(Player.TWO);
    }

    public boolean isOver() {
        return aPlayerHasEnoughPointsToWin() && aPlayerHasEnoughAdvantage();
    }

    public Player determineWinner() {
        if (!isOver()) return null;

        return countWinsForPlayer(Player.ONE) > countWinsForPlayer(Player.TWO)
                ? Player.ONE : Player.TWO;
    }

    private boolean aPlayerHasEnoughPointsToWin() {
        return countWinsForPlayer(Player.ONE) >= POINTS_TO_WIN
                || countWinsForPlayer(Player.TWO) >= POINTS_TO_WIN;
    }

    private boolean aPlayerHasEnoughAdvantage() {
        return Math.abs(countWinsForPlayer(Player.ONE)-countWinsForPlayer(Player.TWO)) >= POINTS_TO_ADVANTAGE;
    }

    private int countWinsForPlayer(Player player) {
        int wins = 0;

        for (Game game : set) {
            if (game.isOver() && game.determineWinner() == player) wins++;
        }

        return wins;
    }
}

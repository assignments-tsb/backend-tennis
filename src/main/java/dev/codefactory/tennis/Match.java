package dev.codefactory.tennis;

import java.util.LinkedList;
import java.util.List;

public class Match {

    private final List<Game> set = new LinkedList<>();

    public Game startNewGame() {
        var newGame = new Game();
        set.add(newGame);

        return newGame;
    }

    public boolean isOver() {
        return onePlayerHasAtLeast6Games() && onePlayerIsAheadBy2();
    }

    public Player determineWinner() {
        return countWinsForPlayer(Player.ONE) > countWinsForPlayer(Player.TWO)
                && isOver()
                ? Player.ONE : Player.TWO;
    }

    private boolean onePlayerHasAtLeast6Games() {
        return countWinsForPlayer(Player.ONE) >= 6 || countWinsForPlayer(Player.TWO) >= 6;
    }

    private boolean onePlayerIsAheadBy2() {
        return Math.abs(countWinsForPlayer(Player.ONE)-countWinsForPlayer(Player.TWO)) >= 2;
    }

    private int countWinsForPlayer(Player player) {
        int wins = 0;

        for (Game game : set) {
            if (game.isOver() && game.determineWinner() == player) wins++;
        }

        return wins;
    }
}

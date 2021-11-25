package dev.codefactory.tennis;

import java.util.Map;

public class Game {

    private final Map<Player, Integer> currentScore = Map.of(Player.ONE, 0, Player.TWO, 0);

    public Integer getCurrentScore(Player player) {
        return 0;
    }

    public void pointWonBy(Player player) {
    }

    public Player determineWinner() {
        return null;
    }
}

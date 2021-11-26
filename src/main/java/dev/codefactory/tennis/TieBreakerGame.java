package dev.codefactory.tennis;

public class TieBreakerGame extends Game {

    private static final int POINTS_TO_WIN = 7;

    @Override
    protected boolean playerHasEnoughPointsToWin() {
        return currentScore.get(Player.ONE) >= POINTS_TO_WIN
                || currentScore.get(Player.TWO) >= POINTS_TO_WIN;
    }
}

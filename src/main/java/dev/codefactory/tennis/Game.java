package dev.codefactory.tennis;

public class Game {

    enum Winner {
        NONE,
        PLAYER_ONE,
        PLAYER_TWO
    }

    private Score currentScore = Score.LOVE_LOVE();

    public Score getCurrentScore() {
        return currentScore;
    }

    public void scoreForPlayerOne() {
        currentScore = currentScore.forPlayer1();
    }

    public void scoreForPlayerTwo() {
        currentScore = currentScore.forPlayer2();
    }

    public Winner pointWonBy() {
        return null;
    }
}

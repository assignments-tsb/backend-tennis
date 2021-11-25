package dev.codefactory.tennis;

public class Game {

    enum Winner {
        NONE,
        PLAYER_ONE,
        PLAYER_TWO
    }

    public Score getCurrentScore() {
        return Score.LOVE_LOVE();
    }

    public void scoreForPlayerOne() {

    }

    public void scoreForPlayerTwo() {

    }

    public Winner pointWonBy() {
        return null;
    }
}

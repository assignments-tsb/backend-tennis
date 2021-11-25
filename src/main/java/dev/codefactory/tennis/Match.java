package dev.codefactory.tennis;

public class Match {

    public Game startNewGame() {
        return new Game();
    }

    public boolean isOver() {
        return true;
    }

    public Player determineWinner() {
        return Player.TWO;
    }
}

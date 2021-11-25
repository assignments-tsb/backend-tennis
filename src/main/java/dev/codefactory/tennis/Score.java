package dev.codefactory.tennis;

import lombok.Value;

@Value
public class Score {

    int player1Points;
    int player2Points;

    public static Score LOVE_LOVE() {
        return new Score(0, 0);
    }

    public static Score of(int player1Points, int player2Points) {
        return new Score(player1Points, player2Points);
    }
}

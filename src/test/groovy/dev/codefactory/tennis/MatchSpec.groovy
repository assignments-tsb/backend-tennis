package dev.codefactory.tennis

import spock.lang.Specification

class MatchSpec extends Specification {

    def "a match has one set and one set has many games"() {

        given: "a match"
        Match match = new Match()

        when: "you can get the current game and start playing until its over"
        while (!match.isOver()) {
            Game currentGame = match.startNewGame()
            while (!currentGame.isOver()) {
                currentGame.pointWonBy(Player.ONE)
            }
        }

        then: "someone wins"
        match.determineWinner() == Player.ONE
    }

    def "a player wins the set by winning at least 6 games"(Integer player1Score, Integer player2Score, Boolean isOver, Player winner) {

        given: "a match"
        Match match = new Match()

        when: "both player wins X games"
        winGamesXTimes(match, Player.ONE, player1Score)
        winGamesXTimes(match, Player.TWO, player2Score)

        then: "the match is over?"
        match.isOver() == isOver

        and: "player X wins"
        match.determineWinner() == winner

        where:
        player1Score | player2Score | isOver | winner
        0            | 0            | false  | null
        1            | 0            | false  | null
        6            | 0            | true   | Player.ONE
        4            | 6            | true   | Player.TWO
        4            | 3            | false  | null
        2            | 6            | true   | Player.TWO
        5            | 6            | false  | null
    }

    def "a match goes to a tie breaker"() {

        given: "a match"
        Match match = new Match()

        when: "both player has 5 games"
        winGamesXTimes(match, Player.ONE, 5)
        winGamesXTimes(match, Player.TWO, 5)

        and: "one player has enough winning points"
        winGamesXTimes(match, Player.ONE, 1)

        and: "but the other player also made it to the winning point"
        winGamesXTimes(match, Player.TWO, 1)

        then: "the match is not yet over"
        !match.isOver()

        and: "the match is a tie"
        match.isTie()
    }

    private static void winGamesXTimes(Match match, Player player, int times) {
        for (int i=0; i<times; i++) winAGame(match, player)
    }

    private static void winAGame(Match match, Player winner) {
        Game game = match.startNewGame()
        while (!game.isOver()) {
            game.pointWonBy(winner)
        }
    }

}

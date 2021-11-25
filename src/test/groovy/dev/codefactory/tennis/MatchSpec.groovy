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
}

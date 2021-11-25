package dev.codefactory.tennis

import spock.lang.Specification

class GameSpec extends Specification {

    def "should start a game"() {

        when: "you start a game"
        Game game = new Game()

        then:
        game
    }

    def "should start a game with zero points"() {

        when: "you start a game"
        Game game = new Game()

        then: "the score should be zero-zero"
        game.getCurrentScore() == Score.LOVE_LOVE()
    }

    def "should let the players score a point in a game"() {

        given: "a new game"
        Game game = new Game()

        when: "player 1 scores"
        game.scoreForPlayerOne()

        and: "player 2 scores"
        game.scoreForPlayerTwo()

        then:
        game.getCurrentScore() == Score.of(1, 1)
    }

    def "should indicate who won the point"() {

        given: "a game"
        Game game = new Game()

        when: "asked if who won the point"
        Game.Winner winner = game.pointWonBy()

        then: "the winner should be determined"
        winner == Game.Winner.NONE
    }
}

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
        game.getCurrentScore(Player.ONE) == 0
        game.getCurrentScore(Player.ONE) == 0
    }

    def "should let the players score a point in a game"() {

        given: "a new game"
        Game game = new Game()

        when: "player 1 scores"
        game.pointWonBy(Player.ONE)

        and: "player 2 scores"
        game.pointWonBy(Player.TWO)

        then:
        game.getCurrentScore(Player.ONE) == 1
        game.getCurrentScore(Player.TWO) == 1
    }

    def "should indicate if theres already a winner"() {

        given: "a game"
        Game game = new Game()

        when: "asked if who won the point"
        Player winner = game.determineWinner()

        then: "the winner should be determined"
        winner == null
        !game.isOver()
    }

    def "should let player 1 win when he scores at least 4 points and a total of 2 more point than the opponent"() {

        given: "a game"
        Game game = new Game()

        when: "player 1 scores 4 points"
        game.pointWonBy(Player.ONE)
        game.pointWonBy(Player.ONE)
        game.pointWonBy(Player.ONE)
        game.pointWonBy(Player.ONE)

        then: "the winner should be determined"
        game.determineWinner() == Player.ONE

        and: "the game should be over"
        game.isOver()
    }
}

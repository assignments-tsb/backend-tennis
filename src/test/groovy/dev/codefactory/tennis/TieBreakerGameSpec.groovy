package dev.codefactory.tennis

import spock.lang.Specification

class TieBreakerGameSpec extends Specification {

    def "should win by seven points"() {
        given:
        Game game = new TieBreakerGame()

        when: "a player scores 7 points"
        7.times {
            game.pointWonBy(Player.ONE)
        }

        then: "the game is over"
        game.isOver()

        and: "player 1 wins"
        game.determineWinner() == Player.ONE
    }

    def "should not win by just 6 points"() {
        given:
        Game game = new TieBreakerGame()

        when: "a player scores 6 points"
        6.times {
            game.pointWonBy(Player.ONE)
        }

        then: "the game is not yet over"
        !game.isOver()
    }

    def "should not be over if the points is not yet ahead by 2"() {
        given:
        Game game = new TieBreakerGame()

        when: "player 1 scores 6 points"
        6.times {
            game.pointWonBy(Player.ONE)
        }

        and: "player 2 scores 6 points"
        6.times {
            game.pointWonBy(Player.TWO)
        }

        and: "even though one player scores 7"
        game.pointWonBy(Player.ONE)

        then: "the game is not yet over"
        !game.isOver()
    }

    def "should be never be over unless one player is ahead by 2"() {
        given:
        Game game = new TieBreakerGame()

        when: "player 1 scores 6 points"
        6.times {
            game.pointWonBy(Player.ONE)
        }

        and: "player 2 scores 6 points"
        6.times {
            game.pointWonBy(Player.TWO)
        }

        and: "the score is infinitely tied"
        100.times {
            game.pointWonBy(Player.ONE)
            game.pointWonBy(Player.TWO)
        }

        then: "the game is not yet over"
        !game.isOver()
    }

    def "should be over if the points is ahead by 2"() {
        given:
        Game game = new TieBreakerGame()

        when: "player 1 scores 6 points"
        6.times {
            game.pointWonBy(Player.ONE)
        }

        and: "player 2 scores 6 points"
        6.times {
            game.pointWonBy(Player.TWO)
        }

        and: "the score is infinitely tied"
        100.times {
            game.pointWonBy(Player.ONE)
            game.pointWonBy(Player.TWO)
        }

        and: "at some point in the future one player takes the lead"
        2.times {
            game.pointWonBy(Player.ONE)
        }

        then: "the game is over"
        game.isOver()

        and: "player 1 wins!"
        game.determineWinner() == Player.ONE
    }
}

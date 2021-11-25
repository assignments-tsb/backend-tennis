package dev.codefactory.tennis

import spock.lang.Specification

class GameSpec extends Specification {

    def "should start a game"() {

        when:
        Game game = new Game()

        then:
        game
    }
}

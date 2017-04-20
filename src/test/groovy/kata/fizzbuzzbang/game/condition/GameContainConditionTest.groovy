package kata.fizzbuzzbang.game.condition

import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class GameContainConditionTest extends Specification {

    def "function check if String contain substring"() {
        given:
            GameDivisionCondition divisionCondition = new GameForFiveCondition()
        when:
            def result = divisionCondition.isStringContainSubstring("alala123kot", "a123k")
        then:
            result == true
    }
}

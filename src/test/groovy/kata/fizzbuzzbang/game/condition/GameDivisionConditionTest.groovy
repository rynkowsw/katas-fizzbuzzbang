package kata.fizzbuzzbang.game.condition

import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class GameDivisionConditionTest extends Specification {



    def "function check if number is divisible by another one"() {
        given:
            GameDivisionCondition divisionCondition = new GameForFiveCondition()
        when:
            def result = divisionCondition.isNumberDivisibleByDivider(number, divider)
        then:
            result == expectedResult
        where:
            number| divider | expectedResult
            2     | 3       | false
            3     | 3       | true
            9     | 3       | true
            11    | 3       | false

    }

    def "function calculate rest of division"() {
        given:
            GameDivisionCondition divisionCondition = new GameForFiveCondition()
        when:
            def result = divisionCondition.restOfDivision(dividend, divider)
        then:
            result == expectedResult
        where:
            dividend | divider | expectedResult
            3        | 3       | 0
            5        | 3       | 2

    }
}

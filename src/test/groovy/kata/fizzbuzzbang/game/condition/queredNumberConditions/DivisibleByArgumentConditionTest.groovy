package kata.fizzbuzzbang.game.condition.queredNumberConditions

import spock.lang.Specification

/**
 * Created by wojciech on 26.04.17.
 */
class DivisibleByArgumentConditionTest extends Specification {

    def DIVIDER = 3

    def "condition check if number is divisible by divider provided in object creation"() {
        given:
            DivisibleByArgumentCondition divisionCondition = new DivisibleByArgumentCondition(DIVIDER)
        when:
            def result = divisionCondition.isConditionMet(number)
        then:
            result == expectedResult
        where:
            number|  expectedResult
            2     |  false
            3     |  true
            9     |  true
            11    |  false

    }
}

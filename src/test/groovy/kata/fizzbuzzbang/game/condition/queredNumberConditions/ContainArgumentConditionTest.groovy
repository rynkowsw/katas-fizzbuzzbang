package kata.fizzbuzzbang.game.condition.queredNumberConditions

import spock.lang.Specification


class ContainArgumentConditionTest extends Specification {

    def NUMBER = 33

    def "condition check if number provided in condition creation contain number argument as substring "() {
        given:
            ContainArgumentCondition divisionCondition = new ContainArgumentCondition(NUMBER)
        when:
            def result = divisionCondition.isConditionMet(number)
        then:
            result == expectedResult
        where:
            number  |  expectedResult
            222     |  false
            331     |  true
            923     |  false
    }
}

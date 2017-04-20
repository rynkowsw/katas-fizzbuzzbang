package kata.fizzbuzzbang.game.condition

import kata.fizzbuzzbang.game.Answer
import spock.lang.Specification
/**
 * Created by wojciech on 18.04.17.
 */
class GameForFiftenConditionTest extends Specification {

    def "condition is met when number is divisible by 15"() {
        given:
            GameCondition divisible = new GameForFiftenCondition()
        when:
            def result = divisible.isConditionMet(30)
        then:
            result == true
    }

    def "condition is not met when number is not divisible by 15"() {
        given:
            GameCondition divisible = new GameForFiftenCondition()
        when:
            def result = divisible.isConditionMet(31)
        then:
            result == false
    }

    def "condition always return fizzbuz message "() {
        given:
            GameCondition divisible = new GameForFiftenCondition()
        when:
            def message = divisible.message()
        then:
            message == Answer.FIZZBUZZ.message()
    }


}

package kata.fizzbuzzbang.game.condition

import kata.fizzbuzzbang.game.Answer
import kata.fizzbuzzbang.game.GameType
import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class GameForThreeConditionTest extends Specification {
    def "condition is met when number is divisible by 3 and not divisible by 15"() {
        given:
            GameCondition divisible = new GameForThreeCondition()
        when:
            def result = divisible.isConditionMet(21)
        then:
            result == true
    }

    def "condition is not met when number is not divisible by 3"() {
        given:
            GameCondition divisible = new GameForThreeCondition()
        when:
            def result = divisible.isConditionMet(11)
        then:
            result == false
    }

    def "condition is not met when number is divisible by 15"() {
        given:
            GameCondition divisible = new GameForThreeCondition()
        when:
            def result = divisible.isConditionMet(30)
        then:
            result == false
    }

    def "condition is met when number contain char '3' and game is extended"() {
        given:
            GameCondition divisible = new GameForThreeCondition( GameType.EXTENDED )
        when:
            def result = divisible.isConditionMet(31)
        then:
            result == true
    }

    def "condition is not met when number contain char '3' and game is standard"() {
        given:
            GameCondition divisible = new GameForThreeCondition( GameType.STANDARD )
        when:
            def result = divisible.isConditionMet(31)
        then:
            result == false
    }

    def "condition return 'FIZZ' message in standard game type"() {
        given:
            GameCondition divisible = new GameForThreeCondition(GameType.STANDARD)
        when:
            def message = divisible.message()
        then:
            message == Answer.FIZZ.message()
    }

    def "condition return 'Pow' message in extended game type"() {
        given:
            GameCondition divisible = new GameForThreeCondition(GameType.EXTENDED)
        when:
            def message = divisible.message()
        then:
            message == Answer.POW.message()
    }
}

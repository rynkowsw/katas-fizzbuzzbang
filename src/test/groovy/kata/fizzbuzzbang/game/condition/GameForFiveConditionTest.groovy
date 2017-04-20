package kata.fizzbuzzbang.game.condition

import kata.fizzbuzzbang.game.Answer
import kata.fizzbuzzbang.game.GameType
import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class GameForFiveConditionTest extends Specification {
    def "condition is met when number is divisible by five and not divisible by 15"() {
        given:
            GameCondition divisible = new GameForFiveCondition()
        when:
            def result = divisible.isConditionMet(20)
        then:
            result == true
    }

    def "condition is not met when number is not divisible by 5"() {
        given:
            GameCondition divisible = new GameForFiveCondition()
        when:
            def result = divisible.isConditionMet(31)
        then:
            result == false
    }

    def "condition is not met when number is divisible by 15"() {
        given:
            GameCondition divisible = new GameForFiveCondition()
        when:
            def result = divisible.isConditionMet(30)
        then:
            result == false
    }

    def "condition is met when number contain char '5' and game is extended"() {
        given:
            GameCondition divisible = new GameForFiveCondition( GameType.EXTENDED )
        when:
            def result = divisible.isConditionMet(51)
        then:
            result == true
    }

    def "condition return 'Buzz' message in standard game type"() {
        given:
            GameCondition divisible = new GameForFiveCondition(GameType.STANDARD)
        when:
            def message = divisible.message()
        then:
            message == Answer.BUZZ.message()
    }

    def "condition return 'Mruu' message in extended game type"() {
        given:
            GameCondition divisible = new GameForFiveCondition(GameType.EXTENDED)
        when:
            def message = divisible.message()
        then:
            message == Answer.MRUU.message()
    }
}

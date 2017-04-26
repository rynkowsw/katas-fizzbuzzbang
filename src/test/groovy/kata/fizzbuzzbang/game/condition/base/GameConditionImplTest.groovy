package kata.fizzbuzzbang.game.condition.base

import kata.fizzbuzzbang.game.Answer
import spock.lang.Specification
/**
 * Created by wojciech on 26.04.17.
 */
class GameConditionImplTest extends Specification {


    def NUMBER = 3
    private Condition condition
    private Answer answer

    def setup(){
        condition = Mock(Condition)
        answer = Answer.POW
    }


    def "Game condition evaluate message using given answer in constructor"() {
        given:
            GameConditionImpl gameConditionImpl = new GameConditionImpl(condition, answer)
        when:
            def result = gameConditionImpl.message()
        then:
            result == Answer.POW.message()
    }

    def "Game condition check condition using given condition in constructor"() {
        given:
            GameConditionImpl gameConditionImpl = new GameConditionImpl(condition, answer)
        when:
            gameConditionImpl.isConditionMet(NUMBER)
        then:
            1 * condition.isConditionMet(NUMBER)
    }


}

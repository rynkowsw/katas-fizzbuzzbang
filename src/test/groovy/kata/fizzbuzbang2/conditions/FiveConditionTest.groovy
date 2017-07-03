package kata.fizzbuzbang2.conditions

import spock.lang.Specification

/**
 * Created by wojciech on 03.07.17.
 */
class FiveConditionTest extends Specification {
    def "Function return empty string when number is not divisible by five" (){
        given:
            int someNumberNotDivisbleByFive = 4
            FiveCondition condition = new FiveCondition()
        when:
            String result = condition.apply(someNumberNotDivisbleByFive)
        then:
            result == ""
    }

    def "Function return empty string when given number is null" (){
        given:
            FiveCondition condition = new FiveCondition()
        when:
            String result = condition.apply(null)
        then:
            result == ""
    }

    def "Function return defined string when given number is divisible by five" (){
        given:
            int someNumberDivisbleByFive = 5
            FiveCondition condition = new FiveCondition()
        when:
            String result = condition.apply(someNumberDivisbleByFive)
        then:
            result == FiveCondition.message
    }

    def "Function return defined string when given number is zero" (){
        given:
            int givenNumber = 0
            FiveCondition condition = new FiveCondition()
        when:
            String result = condition.apply(givenNumber)
        then:
            result == FiveCondition.message
    }

    def "Function handle correctly negative numbers" (){
        given:
            int someNumberDivisbleByFive = -5
            FiveCondition condition = new FiveCondition()
        when:
            String result = condition.apply(someNumberDivisbleByFive)
        then:
            result == FiveCondition.message
    }

}

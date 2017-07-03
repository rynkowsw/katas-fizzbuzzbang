package kata.fizzbuzbang2.conditions

import spock.lang.Specification

/**
 * Created by wojciech on 03.07.17.
 */
class FiveExtendedConditionTest extends Specification {

    def "Function return empty string when given number is null" (){
        given:
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(null)
        then:
            result == ""
    }

    def "Function return empty string when number is not divisible by five and not contain five" (){
        given:
            int someNumberNotDivisbleByFiveAndNotContainingFive = 4
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(someNumberNotDivisbleByFiveAndNotContainingFive)
        then:
            result == ""
    }

    def "Function return defined string when given number is divisible by five" (){
        given:
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(someNumberDivisbleByFive)
        then:
            result == FiveExtendedCondition.message
        where:
            someNumberDivisbleByFive << [10, -10]
    }

    def "Function return defined string when given number is zero" (){
        given:
            int givenNumber = 0
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(givenNumber)
        then:
            result == FiveExtendedCondition.message
    }

    def "Function return defined string when given number contain digit five" (){
        given:
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(someNumberContainingFive)
        then:
            result == FiveExtendedCondition.message
        where:
            someNumberContainingFive << [151, -151]
    }


    def "Function return defined string when given number contain digit five and is divisble by five" (){
        given:
            int someNumber = 150
            FiveExtendedCondition condition = new FiveExtendedCondition()
        when:
            String result = condition.apply(someNumber)
        then:
            result == FiveExtendedCondition.message
    }



}

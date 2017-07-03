package kata.fizzbuzbang2.conditions

import spock.lang.Specification

/**
 * Created by wojciech on 03.07.17.
 */
class ThreeExtendedConditionTest extends Specification {

    def "Function return empty string when given number is null" (){
        given:
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(null)
        then:
            result == ""
    }

    def "Function return empty string when number is not divisible by three and not contain three" (){
        given:
            int someNumberNotDivisbleByThreeAndNotContainingThree = 4
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(someNumberNotDivisbleByThreeAndNotContainingThree)
        then:
            result == ""
    }

    def "Function return defined string when given number is 0" (){
        given:
            int givenNumber = 0
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(givenNumber)
        then:
            result == ThreeExtendedCondition.message
    }

    def "Function return defined string when given number is divisible by three" (){
        given:
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(someNumberDivisbleByThree)
        then:
            result == ThreeExtendedCondition.message
        where:
            someNumberDivisbleByThree << [2133, -2133]
    }


    def "Function return defined string when given number contain digit three" (){
        given:
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(someNumberContainingThree)
        then:
            result == ThreeExtendedCondition.message
        where:
            someNumberContainingThree << [13, -13]
    }

    def "Function return defined string when given number contain digit three and is divisble by three" (){
        given:
            int someNumber = 150
            ThreeExtendedCondition condition = new ThreeExtendedCondition()
        when:
            String result = condition.apply(someNumber)
        then:
            result == ThreeExtendedCondition.message
    }


}

package kata.fizzbuzbang2.conditions

import spock.lang.Specification

/**
 * Created by wojciech on 03.07.17.
 */
class ThreeConditionTest extends Specification {
    def "Function return empty string when number is not divisible by three" (){
        given:
            int someNumberNotDivisbleByThree = 2
            ThreeCondition condition = new ThreeCondition()
        when:
            String result = condition.apply(someNumberNotDivisbleByThree)
        then:
            result == ""
    }

    def "Function return empty string when given number is null" (){
        given:
            ThreeCondition condition = new ThreeCondition()
        when:
            String result = condition.apply(null)
        then:
            result == ""
    }

    def "Function return defined string when given number is divisible by three" (){
        given:
            int someNumberDivisbleByThree = 6
            ThreeCondition condition = new ThreeCondition()
        when:
            String result = condition.apply(someNumberDivisbleByThree)
        then:
            result == ThreeCondition.message
    }

    def "Function return defined string when given number is zero" (){
        given:
            int someNumberDivisbleByThree = 0
            ThreeCondition condition = new ThreeCondition()
        when:
            String result = condition.apply(someNumberDivisbleByThree)
        then:
            result == ThreeCondition.message
    }

    def "Function handle correctly negative numbers" (){
        given:
            int someNumberDivisbleByThree = -6
            ThreeCondition condition = new ThreeCondition()
        when:
            String result = condition.apply(someNumberDivisbleByThree)
        then:
            result == ThreeCondition.message
    }




}

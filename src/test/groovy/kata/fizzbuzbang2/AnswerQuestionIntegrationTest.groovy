package kata.fizzbuzbang2

import java.util.function.Function

import kata.fizzbuzbang2.conditions.FiveCondition
import kata.fizzbuzbang2.conditions.FiveExtendedCondition
import kata.fizzbuzbang2.conditions.ThreeCondition
import kata.fizzbuzbang2.conditions.ThreeExtendedCondition
import spock.lang.Specification
/**
 * Created by wojciech on 03.07.17.
 */
class AnswerQuestionIntegrationTest extends Specification {



    def "Function return valid result"() {
        given:
            Function<Integer, String> conditionFive = new FiveCondition()
            Function<Integer, String> conditionThree = new ThreeCondition()
            AnswerQuestion anserQuestion = new AnswerQuestion()
        when:
            String result = anserQuestion.fizzBuzzBang(number, conditionFive, conditionThree )
        then:
            result == expectedResult
        where:
            number  | expectedResult
                1   | ""
                3   | ThreeCondition.message
                5   | FiveCondition.message
                15  | ThreeCondition.message + FiveCondition.message
    }

    def "Function return results when Fizz is before Buzz, and this word is in the end of result "() {
        given:
            Function<Integer, String> conditionFive = new FiveCondition()
            Function<Integer, String> conditionThree = new ThreeCondition()
            Function<Integer, String> fiveExtendedCondition = new FiveExtendedCondition()
            Function<Integer, String> threeExtendedCondition1 = new ThreeExtendedCondition()
            AnswerQuestion anserQuestion = new AnswerQuestion()
        when:
            String result = anserQuestion.fizzBuzzBang(number, conditionFive, fiveExtendedCondition, conditionThree, threeExtendedCondition1  )
        then:
            result == expectedResult
        where:
            number  | expectedResult
            1530  |  FiveExtendedCondition.message+ ThreeExtendedCondition.message + ThreeCondition.message +FiveCondition.message
    }

}

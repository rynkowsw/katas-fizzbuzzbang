package kata.fizzbuzbang2

import java.util.function.Function

import spock.lang.Specification
/**
 * Created by wojciech on 03.07.17.
 */
class AnswerQuestionTest extends Specification {



    def "Function return empty string when condition arguments are not provided"() {
        given:
            Function<Integer, String> condition = null
            AnswerQuestion anserQuestion = new AnswerQuestion()
        when:
            String expectResult = anserQuestion.fizzBuzzBang(0, condition)
        then:
            expectResult.isEmpty()
    }

    def "Function return string returned by condition when it is provided"() {
        given:
            ConditionStub condition = new ConditionStub();
            AnswerQuestion anserQuestion = new AnswerQuestion()
        when:
            String expectResult = anserQuestion.fizzBuzzBang(0, condition)
        then:
            expectResult == ConditionStub.DEFINED_RESULT
    }

    def "Function return concated result from conditions"() {
        given:
            ConditionStub condition = new ConditionStub()
            ConditionStub condition1 = new ConditionStub()
            ConditionStub2 condition2 = new ConditionStub2()
        and:
            AnswerQuestion anserQuestion = new AnswerQuestion()
        when:
            String expectResult = anserQuestion.fizzBuzzBang(0, condition, condition1, condition2 )
        then:

            expectResult == condition.conditionResult() +
                            condition1.conditionResult() +
                            condition2.conditionResult()
    }

    def "Function update answered question number"() {
        given:
            int initialAnsweredQuestion = 111
            AnswerQuestion anserQuestion = new AnswerQuestion(initialAnsweredQuestion)
        when:
            anserQuestion.fizzBuzzBang(0, null )
            int answeredQuestions = anserQuestion.answeredQuestions()
        then:
            answeredQuestions == (initialAnsweredQuestion + 1)
    }

    def "Function return Bang for every 15 question"() {
        given:
            int initialAnsweredQuestion = 14
            AnswerQuestion anserQuestion = new AnswerQuestion(initialAnsweredQuestion)
        when:
            String result = anserQuestion.fizzBuzzBang(0, null )
        then:
            result == AnswerQuestion.message
    }


    def "Function remove duplicated conditions"() {

    }




    class ConditionStub implements Function<Integer, String>
    {

        final static String DEFINED_RESULT = "SomeString"

        String conditionResult(){
            return DEFINED_RESULT
        }

        @Override
        String apply(Integer integer) {
            return DEFINED_RESULT
        }
    }

    class ConditionStub2 extends ConditionStub{
        public final static String DEFINED_RESULT = "otherString"
    }
}

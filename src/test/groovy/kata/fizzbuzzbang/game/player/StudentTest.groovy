package kata.fizzbuzzbang.game.player

import kata.fizzbuzzbang.game.condition.GameCondition
import kata.fizzbuzzbang.game.condition.provider.ConditionProvider
import spock.lang.Specification


class StudentTest extends Specification {

    def conditionProvider, studentClass

    def gameConditionTrue, gameConditionFalse


    def NOT_IMPORTANT_STUDENT_NAME = "lechu"

    def ASKED_NUMBER = 5

    def ANSWER_1="answer1"

    def setup(){
        studentClass = Mock(StudentClass)

        gameConditionTrue = Mock(GameCondition){
            isConditionMet(ASKED_NUMBER) >> true
            message() >> ANSWER_1
        }

        gameConditionFalse = Mock(GameCondition){
            isConditionMet(ASKED_NUMBER) >> false
            message() >> ANSWER_1
        }



    }

    def "student answer this same number when no condition is met"() {
        given:
             conditionProvider = Mock(ConditionProvider){
                 askedNumberConditions(studentClass as StudentClass) >> Arrays.asList(gameConditionFalse as GameCondition)
             }
            Student student = new Student(conditionProvider, studentClass, NOT_IMPORTANT_STUDENT_NAME )

        when:
            def response = student.answerTheQuestion(ASKED_NUMBER)
        then:
            response == ASKED_NUMBER.toString()
    }

    def "student answer message using condition validator"() {
        given:
            conditionProvider = Mock(ConditionProvider){
                askedNumberConditions(studentClass as StudentClass) >> ( Arrays.asList(gameConditionTrue as GameCondition) )
            }
            Student student = new Student(conditionProvider, studentClass, NOT_IMPORTANT_STUDENT_NAME )

        when:
            student.answerTheQuestion(ASKED_NUMBER)
        then:
            1 * gameConditionTrue.isConditionMet(_ as Integer)
    }

    def "student answer message using condition message evaluator"() {
        given:
            conditionProvider = Mock(ConditionProvider){
                askedNumberConditions(studentClass as StudentClass) >> ( Arrays.asList(gameConditionTrue as GameCondition) )
            }
            Student student = new Student(conditionProvider, studentClass, NOT_IMPORTANT_STUDENT_NAME )

        when:
            student.answerTheQuestion(ASKED_NUMBER)
        then:
            1 * gameConditionTrue.message()
    }

    def "student answer with message from validator"() {
        given:
            conditionProvider = Mock(ConditionProvider){
                askedNumberConditions(studentClass as StudentClass) >> ( Arrays.asList(gameConditionTrue as GameCondition) )
            }
            Student student = new Student(conditionProvider, studentClass, NOT_IMPORTANT_STUDENT_NAME )

        when:
            def answer = student.answerTheQuestion(ASKED_NUMBER)
        then:
            answer == ANSWER_1
    }

    def "student answer with multiple message from validator, messages are separated by defined separator"() {
        given:
            conditionProvider = Mock(ConditionProvider){
                askedNumberConditions(studentClass as StudentClass) >> ( Arrays.asList(gameConditionTrue as GameCondition, gameConditionTrue as GameCondition) )
            }
            Student student = new Student(conditionProvider, studentClass, NOT_IMPORTANT_STUDENT_NAME )

        when:
            def answer = student.answerTheQuestion(ASKED_NUMBER)
        then:
            answer == (ANSWER_1+ Student.MESSAGE_SEPARATOR +ANSWER_1)
    }

}
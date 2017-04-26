package kata.fizzbuzzbang.game.condition.studentNumberConditions

import kata.fizzbuzzbang.game.condition.Condition
import kata.fizzbuzzbang.game.player.StudentClass
import spock.lang.Specification


class GameStudentNumberConditionTest extends Specification {

    private int NUMBER = 10

    def "condition is met when QuestionNumber in student class is divisible by defined number and game is extended type "() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isQuestionNumberDivisionBy (_) >> true
            }

            Condition divisible = new GameStudentNumberCondition(studentClass, NUMBER )
        when:
            def result = divisible.isConditionMet(NUMBER)
        then:
            result == true
    }

    def "condition is not met when QuestionNumber in student class is not divisible by defined number"() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isQuestionNumberDivisionBy(_ as Integer) >> false
            }

            Condition divisible = new GameStudentNumberCondition(studentClass, NUMBER)
        when:
            def result = divisible.isConditionMet(NUMBER)
        then:
            result == false
    }

    def "condition in checks use number provided in constructor"() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isQuestionNumberDivisionBy(_ as Integer) >> false
            }

            Condition divisible = new GameStudentNumberCondition(studentClass, NUMBER)
        when:
            divisible.isConditionMet(NUMBER)
        then:
            1 * studentClass.isQuestionNumberDivisionBy(NUMBER)
    }
}



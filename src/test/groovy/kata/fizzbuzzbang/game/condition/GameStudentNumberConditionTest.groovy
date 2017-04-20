package kata.fizzbuzzbang.game.condition

import kata.fizzbuzzbang.game.Answer
import kata.fizzbuzzbang.game.GameType
import kata.fizzbuzzbang.game.StudentClass
import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class GameStudentNumberConditionTest extends Specification {

    private int NUMBER = 10

    def "condition is met when QuestionNumber in student class is divisible by defined number and game is extended type "() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isNumberDivisionBy (_) >> true
            }

            GameCondition divisible = new GameStudentNumberCondition(studentClass, GameType.EXTENDED)
        when:
            print studentClass.isNumberDivisionBy(NUMBER)
            def result = divisible.isConditionMet(15)
        then:
            result == true
    }

    def "condition is not met when QuestionNumber in student class is not divisible by defined number"() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isNumberDivisionBy(_ as Integer) >> false
            }

            GameCondition divisible = new GameStudentNumberCondition(studentClass, GameType.EXTENDED)
        when:
            def result = divisible.isConditionMet(NUMBER)
        then:
            result == false
    }

    def "condition is not met when game is in Standard Type"() {
        given:
            StudentClass studentClass = Mock(StudentClass){
                isNumberDivisionBy(_ as Integer) >> true
            }

            GameCondition divisible = new GameStudentNumberCondition(studentClass, GameType.STANDARD)
        when:
            def result = divisible.isConditionMet(NUMBER)
        then:
            result == false
    }

    def "condition always return Bang message "() {
        given:
            GameCondition divisible = new GameStudentNumberCondition(Mock(StudentClass), GameType.EXTENDED)
        when:
            def message = divisible.message()
        then:
            message == Answer.BANG.message()
    }

}

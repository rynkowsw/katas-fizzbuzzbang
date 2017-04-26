package kata.fizzbuzzbang

import kata.fizzbuzzbang.game.player.Student
import kata.fizzbuzzbang.game.player.StudentClass
import spock.lang.Specification
/**
 * Created by wojciech on 25.04.17.
 */
class TeacherTest extends Specification {

    def student

    def studentClass

    def gameConfiguration

    def setup () {
        student = Mock(Student) {
            answerTheQuestion(_ as int) >> " "
        }

        studentClass = Mock(StudentClass) {
            randomStudentFromClass() >> student
        }

        gameConfiguration = Mock(GameConfiguration)
                {
                    defineNumberOfQuestions() >> 100
                    getMyClass() >> studentClass
                }
    }

    def "teacher ask student as many time as it is defined"() {
        given:
            Teacher teacher = new Teacher(gameConfiguration)
         when:
            teacher.playTheGame()
         then:
             100 * student.answerTheQuestion(*_)
    }

}

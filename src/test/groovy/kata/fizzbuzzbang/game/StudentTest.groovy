package kata.fizzbuzzbang.game

import kata.fizzbuzzbang.game.condition.GameCondition
import kata.fizzbuzzbang.game.condition.GameForFifteenCondition
import kata.fizzbuzzbang.game.condition.GameForFiveCondition
import kata.fizzbuzzbang.game.condition.GameForThreeCondition
import kata.fizzbuzzbang.game.condition.GameStudentNumberCondition
import spock.lang.Specification

/**
 * Created by wojciech on 18.04.17.
 */
class StudentTest extends Specification {


    private static GameType gameType

    private static StudentClass studentClass

    private static List<GameCondition> gameConditions

    private static List<Student> studentList

    private int NUMBER = 11
    def setup(){

        gameType = GameType.EXTENDED
        studentClass = new StudentClass()

        gameConditions = Arrays.asList(
                new GameForFiveCondition(gameType),
                new GameForThreeCondition(gameType),
                new GameForFifteenCondition(),
                new GameStudentNumberCondition(studentClass, gameType)
        )

        studentList = Arrays.asList(
                new Student(gameConditions,studentClass, "Jasiek")
        )

        studentClass.addStudents(studentList)
    }

    def "student answer correct answear for defined number"() {

        given:
            Player player = studentClass.getStudent()
        when:
            String answear = player.answerTheQuestion(135)
            print(answear)
        then:
            answear.contains(GameForFifteenCondition.MESSAGE.message()) &&
            answear.contains(GameForFiveCondition.EXTENDED_MESSAGE.message()) &&
            answear.contains(GameForThreeCondition.EXTENDED_MESSAGE.message()) &&
            answear == "My name is: Jasiek and answer for number 135 is: Mruu!,Pow!,FizzBuzz!"
    }

    def "student answer the same number for missed conditions"() {

        given:
            studentClass = new StudentClass()
            gameConditions = Arrays.asList()

            studentList = Arrays.asList(
                    new Student(gameConditions,studentClass, "Jasiek")
            )
            studentClass.addStudents(studentList)

            Player player = studentClass.getStudent()

        when:
            String answear = player.answerTheQuestion(NUMBER)
        then:
            answear.contains("""answer for number ${NUMBER} is: ${NUMBER}""")
    }

    def "student answer the same number all conditions are not met"() {

        given:
            studentClass = new StudentClass()
            gameConditions = Arrays.asList(Mock(GameForFifteenCondition){
                isConditionMet(_ as int) >> false
            }) as List<GameCondition>

            studentList = Arrays.asList(
                    new Student(gameConditions,studentClass, "Jasiek")
            )
            studentClass.addStudents(studentList)

            Player player = studentClass.getStudent()

        when:
            String answear = player.answerTheQuestion(NUMBER)
        then:
            answear.contains("""answer for number ${NUMBER} is: ${NUMBER}""")
    }
}

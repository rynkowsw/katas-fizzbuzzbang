package kata.fizzbuzzbang.game

import kata.fizzbuzzbang.game.condition.GameCondition
import spock.lang.Specification
/**
 * Created by wojciech on 18.04.17.
 */
class StudentClassTest extends Specification {


    def "student class keep last question number, and verify if is divided by defined number"() {
        given:
            StudentClass studentClass = new StudentClass()
        when:
            studentClass.nextQestion()
            studentClass.nextQestion()
        then:
            studentClass.isNumberDivisionBy(2)
        when:
            studentClass.nextQestion()
        then:
            studentClass.isNumberDivisionBy(3)
    }

    def "class returns one of studnet with are added to class"() {
        given:
            StudentClass studentClass = new StudentClass()
            GameCondition gameCondition = Mock(GameCondition)
            List<GameCondition> conditionList = Arrays.asList(gameCondition)

            List<Student> students  = Arrays.asList(
                    new Student(conditionList, studentClass, "Jasiek"),
                    new Student(conditionList, studentClass, "Zosia"),
                    new Student(conditionList, studentClass, "Basia")
            );

            studentClass.addStudents(students)
        when:

            List<Student> studentsFromClassWithRemovedDuplicates = new HashSet<Student>(
                    Arrays.asList(
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                        studentClass.getStudent(),
                    )).toList();

        then:
            students.containsAll(studentsFromClassWithRemovedDuplicates) == true &&
                    studentsFromClassWithRemovedDuplicates.size()>1 &&
                    studentsFromClassWithRemovedDuplicates.size() <= students.size()
    }
}

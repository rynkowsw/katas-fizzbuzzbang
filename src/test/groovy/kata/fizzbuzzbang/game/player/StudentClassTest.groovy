package kata.fizzbuzzbang.game.player

import spock.lang.Specification
/**
 * Created by wojciech on 26.04.17.
 */

class StudentClassTest extends Specification {


    def "student class keep how many questions appears, and verify if this number is divided by defined argument"() {
        given:
            StudentClass studentClass = new StudentClass()
        when:
            studentClass.nextQuestion()
            studentClass.nextQuestion()
        then:
            studentClass.isQuestionNumberDivisionBy(2)
        when:
            studentClass.nextQuestion()
        then:
            studentClass.isQuestionNumberDivisionBy(3)
    }

    def "class returns one of studnet with are added to class"() {
        given:
            StudentClass studentClass = new StudentClass()

            List<Student> students  = Arrays.asList(
                    Mock( Student),
                    Mock( Student),
                    Mock( Student)
            )

            studentClass.addStudents(students)

        when:

            List<Student> studentsFromClassWithRemovedDuplicates = new HashSet<Student>(
                    Arrays.asList(
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                            studentClass.randomStudentFromClass(),
                    )).toList();

        then:
            students.containsAll(studentsFromClassWithRemovedDuplicates) &&
                    studentsFromClassWithRemovedDuplicates.size() > 1 &&
                    studentsFromClassWithRemovedDuplicates.size() <= students.size()
    }
}

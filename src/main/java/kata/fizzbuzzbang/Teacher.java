package kata.fizzbuzzbang;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.Player;
import kata.fizzbuzzbang.game.StudentClass;
import kata.fizzbuzzbang.game.GameType;
import kata.fizzbuzzbang.game.Student;
import kata.fizzbuzzbang.game.condition.GameCondition;
import kata.fizzbuzzbang.game.condition.GameForFifteenCondition;
import kata.fizzbuzzbang.game.condition.GameForFiveCondition;
import kata.fizzbuzzbang.game.condition.GameForThreeCondition;
import kata.fizzbuzzbang.game.condition.GameStudentNumberCondition;

/**
 * Created by wojciech on 18.04.17.
 */
public class Teacher {

    private static GameType gameType = GameType.EXTENDED;

    private static List<GameCondition> defineGameConditions(StudentClass studentsClass){
        return Arrays.asList(
                new GameForFiveCondition(gameType),
                new GameForThreeCondition(gameType),
                new GameForFifteenCondition(),
                new GameStudentNumberCondition(studentsClass, gameType)
        );
    }

    private static void studentsInClass(List<GameCondition> gameConditions, StudentClass studentClass){

        List<Student> students  = Arrays.asList(
                new Student(gameConditions,studentClass, "Jasiek"),
                new Student(gameConditions,studentClass, "Zosia"),
                new Student(gameConditions,studentClass, "Kasia")
        );

        studentClass.addStudents(students);
    }

    public static void main(String[] args) {

        StudentClass studentClass = new StudentClass();
        List<GameCondition> gameConditions = defineGameConditions(studentClass);

        studentsInClass(gameConditions, studentClass);

        for (int i=1; i < 100 ; i++)
        {
            Player player = studentClass.randomStudentFromClass();
            System.out.println(player.answerTheQuestion(i));
        }
    }

}

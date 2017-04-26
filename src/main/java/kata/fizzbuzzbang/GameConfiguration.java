package kata.fizzbuzzbang;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.GameType;
import kata.fizzbuzzbang.game.condition.provider.ConditionProvider;
import kata.fizzbuzzbang.game.condition.provider.GameConditionProviderFactory;
import kata.fizzbuzzbang.game.player.Student;
import kata.fizzbuzzbang.game.player.StudentClass;


public class GameConfiguration {

    private GameType gameType;

    private int numberOfQuestions;

    private StudentClass studentClass;

    private GameConditionProviderFactory gameConditionProviderFactory;

    public GameConfiguration(){
        gameType = GameType.EXTENDED;
        numberOfQuestions = 100;
        studentClass = new StudentClass();
        gameConditionProviderFactory = new GameConditionProviderFactory();
        studentClass.addStudents( studentList(studentClass) );
    }

    private List<Student> studentList(StudentClass studentClass){

        ConditionProvider conditionProvider = conditionProvider();
        return Arrays.asList(
                new Student(conditionProvider, studentClass, "Jasiek"),
                new Student(conditionProvider, studentClass, "Zosia"),
                new Student(conditionProvider, studentClass, "Kasia")
        );
    }

    public StudentClass getMyClass(){
        return studentClass;
    }

    public int defineNumberOfQuestions(){
        return numberOfQuestions;
    }

    private ConditionProvider conditionProvider(){
        return  gameConditionProviderFactory.provideConditions(gameType);
    }
}

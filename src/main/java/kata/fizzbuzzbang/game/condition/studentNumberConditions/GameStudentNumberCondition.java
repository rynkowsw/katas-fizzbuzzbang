package kata.fizzbuzzbang.game.condition.studentNumberConditions;


import kata.fizzbuzzbang.game.player.StudentClass;
import kata.fizzbuzzbang.game.condition.Condition;


public class GameStudentNumberCondition implements Condition {

    private StudentClass studentClass;
    private Integer number;

    public GameStudentNumberCondition(StudentClass studentClass, Integer number){
        this.studentClass = studentClass;
        this.number = number;
    }

    @Override
    public boolean isConditionMet(int questionNumber) {

        boolean questionIsDivisibleByFifteen = ( studentClass.isQuestionNumberDivisionBy(number));

        return questionIsDivisibleByFifteen ;
    }
}

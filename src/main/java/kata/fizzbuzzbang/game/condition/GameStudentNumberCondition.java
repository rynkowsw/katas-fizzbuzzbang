package kata.fizzbuzzbang.game.condition;


import kata.fizzbuzzbang.game.Answer;
import kata.fizzbuzzbang.game.GameType;
import kata.fizzbuzzbang.game.StudentClass;

/**
 * Created by wojciech on 19.04.17.
 */
public class GameStudentNumberCondition implements GameCondition {

    public static final Answer MESSAGE = Answer.BANG;

    private StudentClass studentsClass;

    private boolean isExtendedGame;

    private int DIVIDER = 15;

    public GameStudentNumberCondition(StudentClass studentsClass,GameType type){
        this.studentsClass = studentsClass;
        this.isExtendedGame = type.isExtendedGame();
    }

    @Override
    public boolean isConditionMet(int questionNumber) {

        boolean questionIsDivisibleByFifteen = ( studentsClass.isNumberDivisionBy(DIVIDER));

        return (questionIsDivisibleByFifteen && isExtendedGame) ;
    }

    @Override
    public String message() {
        return MESSAGE.message();
    }
}

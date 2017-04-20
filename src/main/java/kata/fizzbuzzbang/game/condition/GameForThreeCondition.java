package kata.fizzbuzzbang.game.condition;

import kata.fizzbuzzbang.game.Answer;
import kata.fizzbuzzbang.game.GameType;

/**
 * Created by wojciech on 18.04.17.
 */
public class GameForThreeCondition implements GameCondition, GameDivisionCondition, GameContainCondition {

    public static final Answer STANDARD_MESSAGE = Answer.FIZZ;
    public static final Answer EXTENDED_MESSAGE = Answer.POW;

    private boolean isExtendedGame;

    public GameForThreeCondition(){
        isExtendedGame = GameType.STANDARD.isExtendedGame();
    }

    public GameForThreeCondition(GameType type){
        isExtendedGame = type.isExtendedGame();
    }

    @Override
    public boolean isConditionMet(int number) {

        int THREE = 3;
        boolean numberContainThree = isStringContainSubstring(String.valueOf(number) , String.valueOf(THREE));
        boolean numberIsDividedByThree = isNumberDivisibleByDivider(number, THREE);
        boolean numberIsDividedByFifteen = isNumberDivisibleByDivider(number, 15);

        boolean isConditionMet = ( ( numberContainThree && isExtendedGame) ||
                                   ( numberIsDividedByThree && !numberIsDividedByFifteen )
                                 );
        return isConditionMet;
    }

    @Override
    public String message() {
        Answer answer;

        if(isExtendedGame) {
            answer = EXTENDED_MESSAGE;
        }
        else{
            answer = STANDARD_MESSAGE;
        }

        return answer.message();
    }

}

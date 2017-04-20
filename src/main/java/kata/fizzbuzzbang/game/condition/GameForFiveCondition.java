package kata.fizzbuzzbang.game.condition;


import kata.fizzbuzzbang.game.Answer;
import kata.fizzbuzzbang.game.GameType;

/**
 * Created by wojciech on 18.04.17.
 */
public class GameForFiveCondition implements GameCondition, GameDivisionCondition, GameContainCondition {

    public static final Answer STANDARD_MESSAGE = Answer.BUZZ;
    public static final Answer EXTENDED_MESSAGE = Answer.MRUU;

    private boolean isExtendedGame;

    public GameForFiveCondition(){
        isExtendedGame = GameType.STANDARD.isExtendedGame();
    }

    public GameForFiveCondition(GameType type){
        isExtendedGame = type.isExtendedGame();
    }

    @Override
    public boolean isConditionMet(int number) {

        int FIVE = 5;
        boolean numberContainFive = isStringContainSubstring(String.valueOf(number), String.valueOf(FIVE));
        boolean numberIsDividedByFive = isNumberDivisibleByDivider(number, FIVE);
        boolean numberIsDividedByFifteen = isNumberDivisibleByDivider(number, 15);

        boolean isConditionMet = ( numberContainFive && isExtendedGame) ||
                                 ( numberIsDividedByFive && ! numberIsDividedByFifteen );

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

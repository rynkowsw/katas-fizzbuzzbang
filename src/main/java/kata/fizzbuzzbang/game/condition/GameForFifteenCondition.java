package kata.fizzbuzzbang.game.condition;


import kata.fizzbuzzbang.game.Answer;

/**
 * Created by wojciech on 18.04.17.
 */
public class GameForFifteenCondition implements GameCondition, GameDivisionCondition {

    public static final Answer MESSAGE = Answer.FIZZBUZZ;

    @Override
    public boolean isConditionMet(int number) {

        boolean numberIsDividedByFifteen = isNumberDivisibleByDivider(number, 15);

        return numberIsDividedByFifteen;
    }

    @Override
    public String message() {
        return MESSAGE.message();
    }
}

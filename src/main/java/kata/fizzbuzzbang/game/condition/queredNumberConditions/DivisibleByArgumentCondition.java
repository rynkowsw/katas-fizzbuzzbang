package kata.fizzbuzzbang.game.condition.queredNumberConditions;

import kata.fizzbuzzbang.game.condition.base.Condition;

/**
 * Created by wojciech on 24.04.17.
 */
public class DivisibleByArgumentCondition implements Condition {

    private final int divider;

    public DivisibleByArgumentCondition(int divider){
        this.divider = divider;
    }


    @Override
    public boolean isConditionMet(int number) {

        boolean numberIsDividedByFifteen = isNumberDivisibleByDivider(number, divider);
        return numberIsDividedByFifteen;
    }



    private boolean isNumberDivisibleByDivider(int number, int divider){
        return  restOfDivision(number, divider) == 0 ;
    }

    private int restOfDivision(int dividend, int divider){
        return dividend % divider;
    }
}

package kata.fizzbuzzbang.game.condition.queredNumberConditions;

import kata.fizzbuzzbang.game.condition.base.Condition;

/**
 * Created by wojciech on 24.04.17.
 */
public class ContainArgumentCondition implements Condition {

    private final int substringNumber;

    public ContainArgumentCondition(int substringNumber){
        this.substringNumber = substringNumber;
    }

    @Override
    public boolean isConditionMet(int number) {

        boolean stringContainSubstring = isStringContainSubstring(
                                        String.valueOf(number),
                                        String.valueOf(substringNumber)
                                        );

        return stringContainSubstring;
    }

    private boolean isStringContainSubstring(String base, String substring){
        return base.contains(substring);
    }

}

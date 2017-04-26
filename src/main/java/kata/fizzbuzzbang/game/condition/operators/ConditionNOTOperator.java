package kata.fizzbuzzbang.game.condition.operators;

import kata.fizzbuzzbang.game.condition.Condition;


public class ConditionNOTOperator implements Condition {

    private Condition condition;

    public ConditionNOTOperator(Condition condition){
        this.condition = condition;
    }

    @Override
    public boolean isConditionMet(int number) {
        return !condition.isConditionMet(number);
    }
}
package kata.fizzbuzzbang.game.condition.operators;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.condition.base.Condition;

/**
 * Created by wojciech on 18.04.17.
 */
public class ConditionAndOperator implements Condition {

    private List<Condition> conditions;


    public ConditionAndOperator(List<Condition> conditions){
        this.conditions = conditions;
    }

    public ConditionAndOperator(Condition firstCondition, Condition secondCondition ){
        this.conditions = Arrays.asList(firstCondition, secondCondition);
    }


    @Override
    public boolean isConditionMet(int number) {
        return conditions.stream()
                .allMatch(  condition -> condition.isConditionMet(number) );
    }
}
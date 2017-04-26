package kata.fizzbuzzbang.game.condition.operators;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.condition.base.Condition;

/**
 * Created by wojciech on 18.04.17.
 */
public class ConditionOrOperator implements Condition {


    private List<Condition> conditions;


    public ConditionOrOperator(List<Condition> conditions){
        this.conditions = conditions;
    }

    public ConditionOrOperator(Condition firstCondition, Condition secondCondition ){
        this.conditions = Arrays.asList(firstCondition, secondCondition);
    }


    @Override
    public boolean isConditionMet(int number) {
        return conditions.stream()
                .anyMatch( condition -> ( condition.isConditionMet(number) == true) );
    }
}
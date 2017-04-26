package kata.fizzbuzzbang.game.condition.provider;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.Answer;
import kata.fizzbuzzbang.game.player.StudentClass;
import kata.fizzbuzzbang.game.condition.GameCondition;
import kata.fizzbuzzbang.game.condition.GameConditionImpl;
import kata.fizzbuzzbang.game.condition.queredNumberConditions.DivisibleByArgumentCondition;
import kata.fizzbuzzbang.game.condition.operators.ConditionAndOperator;
import kata.fizzbuzzbang.game.condition.operators.ConditionNOTOperator;


public class StandardGameConditionProvider implements ConditionProvider {


    public List<GameCondition> askedNumberConditions(StudentClass studentClass){

        GameCondition gameConditionForNumber15 = new GameConditionImpl(new DivisibleByArgumentCondition(15), Answer.FIZZBUZZ);

        GameCondition gameConditionForNumber5 = new GameConditionImpl(
                        new ConditionAndOperator(
                                new DivisibleByArgumentCondition(5),
                                new ConditionNOTOperator(
                                        new DivisibleByArgumentCondition(15))
                        ),
                        Answer.BUZZ
        );

        GameCondition gameConditionForNumber3 = new GameConditionImpl(
                new ConditionAndOperator(
                        new DivisibleByArgumentCondition(3),
                        new ConditionNOTOperator(
                                new DivisibleByArgumentCondition(15)
                        )
                ),
                Answer.FIZZ
        );

        return Arrays.asList(gameConditionForNumber5, gameConditionForNumber3, gameConditionForNumber15);
    }

}

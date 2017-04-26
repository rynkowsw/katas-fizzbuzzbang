package kata.fizzbuzzbang.game.condition.provider;

import java.util.Arrays;
import java.util.List;

import kata.fizzbuzzbang.game.Answer;
import kata.fizzbuzzbang.game.player.StudentClass;
import kata.fizzbuzzbang.game.condition.queredNumberConditions.ContainArgumentCondition;
import kata.fizzbuzzbang.game.condition.base.GameCondition;
import kata.fizzbuzzbang.game.condition.base.GameConditionImpl;
import kata.fizzbuzzbang.game.condition.queredNumberConditions.DivisibleByArgumentCondition;
import kata.fizzbuzzbang.game.condition.operators.ConditionAndOperator;
import kata.fizzbuzzbang.game.condition.operators.ConditionNOTOperator;
import kata.fizzbuzzbang.game.condition.operators.ConditionOrOperator;
import kata.fizzbuzzbang.game.condition.studentNumberConditions.GameStudentNumberCondition;

/**
 * Created by wojciech on 25.04.17.
 */
public class ExtendedGameConditionProvider implements ConditionProvider {

    private final int FIVE = 5;
    private final int THREE = 3;
    private final int FIFTEEN = 5;

    public List<GameCondition> askedNumberConditions(StudentClass studentClass) {

        GameCondition gameConditionForNumber15 = new GameConditionImpl(new DivisibleByArgumentCondition(15), Answer.FIZZBUZZ);

        GameCondition gameConditionForNumber5 = new GameConditionImpl(
                new ConditionOrOperator(
                        new ConditionAndOperator(
                                new DivisibleByArgumentCondition(FIVE),
                                new ConditionNOTOperator(
                                        new DivisibleByArgumentCondition(FIFTEEN))
                        ),
                        new ContainArgumentCondition(FIVE)
                ),
                Answer.POW
        );

        GameCondition gameConditionForNumber3 = new GameConditionImpl(
                new ConditionOrOperator(
                        new ConditionAndOperator(
                                new DivisibleByArgumentCondition(THREE),
                                new ConditionNOTOperator(
                                        new DivisibleByArgumentCondition(FIFTEEN))
                        ),
                        new ContainArgumentCondition(THREE)
                ), Answer.MRUU
        );

        GameCondition gameConditionForStudentNumber15 = new GameConditionImpl(
                new GameStudentNumberCondition(studentClass, FIFTEEN),
                Answer.BANG
        );

        return Arrays.asList(
                gameConditionForNumber5,
                gameConditionForNumber3,
                gameConditionForNumber15,
                gameConditionForStudentNumber15
        );
    }

}

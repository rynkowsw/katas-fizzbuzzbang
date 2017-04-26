package kata.fizzbuzzbang.game.condition.provider;

import java.util.List;

import kata.fizzbuzzbang.game.player.StudentClass;
import kata.fizzbuzzbang.game.condition.base.GameCondition;

/**
 * Created by wojciech on 25.04.17.
 */
public interface ConditionProvider {

    List<GameCondition> askedNumberConditions(StudentClass studentClass);

}

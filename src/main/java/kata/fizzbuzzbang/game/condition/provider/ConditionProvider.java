package kata.fizzbuzzbang.game.condition.provider;

import java.util.List;

import kata.fizzbuzzbang.game.player.StudentClass;
import kata.fizzbuzzbang.game.condition.GameCondition;


public interface ConditionProvider {

    List<GameCondition> askedNumberConditions(StudentClass studentClass);

}

package kata.fizzbuzzbang.game.condition;

/**
 * Created by wojciech on 18.04.17.
 */
public interface GameCondition {

    boolean isConditionMet(int number);

    String message();
}
package kata.fizzbuzzbang.game.condition;

/**
 * Created by wojciech on 18.04.17.
 */
public interface GameContainCondition {

    default boolean isStringContainSubstring(String base, String substring){
        return base.contains(substring);
    }
}
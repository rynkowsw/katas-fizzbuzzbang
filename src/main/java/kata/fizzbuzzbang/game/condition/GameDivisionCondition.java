package kata.fizzbuzzbang.game.condition;

/**
 * Created by wojciech on 18.04.17.
 */
public interface GameDivisionCondition {

    default boolean isNumberDivisibleByDivider(int number, int divider){
        return  restOfDivision(number, divider) == 0 ;
    }

    default int restOfDivision(int dividend, int divider){
        return dividend % divider;
    }

}
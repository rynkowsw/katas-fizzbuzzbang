package kata.fizzbuzbang2.conditions;

/**
 * Created by wojciech on 03.07.17.
 */
public class ThreeCondition implements Condition {

    public static final String message = "Fizz";

    private final int priority = 1;

    @Override
    public int getPriority(){
        return priority;
    }

    @Override
    public String apply(Integer integer) {
        if (integer != null && integer % 3 == 0)
            return message;

        return "";
    }
}

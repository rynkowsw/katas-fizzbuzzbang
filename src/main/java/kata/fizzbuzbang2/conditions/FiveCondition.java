package kata.fizzbuzbang2.conditions;

/**
 * Created by wojciech on 03.07.17.
 */
public class FiveCondition implements Condition {

    public static final String message = "Buzz";

    private final int priority = 2;

    @Override
    public int getPriority(){
        return priority;
    }

    @Override
    public String apply(Integer integer) {
        if( integer!=null && integer % 5 == 0 )
            return message;

        return "";
    }


}

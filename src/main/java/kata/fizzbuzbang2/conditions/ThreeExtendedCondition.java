package kata.fizzbuzbang2.conditions;

/**
 * Created by wojciech on 03.07.17.
 */
public class ThreeExtendedCondition implements Condition {
    public static final String message = "Pow";

    @Override
    public String apply(Integer integer) {
        if( numberIsDInvisibleByThree(integer) || stringContainThree(integer))
            return message;
        return "";
    }

    private boolean numberIsDInvisibleByThree(Integer integer) {
        if( integer!=null && integer % 3 == 0 )
            return true;
        return false;
    }

    private boolean stringContainThree(Integer integer){
        String givenNumberAsString = String.valueOf(integer);
        return givenNumberAsString.contains("3");
    }

}

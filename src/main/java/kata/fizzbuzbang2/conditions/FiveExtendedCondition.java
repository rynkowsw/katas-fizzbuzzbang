package kata.fizzbuzbang2.conditions;

/**
 * Created by wojciech on 03.07.17.
 */
public class FiveExtendedCondition implements Condition {

    public static final String message = "Mrru";

    @Override
    public String apply(Integer integer) {
        if( numberIsDIvisibleByFive(integer) || stringContainFive(integer))
            return message;
        return "";
    }


    private boolean numberIsDIvisibleByFive(Integer integer) {
        if( integer!=null && integer % 5 == 0 )
            return true;
        return false;
    }

    private boolean stringContainFive(Integer integer){
        String givenNumberAsString = String.valueOf(integer);
        return givenNumberAsString.contains("5");
    }



}

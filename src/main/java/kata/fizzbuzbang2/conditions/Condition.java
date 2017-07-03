package kata.fizzbuzbang2.conditions;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by wojciech on 03.07.17.
 */
public interface Condition extends Function<Integer, String> {

    Comparator<Object> CONDITION_PRIORITY_COMPARATOR = (o1, o2) -> {

        if (o1 instanceof Condition && o2 instanceof Condition) {
            if( ((Condition)o1).getPriority() < ((Condition)o2).getPriority())
                return -1;
            else if ( ((Condition)o1).getPriority() > ((Condition)o2).getPriority())
                return 1;
        }
        return 0;
    };

    default int getPriority(){
        return 0;
    }


}

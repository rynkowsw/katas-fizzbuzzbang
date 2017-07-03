package kata.fizzbuzbang2;

import java.util.Arrays;
import java.util.function.Function;

import kata.fizzbuzbang2.conditions.Condition;

/**
 * Created by wojciech on 03.07.17.
 */
public class AnswerQuestion {

    static String message = "Bang";

    private int questionNumber = 0;

    public AnswerQuestion(){}

    public AnswerQuestion(int questionAnswered){
        this.questionNumber = questionAnswered;
    }

    public String fizzBuzzBang(int number, Function<Integer, String> ... conditions  ){

        StringBuilder result = new StringBuilder();

        if( questionNumberIsDivisibleByFifteen() )
            result.append(message);

        result.append(conditionApply(number, conditions));

        return result.toString();
    }


    private boolean questionNumberIsDivisibleByFifteen(){
        questionNumber++;

        return questionNumber % 15 == 0;
    }



    private String conditionApply(int number, Function<Integer, String> conditions [] ){

        if( conditions == null )
            return "";

        return Arrays.stream(conditions)
                .sorted( Condition.CONDITION_PRIORITY_COMPARATOR)
                .map(s -> s.apply(number))
                .reduce((s, s2) -> s + s2)
                .orElse("");
    }

    public int answeredQuestions() {
        return questionNumber;
    }
}

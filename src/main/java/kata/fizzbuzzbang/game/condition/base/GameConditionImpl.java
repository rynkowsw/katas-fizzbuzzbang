package kata.fizzbuzzbang.game.condition.base;

import kata.fizzbuzzbang.game.Answer;

/**
 * Created by wojciech on 25.04.17.
 */
public class GameConditionImpl implements GameCondition {

    private Condition condition;
    private Answer answer;

    public GameConditionImpl(Condition condition, Answer answer) {
        this.condition = condition;
        this.answer = answer;
    }

    @Override
    public boolean isConditionMet(int number) {
        return condition.isConditionMet(number);
    }

    @Override
    public String message() {
        return answer.message();
    }
}

package kata.fizzbuzzbang.game.condition;

import kata.fizzbuzzbang.game.Answer;


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

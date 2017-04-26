package kata.fizzbuzzbang.game.player;

import java.util.List;
import java.util.stream.Collectors;

import kata.fizzbuzzbang.game.condition.provider.ConditionProvider;
import kata.fizzbuzzbang.game.condition.GameCondition;


public class Student implements Player {

    private List<GameCondition> gameConditions;

    private StudentClass studentClass;

    private String name;

    protected static final String MESSAGE_SEPARATOR = ",";

    public Student(ConditionProvider conditionProvider, StudentClass studentClass, String name){

        this.studentClass = studentClass;
        this.gameConditions = conditionProvider.askedNumberConditions(studentClass);
        this.name = name;
    }

    public  String answerTheQuestion( int questedNumber) {

        studentClass.nextQuestion();

        String answerMessage = gameConditions.stream()
                .filter(condition -> condition.isConditionMet(questedNumber))
                .map(GameCondition::message)
                .collect(Collectors.joining(MESSAGE_SEPARATOR));

        if( answerMessage.isEmpty() ) {
            answerMessage = String.valueOf(questedNumber);
        }

        return answerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (gameConditions != null ? !gameConditions.equals(student.gameConditions) : student.gameConditions != null)
            return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = gameConditions != null ? gameConditions.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

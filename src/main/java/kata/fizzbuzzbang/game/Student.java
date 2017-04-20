package kata.fizzbuzzbang.game;

import java.util.List;
import java.util.stream.Collectors;

import kata.fizzbuzzbang.game.condition.GameCondition;

/**
 * Created by wojciech on 18.04.17.
 */

public class Student implements Player{

    private List<GameCondition> divisibleConditions;
    private StudentClass studentClass;
    private String name;

    public Student( List<GameCondition> divisibleConditions, StudentClass studentClass, String name){
        this.divisibleConditions = divisibleConditions;
        this.studentClass = studentClass;
        this.name = name;
    }

    public  String answerTheQuestion( int questedNumber) {

        studentClass.nextQuestion();

        String answerMessage = divisibleConditions.stream()
                .filter(condition -> condition.isConditionMet(questedNumber))
                .map(GameCondition::message)
                .collect(Collectors.joining(","));

        if( answerMessage.isEmpty() ) {
            answerMessage = String.valueOf(questedNumber);
        }

        return "My name is: " + name+ " and answer for number "+ questedNumber +" is: "+ answerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (divisibleConditions != null ? !divisibleConditions.equals(student.divisibleConditions) : student.divisibleConditions != null)
            return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = divisibleConditions != null ? divisibleConditions.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

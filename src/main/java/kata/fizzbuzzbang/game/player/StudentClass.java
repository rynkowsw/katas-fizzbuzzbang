package kata.fizzbuzzbang.game.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StudentClass {

    private int numberOfQuestions;

    private List<Student> studentList;

    private Random rand;

    public StudentClass(){
        this.studentList = new ArrayList<>();
        this.rand = new Random();
        numberOfQuestions = 0;
    }

    public void addStudents(List<Student> studentList){
        this.studentList.addAll(studentList);
    }

    public Student randomStudentFromClass(){
        return studentList.get(randomStudentNumber());
    }


    public void nextQuestion(){
        numberOfQuestions++;
    }

    public boolean isQuestionNumberDivisionBy(int number){ return (numberOfQuestions % number == 0); }


    private int randomStudentNumber(){
        return rand.nextInt(studentList.size());
    }


}

package kata.fizzbuzzbang.game;

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


    private int getRandomStudentNumber(){
        return rand.nextInt(studentList.size());
    }

    public void addStudents(List<Student> studentList){
        this.studentList.addAll(studentList);
    }

    public Student getStudent(){
        return studentList.get(getRandomStudentNumber());
    }



    public void nextQuestion(){
        numberOfQuestions++;
    }

    public boolean isNumberDivisionBy(int number){ return (numberOfQuestions % number == 0); }



}

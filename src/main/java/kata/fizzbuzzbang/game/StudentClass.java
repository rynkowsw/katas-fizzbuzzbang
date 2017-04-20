package kata.fizzbuzzbang.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentClass {

    private int numberOfQestion = 0;

    private List<Student> studentList;

    private Random rand = new Random();

    public StudentClass(){
        this.studentList = new ArrayList<>();
        this.rand = new Random();
    }

    public void addStudents(List<Student> studentList){
        this.studentList.addAll(studentList);
    }

    public Student getStudent(){
        return studentList.get(getRandomStudentNumber());
    }

    public void nextQestion(){
        numberOfQestion++;
    }

    public boolean isNumberDivisionBy(int number){

        return (numberOfQestion % number == 0);
    }

    private int getRandomStudentNumber(){
        return rand.nextInt(studentList.size());
    }

}

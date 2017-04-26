package kata.fizzbuzzbang;

import kata.fizzbuzzbang.game.player.Student;
import kata.fizzbuzzbang.game.player.StudentClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Teacher {

    final static Logger logger = LoggerFactory.getLogger(Teacher.class);

    private StudentClass studentClass;

    private GameConfiguration gameConfiguration;

    public Teacher(GameConfiguration gameConfiguration)
    {
        this.gameConfiguration = gameConfiguration;
    }


    protected void setupTheGame(){
        studentClass  = gameConfiguration.getMyClass();
    }

    protected void playTheGame(){
        setupTheGame();

        for (int i = 1; i <= gameConfiguration.defineNumberOfQuestions() ; i++)
        {
            Student player = studentClass.randomStudentFromClass();
            String answer = player.answerTheQuestion(i);

            logger.info(answer);
        }
    }

    public static void main(String[] args) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        Teacher teacher = new Teacher(gameConfiguration);
        teacher.playTheGame();
    }

}
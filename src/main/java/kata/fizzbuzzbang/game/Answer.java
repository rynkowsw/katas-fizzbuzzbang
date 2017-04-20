package kata.fizzbuzzbang.game;

/**
 * Created by wojciech on 18.04.17.
 */

public enum Answer {

    POW ( "Pow!"),
    BANG ( "BANG!"),
    MRUU ("Mruu!"),
    FIZZ ("Fizz!"),
    BUZZ ("Buzz!"),
    FIZZBUZZ ("FizzBuzz!");

    private final String message;

    Answer( String message) {
        this.message = message;
    }

    public String message(){ return message;}

}

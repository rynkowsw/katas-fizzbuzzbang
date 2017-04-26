package kata.fizzbuzzbang.game;


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

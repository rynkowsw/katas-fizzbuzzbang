package kata.fizzbuzzbang.game;


public enum GameType {

    STANDARD("STANDARD"),
    EXTENDED("EXTENDED");

    private final String gameType;

    GameType( String gameType) {
        this.gameType = gameType;
    }

}

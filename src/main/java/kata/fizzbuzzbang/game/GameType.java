package kata.fizzbuzzbang.game;

/**
 * Created by wojciech on 18.04.17.
 */
public enum GameType {

    STANDARD("STANDARD"),
    EXTENDED("EXTENDED");

    private final String gameType;

    GameType( String gameType) {
        this.gameType = gameType;
    }

}

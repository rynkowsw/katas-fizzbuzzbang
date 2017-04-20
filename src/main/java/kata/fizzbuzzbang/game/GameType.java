package kata.fizzbuzzbang.game;

/**
 * Created by wojciech on 18.04.17.
 */
public enum GameType {

    STANDARD(false),
    EXTENDED(true);

    private final Boolean gameType;

    GameType( Boolean gameType) {
        this.gameType = gameType;
    }

    public Boolean isExtendedGame(){ return gameType;}

}

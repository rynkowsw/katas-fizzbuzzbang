package kata.fizzbuzzbang.game.condition.provider;

import kata.fizzbuzzbang.game.GameType;

/**
 * Created by wojciech on 25.04.17.
 */

public class GameConditionProviderFactory {

    private StandardGameConditionProvider standardGameConditionProvider;

    private ExtendedGameConditionProvider extendedGameConditionProvider;

    public GameConditionProviderFactory(){
        standardGameConditionProvider = new StandardGameConditionProvider();
        extendedGameConditionProvider = new ExtendedGameConditionProvider();
    }


    public ConditionProvider provideConditions(GameType gameType) {

        ConditionProvider conditionProvider;

        switch (gameType) {
            case STANDARD:
                conditionProvider = standardGameConditionProvider;
                break;

            case EXTENDED:
                conditionProvider = extendedGameConditionProvider;
                break;

            default:
                throw new RuntimeException("Game condition provider not found in GameConditionProviderFactory");
        }

        return conditionProvider;

    }
}

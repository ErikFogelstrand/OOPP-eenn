package Model.World;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameSceneManager {
    private static final GameSceneManager GAME_SCENE_MANAGER = new GameSceneManager();
    private final Map<String, GameScene> gameSceneMap = new HashMap<>();
    private String activeGameScene;

    private GameSceneManager(){}
    public static GameSceneManager getInstance(){
        return GAME_SCENE_MANAGER;
    }
    public GameScene getActiveGameScene(){
        if (!gameSceneMap.containsKey(activeGameScene)){
            return null;
        }
        return gameSceneMap.get(activeGameScene);
    }
    public Set<String> getKeys(){
        return gameSceneMap.keySet();
    }
    public void switchActiveGameScene(String gameSceneKey){
        if (!getKeys().contains(gameSceneKey)){
            return;
        }
        activeGameScene = gameSceneKey;
    }
    public void addGameScene(String gameSceneKey, GameScene gameScene){
        gameSceneMap.put(gameSceneKey, gameScene);
    }

}

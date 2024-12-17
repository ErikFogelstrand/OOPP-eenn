package World;

public class GameSceneCreator {
    public static GameScene createGameScene(int x, int y){
        GameScene gameScene = new GameScene(x, y);
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                Tile newTile = TileFactory.getInstance().createTile("Dirt", "");
                gameScene.insertTile(newTile, x, y);
            }
        }
        return gameScene;
    }
}
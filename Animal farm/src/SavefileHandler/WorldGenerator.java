package SavefileHandler;

import World.GameScene;
import World.Tile;
import World.TileFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorldGenerator {
    private static final TileFactory tileFactory = TileFactory.getInstance();

// Första line:en håller i höjden och bredden av GameScene:en
// Varje line efter håller i [tileType, tileObject]
    public static GameScene generateGameScene(String fileName){

        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            if(!scanner.hasNextLine()){
                return null;
            }
            String[] initialize = scanner.nextLine().split(",");
            int x = Integer.parseInt(initialize[0]);
            int y = Integer.parseInt(initialize[1]);
            GameScene gameScene = new GameScene(x, y);

            for(int i = 0; i <= x*y; i++){
                if(!scanner.hasNextLine()){
                    break;
                }
                String[] nextTileData = scanner.nextLine().split(",");
                Tile nextTile = tileFactory.createTile(nextTileData[0], nextTileData[1]);
                gameScene.insertTile(nextTile,i%y, i/y);
            }
            return gameScene;
        } catch (FileNotFoundException e) {
            System.out.println("File not found ;( :" + fileName);
        }
        return null;
    }
}




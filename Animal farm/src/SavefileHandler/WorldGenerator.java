package SavefileHandler;


import World.Tile;
import World.TileFactory;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class WorldGenerator {

    private static TileFactory tileFactory = TileFactory.getInstance();
    private int[][] mapTileNum;


// Första line:en håller i höjden och bredden av GameScene:en
// Varje line efter håller i [tileType, tileObject]


    /*
    public static GameScene generateGameScene(String fileName){

            String[] initialize = scanner.nextLine().split(",");
            int x = Integer.parseInt(initialize[0]);
            int y = Integer.parseInt(initialize[1]);
            GameScene gameScene = new GameScene(x, y);

            for(int i = 0; i <= x*y; i++){
                if(!.hasNextLine()){
                    break;
                }
                String[] nextTileData = scanner.nextLine().split(",");
                Tile nextTile = tileFactory.createTile(nextTileData[0], nextTileData[1]);
                gameScene.insertTile(nextTile,i%y, i/y);
            }
            return gameScene;

        }
        return null;
    }

     */


}



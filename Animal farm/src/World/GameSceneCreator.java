package World;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GameSceneCreator {
    public static GameScene createGameScene(int x, int y){
        HashMap<Integer, String> tileHashMap = new HashMap<>();
        tileHashMap.put(0, "Grass");
        tileHashMap.put(1, "Dirt");
        tileHashMap.put(2, "PlantableDirt");

        GameScene gameScene = new GameScene(x, y);

        try {
            InputStream txt = gameScene.getClass().getClassLoader().getResourceAsStream("World/tileMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(txt));

            int col = 0;
            int row = 0;

            while (col < x && row < y) {

                String line = br.readLine();

                while (col < x) {

                    String[] numbers = line.split(" "); // gives number[x] = 1/2/3/4 = tiletype
                    //String[] seperateNumbers = line.split(","); // if we want to save the objects

                    int numTile = Character.getNumericValue((numbers[col]).charAt(0)); // string -> int
                    //int numObj = Character.getNumericValue((numbers[col]).charAt(1)); // string -> int

                    gameScene.getMatrix()[row][col] = numTile;
                    gameScene.insertTile(TileFactory.getInstance().createTile(tileHashMap.get(numTile), ""), row, col); //null is the object but should be fixed

                    col++;

                }
                if (col == x) {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("erroor");
        }

        return gameScene;
    }
}

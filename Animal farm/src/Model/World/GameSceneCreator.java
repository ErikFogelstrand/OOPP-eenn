package Model.World;

import Model.World.TileFactories.TileFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GameSceneCreator {
    public static GameScene createGameScene(int sizeX, int sizeY){
        HashMap<Integer, String> tileHashMap = new HashMap<>();
        tileHashMap.put(0, "Grass");
        tileHashMap.put(1, "Dirt");
        tileHashMap.put(2, "PlantableDirt");
        tileHashMap.put(3, "Home");

        GameScene gameScene = new GameScene(sizeX, sizeY);

        try {
            InputStream txt = gameScene.getClass().getClassLoader().getResourceAsStream("Model/World/tileMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(txt));

            for (int y = 0; y < sizeY; y++) {

                String line = br.readLine();

                for (int x = 0; x < sizeX; x++) {

                    String[] numbers = line.split(" "); // gives array of a row (e.g [0, 2, 1, 2, 0, 2])

                    int numTile = Character.getNumericValue((numbers[x]).charAt(0)); // string -> int
                    gameScene.insertTile(TileFactory.getInstance().createTile(tileHashMap.get(numTile), ""), x, y); //null is the object but should be fixed
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("erroor");
        }

        return gameScene;
    }
}

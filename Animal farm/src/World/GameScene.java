package World;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class GameScene implements ICurrentGameScene {
    private Tile[][] tileMatrix;
    private int[][] numMatrix;
    TileFactory tileFactory = new TileFactory();


    int maxRow;
    int maxCol;

    HashMap<Integer, String> tileHashMap = new HashMap<>(); //to convert num to string

    private void setTileHashMap(){
        tileHashMap.put(0, "Grass");
        tileHashMap.put(1, "Dirt");
        tileHashMap.put(2, "PlantableDirt");
    }

    public GameScene(int maxCol, int maxRow) {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        tileMatrix = new Tile[maxRow][maxCol];
        numMatrix = new int[maxRow][maxCol];

        setTileHashMap();
    }

    public void insertTile(Tile tile, int row, int col) {
        tileMatrix[row][col] = tile;

    }

    public Tile getTile(int col, int row) {

        return tileMatrix[row][col]; //temp solution
    }

    public int[][] getMatrix(){
        return numMatrix;
    }
}
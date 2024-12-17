package World;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class GameScene implements ICurrentGameScene {
    private Tile[][] tileMatrix;
    private int[][] numMatrix;
    TileFactory tileFactory = new TileFactory();
    public static GameScene gameScene;


    int maxRow;
    int maxCol;

    HashMap<Integer, String> tileHashMap = new HashMap<>(); //to convert num to string

    private void setTileHashMap(){
        tileHashMap.put(0, "Grass");
        tileHashMap.put(1, "Dirt");
        tileHashMap.put(2, "PlantableDirt");
    }

    private GameScene(int maxRow, int maxCol) {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        tileMatrix = new Tile[maxRow][maxCol];
        numMatrix = new int[maxRow][maxCol];
        setTileHashMap();
    }

    // method to access the singleton instance
    public static GameScene getInstance(int maxRow, int maxCol) {
        if (gameScene == null) {
            gameScene = new GameScene(maxRow, maxCol);
        }
        return gameScene;
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


    public void loadMap() {


        try {
            InputStream txt = getClass().getClassLoader().getResourceAsStream("World/tileMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(txt));

            int col = 0;
            int row = 0;

            while (col < maxCol && row < maxRow) {

                String line = br.readLine();

                while (col < maxCol) {

                    String[] numbers = line.split(" "); // gives number[x] = 1/2/3/4 = tiletype
                    //String[] seperateNumbers = line.split(","); // if we want to save the objects

                    int numTile = Character.getNumericValue((numbers[col]).charAt(0)); // string -> int
                    //int numObj = Character.getNumericValue((numbers[col]).charAt(1)); // string -> int


                    numMatrix[row][col] = numTile;
                    tileMatrix[row][col] = tileFactory.createTile(tileHashMap.get(numTile), "null"); //null is the object but should be fixed

                    insertTile(tileMatrix[row][col], row, col);

                    col++;

                    }
                if (col == maxCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("erroor");
        }
    }
}
package World;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class GameScene {
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

    public GameScene(int maxRow, int maxCol) {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        tileMatrix = new Tile[maxRow][maxCol];
        numMatrix = new int[maxRow][maxCol];
        setTileHashMap();
    }


    public void insertTile(Tile tile, int row, int col) {
        tileMatrix[row][col] = tile;

    }

    public Tile getTile(int row, int col) {
        return tileMatrix[row][col];
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
                    //System.out.println(tileMatrix[row][col]);

                    insertTile(tileMatrix[row][col], row, col);
                    //System.out.println(col);

                    col++;
                    //System.out.println(numTile);

                    }
                if (col == maxCol) {
                    col = 0;
                    //System.out.println(row);
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("erroor");
        }
    }
}
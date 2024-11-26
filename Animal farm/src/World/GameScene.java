package World;

public class GameScene {
    private Tile[][] tileMatrix;

    public GameScene(int x, int y) {
        tileMatrix = new Tile[x][y];
    }

    public void insertTile(Tile tile, int x, int y) {
        tileMatrix[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return tileMatrix[x][y];
    }
}

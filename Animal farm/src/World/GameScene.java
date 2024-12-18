package World;

import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.reflect.Array;

public class GameScene implements ICurrentGameScene {
    private Tile[][] tileMatrix;
    private int[][] numMatrix;

    public GameScene(int x, int y) {
        tileMatrix = new Tile[y][x];
        numMatrix = new int[y][x];
    }

    public Point getSize(){
        return new Point(tileMatrix[0].length, tileMatrix.length);
    }

    public void insertTile(Tile tile, int x, int y) {
        tileMatrix[y][x] = tile;
    }

    public Tile getTile(int x, int y) {
        return tileMatrix[y][x]; //temp solution
    }

    public int[][] getMatrix(){
        return numMatrix;
    }
}
package Model.World;

import java.awt.*;

// Represents a screen with tiles
public class GameScene {
    private final Tile[][] tileMatrix;

    public GameScene(int x, int y) {
        tileMatrix = new Tile[y][x];
    }

    public Point getSize(){
        return new Point(tileMatrix[0].length, tileMatrix.length);
    }

    public void insertTile(Tile tile, int x, int y) {
        tileMatrix[y][x] = tile;
    }

    public Tile getTile(int x, int y) {
        return tileMatrix[y][x];
    }
}
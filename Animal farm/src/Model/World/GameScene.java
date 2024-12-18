package Model.World;

import java.awt.*;

public class GameScene implements ICurrentGameScene {
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

    @Override
    public Tile getTile(int x, int y) {
        return tileMatrix[y][x];
    }
}
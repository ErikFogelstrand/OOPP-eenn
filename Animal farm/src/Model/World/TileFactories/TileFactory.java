package Model.World.TileFactories;

import Model.World.Tile;
import Model.World.TileTypes.ATileType;

public class TileFactory {
    private static final TileFactory instance = new TileFactory();

    private final TileTypeFactory tileTypeFactory = TileTypeFactory.getInstance();

    public static TileFactory getInstance() {return instance;}

    public Tile createTile(String tileType, String tileObject) {
        ATileType newTileType = tileTypeFactory.createTileType(tileType, tileObject);
        return new Tile(newTileType);
    }
}
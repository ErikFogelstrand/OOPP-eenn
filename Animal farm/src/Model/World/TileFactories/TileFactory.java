package Model.World.TileFactories;

import Model.World.Tile;
import Model.World.Terrain.ATerrain;

public class TileFactory {
    // singleton instance
    private static final TileFactory instance = new TileFactory();

    private final TerrainFactory terrainFactory = TerrainFactory.getInstance();

    public static TileFactory getInstance() {return instance;}

    public Tile createTile(String tileType, String tileObject) {
        ATerrain newTileType = terrainFactory.createTileType(tileType, tileObject);
        return new Tile(newTileType);
    }
}

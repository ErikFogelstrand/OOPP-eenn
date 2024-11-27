package World;

public class TileFactory {
    public static Tile createTile(String tileType, String tileObject) {
        ITileObject newTileObject = TileObjectFactory.createTileObject(tileObject);
        ITileType newTileType = TileTypeFactory.createTileType(tileType);

        if((newTileObject instanceof APlantable) && (newTileType instanceof PlantableDirt)) {
            ((APlantable) newTileObject).setWaterableTile((PlantableDirt) newTileType);
        }

        return new Tile(newTileObject, newTileType);
    }
}

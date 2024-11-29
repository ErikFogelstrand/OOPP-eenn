package World;

import Jagbehöverettpaketförattnåklasserna.RandomTickGenerator;
import World.TileObjects.APlantable;
import World.TileTypes.PlantableDirt;
import World.TileObjects.APlantable;

public class TileFactory {
    private static final TileFactory instance = new TileFactory();

    private final TileObjectFactory tileObjectFactory = TileObjectFactory.getInstance();
    private final TileTypeFactory tileTypeFactory = TileTypeFactory.getInstance();

    private RandomTickGenerator generator = RandomTickGenerator.getInstance();

    public static TileFactory getInstance() {return instance;}

    public Tile createTile(String tileType, String tileObject) {
        ITileObject newTileObject = tileObjectFactory.createTileObject(tileObject);
        ITileType newTileType = tileTypeFactory.createTileType(tileType);

        if((newTileObject instanceof APlantable) && (newTileType instanceof PlantableDirt)) {
            ((APlantable) newTileObject).setWaterableTile((PlantableDirt) newTileType);
            generator.addListener((IRandomTickListener) newTileObject);
        }

        return new Tile(newTileObject, newTileType);
    }
}

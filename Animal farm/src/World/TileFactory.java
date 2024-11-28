package World;

import Jagbehöverettpaketförattnåklasserna.RandomTickGenerator;
import World.TileTypes.PlantableDirt;

public class TileFactory {
    private RandomTickGenerator generator; //Singleton


    public Tile createTile(String tileType, String tileObject) {
        ITileObject newTileObject = TileObjectFactory.createTileObject(tileObject);
        ITileType newTileType = TileTypeFactory.createTileType(tileType);

        if((newTileObject instanceof APlantable) && (newTileType instanceof PlantableDirt)) {
            ((APlantable) newTileObject).setWaterableTile((PlantableDirt) newTileType);
            generator.addListener((IRandomTickListener) newTileObject);
        }

        return new Tile(newTileObject, newTileType);
    }
}

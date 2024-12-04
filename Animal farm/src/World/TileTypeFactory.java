package World;

import World.TileObjects.APlantable;
import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;

public class TileTypeFactory {
    private static final TileTypeFactory instance = new TileTypeFactory();

    private final TileObjectFactory tileObjectFactory = TileObjectFactory.getInstance();

    public static TileTypeFactory getInstance() {return instance;}

    public ATileType createTileType(String tileType, String tileObject){
        ATileType newTileType = null;
        switch (tileType){
            case "Dirt":
                newTileType = new Dirt();
            case "Grass":
                newTileType = new Grass();
            case "PlantableDirt":
                newTileType = new PlantableDirt();
        }
        if(newTileType != null){
            newTileType.setTileObject(tileObjectFactory.createTileObject(tileObject));
        }
        return newTileType;


    }

}

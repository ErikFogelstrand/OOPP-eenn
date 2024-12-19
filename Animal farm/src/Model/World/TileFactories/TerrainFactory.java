package Model.World.TileFactories;

import Model.World.Terrain.ATerrain;
import Model.World.Terrain.Dirt;
import Model.World.Terrain.Grass;
import Model.World.Terrain.PlantableDirt;

public class TerrainFactory {
    private static final TerrainFactory instance = new TerrainFactory();

    private final TileObjectFactory tileObjectFactory = TileObjectFactory.getInstance();

    public static TerrainFactory getInstance() {return instance;}

    public ATerrain createTileType(String tileType, String tileObject){
        ATerrain newTileType = null;
        switch (tileType){
            case "Dirt":
                newTileType = new Dirt(); break;
            case "Grass":
                newTileType = new Grass(); break;
            case "PlantableDirt":
                newTileType = new PlantableDirt(); break;
        }
        if(newTileType != null){
            newTileType.setTileObject(tileObjectFactory.createTileObject(tileObject));
        }
        return newTileType;


    }

}

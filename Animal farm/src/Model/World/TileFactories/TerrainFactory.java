package Model.World.TileFactories;

import Model.World.Terrain.*;

public class TerrainFactory {
    // singleton instance
    private static final TerrainFactory instance = new TerrainFactory();

    private final TileObjectFactory tileObjectFactory = TileObjectFactory.getInstance();

    public static TerrainFactory getInstance() {return instance;}

    // Creates a terrain with a specified tileObject
    public ATerrain createTileType(String tileType, String tileObject){
        ATerrain newTileType = null;
        switch (tileType){
            case "Dirt":
                newTileType = new Dirt(); break;
            case "Grass":
                newTileType = new Grass(); break;
            case "PlantableDirt":
                newTileType = new PlantableDirt(); break;
            case "Home":
                newTileType = new Home(); break;
        }
        if(newTileType != null){
            newTileType.setTileObject(tileObjectFactory.createTileObject(tileObject));
        }
        return newTileType;


    }

}

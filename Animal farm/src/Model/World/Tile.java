package Model.World;

import Model.World.TileFactories.TerrainFactory;
import Model.World.TileObjects.ITileObject;
import Model.World.Terrain.ATerrain;

// An empty space that can be filled with a terrain
public class Tile {
    private ATerrain terrain;

    public Tile(ATerrain tileType) {
        this.terrain = tileType;
    }

    public ATerrain getTerrain(){
        return terrain;
    }
    public void setTerrain(ATerrain tileType){
        this.terrain = tileType;
    }

    // Delegates interact to its terrain and changes it if the interact results in a new terrain
    public void interact(ITileAction action){
        if(terrain != null){
            String newTerrainName = terrain.interact(action);
            ATerrain newTerrain = TerrainFactory.getInstance().createTileType(newTerrainName, "");
            if(newTerrain != null){
                setTerrain(newTerrain);
            }
        }
    }

}


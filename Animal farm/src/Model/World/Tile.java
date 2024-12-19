package Model.World;

import Model.World.TileFactories.TerrainFactory;
import Model.World.TileObjects.ITileObject;
import Model.World.TileTypes.ATerrain;

public class Tile {
    private ITileObject tileObject;
    private ATerrain tileType;

    public Tile(ATerrain tileType) {
        this.tileType = tileType;
    }

    public ITileObject getTileObject(){
        return tileObject;
    }
    public void setTileObject(ITileObject object){
        tileObject = object;
    }
    public ATerrain getTileType(){
        return tileType;
    }
    public void setTileType(ATerrain tileType){
        this.tileType = tileType;
    }
    public void interact(ITileAction action){
        if(tileType != null){
            String newTileTypeName = tileType.interact(action);
            ATerrain newTileType = TerrainFactory.getInstance().createTileType(newTileTypeName, "");
            if(newTileType != null){
                tileType = newTileType;
            }
        }
    }

}


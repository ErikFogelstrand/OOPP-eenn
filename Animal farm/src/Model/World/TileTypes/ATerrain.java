package Model.World.TileTypes;

import Model.World.ITileAction;
import Model.World.TileObjects.ITileObject;

public abstract class ATerrain {
    protected ITileObject tileObject;

    public ATerrain() {
    }
    public abstract boolean walkable();
    public String interact(ITileAction action){
        if(tileObject != null){
            tileObject.interact(action);
            return "";
        }
        return tileTypeInteract(action);
    }
    protected abstract String tileTypeInteract(ITileAction action);


    public ITileObject getTileObject(){
        return tileObject;
    }
    public void setTileObject(ITileObject object){
        tileObject = object;
    }

}

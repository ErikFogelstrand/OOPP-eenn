package Model.World.TileTypes;

import Model.World.IAction;
import Model.World.TileObjects.ITileObject;

public abstract class ATileType {
    protected ITileObject tileObject;

    public ATileType() {
    }
    public abstract boolean walkable();
    public String interact(IAction action){
        if(tileObject != null){
            tileObject.interact(action);
            return "";
        }
        return tileTypeInteract(action);
    }
    protected abstract String tileTypeInteract(IAction action);


    public ITileObject getTileObject(){
        return tileObject;
    }
    public void setTileObject(ITileObject object){
        tileObject = object;
    }

}

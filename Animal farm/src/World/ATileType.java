package World;

public abstract class ATileType {
    private ITileObject tileObject;

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

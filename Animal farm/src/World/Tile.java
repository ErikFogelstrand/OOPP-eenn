package World;

public class Tile {
    private IEntity entity;
    private ITileObject tileObject;
    private ITileType tileType;

    public Tile(ITileObject tileObject, ITileType tileType) {
        this.tileObject = tileObject;
        this.tileType = tileType;
    }

    public ITileObject getTileObject(){
        return tileObject;
    }
    public void setTileObject(ITileObject object){
        tileObject = object;
    }
    public ITileType getTileType(){
        return tileType;
    }
    public void setTileType(ITileType tileType){
        this.tileType = tileType;
    }
    public IEntity getEntity(){
        return entity;
    }
    public void setEntity(IEntity entity){
        this.entity = entity;
    }
    public void interact(IAction action){
        if(tileObject != null){
            tileObject.interact(action);
        }
        if(tileType != null){
            String newTileTypeName = tileType.interact(action);
            ITileType newTileType = TileTypeFactory.getInstance().createTileType(newTileTypeName);
            if(newTileType != null){
                tileType = newTileType;
            }
        }
    }

}


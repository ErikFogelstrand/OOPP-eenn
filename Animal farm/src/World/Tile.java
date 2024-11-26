package World;

public class Tile {
    private IEntity entity;
    private ITileObject tileObject;
    private ITileType tileType;

    public ITileObject getObject(){
        return tileObject;
    }
    public void setObject(ITileObject object){
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


}


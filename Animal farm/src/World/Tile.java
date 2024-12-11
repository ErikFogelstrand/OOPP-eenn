package World;

public class Tile {
    private ITileObject tileObject;
    private ATileType tileType;

    public Tile(ATileType tileType) {
        this.tileType = tileType;


    }

    public ITileObject getTileObject(){
        return tileObject;
    }
    public void setTileObject(ITileObject object){
        tileObject = object;
    }
    public ATileType getTileType(){
        return tileType;
    }
    public void setTileType(ATileType tileType){
        this.tileType = tileType;
    }
    public void interact(IAction action){
        if(tileType != null){
            String newTileTypeName = tileType.interact(action);
            ATileType newTileType = TileTypeFactory.getInstance().createTileType(newTileTypeName, "");
            if(newTileType != null){
                tileType = newTileType;
            }
        }
    }

}


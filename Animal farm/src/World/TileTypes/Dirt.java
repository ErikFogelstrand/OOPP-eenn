package World.TileTypes;

import World.IAction;
import World.ATileType;
import World.ITileObject;

public class Dirt extends ATileType {
    public Dirt() {
    }

    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(IAction action) {
        if(action.getType().equals("Hoe")){
            return hoe();
        }
        return "";
    }
    private String hoe(){
        return "PlantableDirt";
    }
}

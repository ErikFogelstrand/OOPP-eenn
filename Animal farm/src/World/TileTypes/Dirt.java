package World.TileTypes;

import World.IAction;
import World.ITileType;

public class Dirt implements ITileType {

    @Override
    public boolean walkable() {return true;}

    @Override
    public String interact(IAction action) {
        if(action.getType().equals("Hoe")){
            return hoe();
        }
        return "";
    }
    private String hoe(){
        return "PlantableDirt";
    }
}

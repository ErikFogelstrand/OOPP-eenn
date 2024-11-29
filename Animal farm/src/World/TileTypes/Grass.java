package World.TileTypes;

import World.IAction;
import World.ITileType;

public class Grass implements ITileType {

    @Override
    public boolean walkable() {return true;}

    @Override
    public String interact(IAction action) {
        if(action.getType().equals("Hoe")){
            return hoe();
        }
        if(action.getType().equals("Shovel")){
            return shovel();
        }
        return "";
    }
    public String hoe(){
        return "PlantableDirt";
    }
    public String shovel(){
        return "Dirt";
    }
}

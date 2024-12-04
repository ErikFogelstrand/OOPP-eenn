package World.TileTypes;

import World.ATileType;
import World.IAction;
import World.ITileObject;

public class Grass extends ATileType {
    public Grass() {
    }

    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(IAction action) {
        if(action.getType().equals("Hoe")){
            return hoe();
        }
        if(action.getType().equals("Shovel")){
            return shovel();
        }
        return "";
    }
    private String hoe(){
        return "PlantableDirt";
    }
    private String shovel(){
        return "Dirt";
    }
}

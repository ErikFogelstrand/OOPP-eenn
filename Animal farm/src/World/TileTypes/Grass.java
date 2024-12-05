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
        if(action.getType().equals("UsableObjects.Hoe")){
            action.use();
            return hoe();
        }
        if(action.getType().equals("Shovel")){
            action.use();
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

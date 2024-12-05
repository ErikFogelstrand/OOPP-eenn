package World.TileTypes;

import World.IAction;
import World.ATileType;

public class Dirt extends ATileType {
    public Dirt() {
    }

    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(IAction action) {
        if(action.getType().equals("UsableObjects.Hoe")){
            action.use();
            return hoe();
        }
        return "";
    }
    private String hoe(){
        return "PlantableDirt";
    }
}

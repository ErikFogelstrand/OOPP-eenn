package World.TileTypes;

import World.IAction;
import World.ITileType;

public class Grass implements ITileType {

    @Override
    public boolean walkable() {return true;}

    @Override
    public void interact(IAction action) {
        if(action.getType().equals("Hoe")){
            hoe();
        }
        if(action.getType().equals("Shovel")){
            shovel();
        }
    }
    public void hoe(){
        //plantable dirt
    }
    public void shovel(){
        //dirt
    }
}

package World.TileTypes;

import World.IAction;
import World.ITileType;
import World.IWaterableTile;

public class PlantableDirt implements ITileType, IWaterableTile {
    private boolean watered;

    public PlantableDirt() {
        watered = false;
    }

    public boolean walkable() {return true;}

    public String interact(IAction action) {
        if(action.getType().startsWith("Seed")) {
            plant();
        }
        else if (action.getType().equals("Shovel")){
            return shovel();
        }
        return "";
    }
    private void plant(){

    }

    private String shovel(){
        return "Dirt";
    }

    public boolean getWatered() {
        return watered;
    }
    public void setWatered(boolean watered) {
        this.watered = watered;
    }
}

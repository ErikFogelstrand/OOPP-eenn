package World.TileTypes;

import World.*;

public class PlantableDirt extends ATileType implements IWaterableTile {
    private boolean watered;

    public PlantableDirt() {
        watered = false;
    }

    public boolean walkable() {return true;}

    public String tileTypeInteract(IAction action) {
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

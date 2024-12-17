package World.TileTypes;

import UsableObjects.SeedItem;
import World.*;
import World.TileObjects.APlantable;

public class PlantableDirt extends ATileType implements IWaterableTile {
    private boolean watered;

    public PlantableDirt() {
        watered = false;
        System.out.println("I am plantable af!!");
    }

    public boolean walkable() {return true;}

    @Override
    public String interact(IAction action) { //temporary fix
        String newTileTypeName = super.interact(action);
        if (tileObject instanceof APlantable && action.getType().equals("Hand")){
            tileObject = null;
        }
        return newTileTypeName;
    }

    protected String tileTypeInteract(IAction action) {
        if(action.getType().equals("Seed")) {
            if (plant((SeedItem)action)) {
                action.use();
            }
        }
        else if (action.getType().equals("Shovel")){
            action.use();
            return shovel();
        }
        return "";
    }
    private boolean plant(SeedItem seedItem){
        if (tileObject != null){
            return false;
        }
        tileObject = TileObjectFactory.getInstance().createTileObject(seedItem.getSeedType());
        ((APlantable)tileObject).setWaterableTile(this);

        return tileObject != null;
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

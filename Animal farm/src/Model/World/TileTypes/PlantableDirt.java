package Model.World.TileTypes;

import Model.UsableObjects.SeedItem;
import Model.World.*;
import Model.World.TileFactories.TileObjectFactory;
import Model.World.TileObjects.APlantable;

public class PlantableDirt extends ATileType {
    public PlantableDirt() {
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

        return tileObject != null;
    }

    private String shovel(){
        return "Dirt";
    }
}

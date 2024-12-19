package Model.World.Terrain;

import Model.UsableObjects.SeedItem;
import Model.World.*;
import Model.World.TileFactories.TileObjectFactory;
import Model.World.TileObjects.APlantableTileObject;

public class PlantableDirt extends ATerrain {
    public PlantableDirt() {
        System.out.println("I am plantable af!!");
    }

    public boolean walkable() {return true;}

    @Override
    public String interact(ITileAction action) { //temporary fix
        String newTileTypeName = super.interact(action);
        if (tileObject instanceof APlantableTileObject && action.getType().equals("Hand")){
            tileObject = null;
        }
        return newTileTypeName;
    }

    protected String tileTypeInteract(ITileAction action) {
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

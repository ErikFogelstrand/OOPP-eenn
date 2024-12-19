package Model.World.TileTypes;

import Model.World.ITileAction;

public class Grass extends ATerrain {
    public Grass() {
        System.out.println("I am grass!");
    }



    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(ITileAction action) {
        if(action.getType().equals("Model.UsableObjects.Hoe")){
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

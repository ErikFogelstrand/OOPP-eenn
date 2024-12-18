package Model.World.TileTypes;

import Model.World.IAction;

public class Grass extends ATileType {
    public Grass() {
        System.out.println("I am grass!");
    }



    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(IAction action) {
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

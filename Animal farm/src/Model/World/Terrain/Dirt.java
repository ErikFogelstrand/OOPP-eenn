package Model.World.Terrain;

import Model.World.ITileAction;

public class Dirt extends ATerrain {
    public Dirt() {
        System.out.println("I am dirt!");
    }

    @Override
    public boolean walkable() {return true;}

    @Override
    public String tileTypeInteract(ITileAction action) {
        if(action.getType().equals("Hoe")){
            action.use();
            return hoe();
        }
        return "";
    }
    private String hoe(){
        return "PlantableDirt";
    }
}

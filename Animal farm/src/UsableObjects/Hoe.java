package UsableObjects;
import Inventory.Inventory;

import World.ATileType;
import World.IAction;
import World.Tile;
import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;

public class Hoe extends Tool {
    public Hoe(String name, String type){
        super(name, type);
    }
    @Override
    public void use() {
        System.out.println("Now you can plant :)");
    }
    @Override
    public String getType() {
        return "Hoe";
    }
}
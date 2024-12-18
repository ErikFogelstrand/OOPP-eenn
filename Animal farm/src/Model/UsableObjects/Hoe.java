package Model.UsableObjects;

import Model.World.TileTypes.ATileType;
import Model.World.IAction;
import Model.World.Tile;
import Model.World.TileTypes.Dirt;
import Model.World.TileTypes.Grass;
import Model.World.TileTypes.PlantableDirt;

public abstract class Hoe extends Tool {
    public Hoe(String name){
        super(name);
    }

    public void use(IAction action) {
        Tile tile = (Tile) action;
        ATileType tileType = tile.getTileType();
        if (tileType instanceof Grass || tileType instanceof Dirt) {
            tile.setTileType(new PlantableDirt());
        }
    }
}
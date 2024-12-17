package UsableObjects;
import Inventory.Inventory;
import Player.Player;

import World.ATileType;
import World.IAction;
import World.Tile;
import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;

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
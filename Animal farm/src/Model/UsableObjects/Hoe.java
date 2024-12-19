package Model.UsableObjects;

import Model.World.TileTypes.ATerrain;
import Model.World.ITileAction;
import Model.World.Tile;
import Model.World.TileTypes.Dirt;
import Model.World.TileTypes.Grass;
import Model.World.TileTypes.PlantableDirt;

public abstract class Hoe extends Tool {
    public Hoe(String name){
        super(name);
    }

    public void use(ITileAction action) {
        Tile tile = (Tile) action;
        ATerrain tileType = tile.getTileType();
        if (tileType instanceof Grass || tileType instanceof Dirt) {
            tile.setTileType(new PlantableDirt());
        }
    }
}
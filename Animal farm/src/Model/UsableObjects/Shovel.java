package Model.UsableObjects;

import Model.World.TileTypes.ATileType;
import Model.World.IAction;
import Model.World.Tile;
import Model.World.TileTypes.Dirt;
import Model.World.TileTypes.Grass;
import Model.World.TileTypes.PlantableDirt;
    public abstract class Shovel extends Tool {
        public Shovel(String name){
            super(name);
        }

        @Override
        public void use(IAction action) {
            Tile tile = (Tile) action;
            ATileType tileType = tile.getTileType();
            if (tileType instanceof Grass || tileType instanceof PlantableDirt) {
                tile.setTileType(new Dirt());
            }
        }
    }


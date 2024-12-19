package Model.UsableObjects;

import Model.World.TileTypes.ATerrain;
import Model.World.ITileAction;
import Model.World.Tile;
import Model.World.TileTypes.Dirt;
import Model.World.TileTypes.Grass;
import Model.World.TileTypes.PlantableDirt;
    public abstract class Shovel extends Tool {
        public Shovel(String name){
            super(name);
        }

        @Override
        public void use(ITileAction action) {
            Tile tile = (Tile) action;
            ATerrain tileType = tile.getTileType();
            if (tileType instanceof Grass || tileType instanceof PlantableDirt) {
                tile.setTileType(new Dirt());
            }
        }
    }


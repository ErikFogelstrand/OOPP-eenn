package UsableObjects;

import World.ATileType;
import World.IAction;
import World.Tile;
import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;
    public class Shovel extends Tool {
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
}

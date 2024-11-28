package World;

import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;

public class TileTypeFactory {
    public static ITileType createTileType(String tileType){
        return switch (tileType) {
            case "Dirt" -> new Dirt();
            case "Grass" -> new Grass();
            case "PlantableDirt" -> new PlantableDirt();
            default -> null;
        };
    }

}

package World;

import World.TileTypes.Dirt;
import World.TileTypes.Grass;
import World.TileTypes.PlantableDirt;

public class TileTypeFactory {
    private static final TileTypeFactory instance = new TileTypeFactory();

    public static TileTypeFactory getInstance() {return instance;}

    public ITileType createTileType(String tileType){
        return switch (tileType) {
            case "Dirt" -> new Dirt();
            case "Grass" -> new Grass();
            case "PlantableDirt" -> new PlantableDirt();
            default -> null;
        };
    }

}

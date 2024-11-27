package World;

public class TileTypeFactory {
    public static ITileType createTileType(String tileType){
        switch (tileType){
            case "Dirt":
                return new Dirt();
            case "Grass":
                return new Grass();
            case "PlantableDirt":
                return new PlantableDirt();
        }
        return null;
    }

}

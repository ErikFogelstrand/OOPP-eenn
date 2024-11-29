package World;

import World.TileObjects.Carrot;

public class TileObjectFactory {
    private static final TileObjectFactory instance = new TileObjectFactory();

    public static TileObjectFactory getInstance() {return instance;}

    public ITileObject createTileObject(String tileObject) {
        switch (tileObject) {
            case "Carrot":
                return new Carrot();
        }
        return null;
    }
}

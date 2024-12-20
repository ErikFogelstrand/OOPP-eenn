package Model.World.TileFactories;

import Model.World.TileObjects.Carrot;
import Model.World.TileObjects.ITileObject;

public class TileObjectFactory {
    // singleton instance
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

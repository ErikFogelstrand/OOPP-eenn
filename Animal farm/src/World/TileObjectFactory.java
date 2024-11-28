package World;

import World.TileObjects.Carrot;

public class TileObjectFactory {
    public static ITileObject createTileObject(String tileObject) {
        switch (tileObject) {
            case "Carrot":
                return new Carrot();
        }
        return null;
    }
}

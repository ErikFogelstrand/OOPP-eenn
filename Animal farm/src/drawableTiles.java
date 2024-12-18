import World.ATileType;
import World.GameScene;
import World.GameSceneHandler;
import World.ITileObject;
import World.TileObjects.Carrot;
import World.TileTypes.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableTiles {
    BufferedImage grass;
    BufferedImage dirt;
    BufferedImage soil;
    BufferedImage tileCarrotSeed_0;
    BufferedImage tileCarrotSeed_1;
    BufferedImage tileCarrotSeed_2;
    BufferedImage defaultImage;

    public drawableTiles() {
        getTileImage();
    }

    public void getTileImage() {
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soil = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil.png"));

            tileCarrotSeed_0 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-0.png"));
            tileCarrotSeed_1 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-1.png"));
            tileCarrotSeed_2 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-2.png"));

            defaultImage = ImageIO.read(getClass().getResourceAsStream("Graphics/items/carrot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getTileTypeImage(ATileType tileType) {
        if (tileType instanceof Dirt) {
            return dirt;
        } else if (tileType instanceof Grass) {
            return grass;
        } else if (tileType instanceof PlantableDirt) {
            return soil;
        }
        return null;
    }

    private BufferedImage getTileObjectImage(ITileObject tileObject) {
        if (tileObject instanceof Carrot) {
            BufferedImage[] carrotImages = new BufferedImage[]{
                    tileCarrotSeed_0, tileCarrotSeed_1, tileCarrotSeed_2
            };
            return carrotImages[((Carrot) tileObject).getGrowthState()];
        }
        return null;
    }


    public void draw(Graphics2D g2, int tileSize) {
        GameScene gameScene = GameSceneHandler.getInstance().getActiveGameScene();
        for (int y = 0; y < gameScene.getSize().y; y++) {
            for (int x = 0; x < gameScene.getSize().x; x++) {
                g2.drawImage(getTileTypeImage(gameScene.getTile(x, y).getTileType()), x * tileSize, y * tileSize, tileSize, tileSize, null);
                g2.drawImage(getTileObjectImage(gameScene.getTile(x, y).getTileType().getTileObject()), x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
    }
}
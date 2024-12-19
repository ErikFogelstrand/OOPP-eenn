package View;

import Model.World.Terrain.ATerrain;
import Model.World.GameScene;
import Model.World.GameSceneManager;
import Model.World.TileObjects.ITileObject;
import Model.World.TileObjects.Carrot;
import Model.World.Terrain.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawableTiles {
    private BufferedImage grass;
    private BufferedImage dirt;
    private BufferedImage soil;
    private BufferedImage tileCarrotSeed_0;
    private BufferedImage tileCarrotSeed_1;
    private BufferedImage tileCarrotSeed_2;

    public DrawableTiles() {
        loadTileImages();
    }

    private void loadTileImages() {
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soil = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil.png"));

            tileCarrotSeed_0 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-0.png"));
            tileCarrotSeed_1 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-1.png"));
            tileCarrotSeed_2 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getTileTypeImage(ATerrain tileType) {
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
        GameScene gameScene = GameSceneManager.getInstance().getActiveGameScene();
        for (int y = 0; y < gameScene.getSize().y; y++) {
            for (int x = 0; x < gameScene.getSize().x; x++) {
                g2.drawImage(getTileTypeImage(gameScene.getTile(x, y).getTileType()), x * tileSize, y * tileSize, tileSize, tileSize, null);
                g2.drawImage(getTileObjectImage(gameScene.getTile(x, y).getTileType().getTileObject()), x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
    }
}
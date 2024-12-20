package View;

import Model.UsableObjects.Item;
import Model.World.Terrain.ATerrain;
import Model.World.GameScene;
import Model.World.GameSceneManager;
import Model.World.TileObjects.APlantableTileObject;
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
    private BufferedImage soilDry;
    private BufferedImage soilWet;
    private BufferedImage CarrotSeed_0;
    private BufferedImage CarrotSeed_1;
    private BufferedImage CarrotSeed_2;
    private BufferedImage carrot;

    public DrawableTiles() {
        loadTileImages();
    }

    private void loadTileImages() {
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soilDry = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil_DRY.png"));
            soilWet = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil_WET.png"));

            CarrotSeed_0 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/carrotSeed_0.png"));
            CarrotSeed_1 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/carrotSeed_1.png"));
            CarrotSeed_2 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/carrotSeed_2.png"));

            carrot = ImageIO.read(getClass().getResourceAsStream("Graphics/items/Carrot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getTileTypeImage(ATerrain terrain) {
        if (terrain instanceof Dirt) {
            return dirt;
        } else if (terrain instanceof Grass) {
            return grass;
        } else if (terrain instanceof PlantableDirt) {
            if (terrain.getTileObject() instanceof APlantableTileObject && ((APlantableTileObject) terrain.getTileObject()).getWatered()){
                return soilWet;
            }
            return soilDry;
        }
        return null;
    }

    private BufferedImage getTileObjectImage(ITileObject tileObject) {
        if (tileObject instanceof Carrot) {
            BufferedImage[] carrotImages = new BufferedImage[]{
                    CarrotSeed_0, CarrotSeed_1, CarrotSeed_2
            };
            return carrotImages[((Carrot) tileObject).getGrowthState()];
        }
        return null;
    }

    private BufferedImage getDroppedItemImage(Item item){
        switch(item.getType()){
            case("Carrot"): {return carrot;}
        }
        return null;
    }


    public void draw(Graphics2D g2, int tileSize) {
        GameScene gameScene = GameSceneManager.getInstance().getActiveGameScene();
        for (int y = 0; y < gameScene.getSize().y; y++) {
            for (int x = 0; x < gameScene.getSize().x; x++) {
                g2.drawImage(getTileTypeImage(gameScene.getTile(x, y).getTerrain()), x * tileSize, y * tileSize, tileSize, tileSize, null);
                g2.drawImage(getTileObjectImage(gameScene.getTile(x, y).getTerrain().getTileObject()), x * tileSize, y * tileSize, tileSize, tileSize, null);
                for (Item item : gameScene.getTile(x, y).getTerrain().getDroppedItems()){
                    g2.drawImage(getDroppedItemImage(item), x * tileSize, y * tileSize, tileSize, tileSize, null);
                }

            }
        }
    }
}
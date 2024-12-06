import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class drawableTiles {

    GamePanel gp;
    int mapTileNum[][];


    public drawableTiles(GamePanel gp){
        this.gp = gp;
        mapTileNum = new int[gp.screenCol][gp.screenRow];
        getTileImage();
        loadMap();
    }

    BufferedImage grass;
    BufferedImage dirt;
    BufferedImage soil;
    BufferedImage tileCarrotSeed_0;
    BufferedImage tileCarrotSeed_1;
    BufferedImage tileCarrotSeed_2;


    public void getTileImage(){
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soil = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil.png"));

            tileCarrotSeed_0 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-0.png"));
            tileCarrotSeed_1 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-1.png"));
            tileCarrotSeed_2 = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/plantedSoil/carrot-2.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage removeThisLaterTiles(int i){
        BufferedImage[] tileArray = new BufferedImage[] {
                grass, dirt, soil, tileCarrotSeed_0, tileCarrotSeed_1, tileCarrotSeed_2
        };
        return tileArray[i];
    }

    public void loadMap() { //this should be in Tiles not in the view!
        try{
            InputStream txt = getClass().getResourceAsStream("Graphics/tiles/tileMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(txt));

            int col = 0;
            int row = 0;

            while(col < gp.screenCol && row < gp.screenRow){
                String line = br.readLine();

                while(col < gp.screenCol){

                    String numbers[] = line.split(" "); // gives number[x] = 1/2/3/4 = tiletype
                    int num = Integer.parseInt(numbers[col]); // string -> int

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.screenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {}
    }


    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col< gp.screenCol && row < gp.screenRow) {
            int tileNum = mapTileNum[col][row]; //mapTileNum should not be in view!



            g2.drawImage(removeThisLaterTiles(tileNum), x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.screenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }

    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class drawTiles {

    GamePanel gp;

    public drawTiles(GamePanel gp){
        this.gp = gp;

        getTileImage();

    }

    BufferedImage grass;
    BufferedImage dirt;
    BufferedImage soil;
    BufferedImage rabbit;

    public void getTileImage(){
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soil = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil.png"));
            rabbit = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col< gp.screenCol && row < gp.screenRow) {
            g2.drawImage(grass, x, y, gp.tileSize, gp.tileSize, null);
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

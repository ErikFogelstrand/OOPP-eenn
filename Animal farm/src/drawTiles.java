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

    public void getTileImage(){
        try {
            grass = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/grass.png"));
            dirt = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/dirt.png"));
            soil = ImageIO.read(getClass().getResourceAsStream("Graphics/tiles/soil.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        g2.drawImage(grass, 10, 10, gp.tileSize, gp.tileSize, null);
    }
}

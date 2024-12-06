import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableSprites {

    GamePanel gp;

    public drawableSprites(GamePanel gp){
        this.gp = gp;
        getTileImage();
    }

    BufferedImage rabbit;
    BufferedImage villager;



    public void getTileImage(){
        try {
            rabbit = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2, int x, int y){

        g2.drawImage(rabbit, x, y, gp.tileSize, gp.tileSize, null);
    }
}

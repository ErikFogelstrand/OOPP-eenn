import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawSprites {

    GamePanel gp;

    public drawSprites(GamePanel gp){
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
    public void draw(Graphics2D g2){

        //g2.drawImage(rabbit, 10, 10, gp.tileSize, gp.tileSize, null);
    }
}

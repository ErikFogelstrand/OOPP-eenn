import World.GameScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableSprites {

    GamePanel gp;
    IPlayerPos playerPos = Player.getInstance();


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



    public void draw(Graphics2D g2){

        //System.out.println(playerPos.getPos().x);
        g2.drawImage(rabbit, playerPos.getPos().x, playerPos.getPos().y, gp.tileSize, gp.tileSize, null);
    }
}

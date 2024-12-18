import Player.IPlayerPos;
import Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableSprites {
    IPlayerPos playerPos;

    public drawableSprites(IPlayerPos playerPos){
        this.playerPos = playerPos;
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



    public void draw(Graphics2D g2, int tileSize){
        g2.drawImage(rabbit, playerPos.getPos().x*tileSize, playerPos.getPos().y*tileSize, tileSize, tileSize, null);
    }
}

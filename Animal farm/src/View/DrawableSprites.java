package View;

import Model.Player.IMovementHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawableSprites {
    private final IMovementHandler playerPos;
    private BufferedImage rabbit;
    private BufferedImage villager;

    public DrawableSprites(IMovementHandler playerPos){
        this.playerPos = playerPos;
        loadTileImages();
    }

    private void loadTileImages(){
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

import Player.IPlayerPos;
import Player.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableSprites {

    GamePanel gp;
    IPlayerPos playerPos = Player.getInstance();
    int spriteHeight;
    int spriteWidth;


    public drawableSprites(GamePanel gp){
        this.gp = gp;
        spriteHeight = gp.tileSize + 2*gp.scale; //plus 2 pixels in height (2*scale)=8
        spriteWidth = gp.tileSize;

        getTileImage();
    }
    BufferedImage rabbitFront, rabbitBack, rabbitLeft, rabbitRight;
    BufferedImage directionImage;
    static String direction = "front";

    //BufferedImage villager; //future implementation!



    public void getTileImage(){
        try {
            rabbitFront = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_FRONT.png"));
            rabbitBack = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_BACK.png"));
            rabbitLeft = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_LEFT.png"));
            rabbitRight = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_RIGHT.png"));
            directionImage = rabbitFront;

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage setImageDirection(){

        switch (direction) {
            case ("back"):
                directionImage = rabbitBack;
                break;
            case ("front"):
                directionImage = rabbitFront;
                break;
            case ("left"):
                directionImage = rabbitLeft;
                break;
            case ("right"):
                directionImage = rabbitRight;
                break;
        }
        return directionImage;
    }

    public void draw(Graphics2D g2){


        g2.drawImage(setImageDirection(), playerPos.getPos().x * gp.tileSize, playerPos.getPos().y * gp.tileSize-8, spriteWidth, spriteHeight, null);
    }

}


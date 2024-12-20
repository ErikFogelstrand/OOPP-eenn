package View;

import Model.Player.IMovementHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawableSprites {
    private final IMovementHandler playerPos; // The movement and direction the sprite should follow
    private final int spriteHeight;
    private final int spriteWidth;

    private BufferedImage rabbitFront, rabbitBack, rabbitLeft, rabbitRight;
    private BufferedImage directionImage;
    private String direction = "front";
    private final int tilesize;

    public DrawableSprites(IMovementHandler playerPos, int tileSize, int scale) {
        this.playerPos = playerPos;
        spriteHeight = tileSize + 2 * scale; //plus 2 pixels in height (2*scale)=8
        spriteWidth = tileSize;
        loadTileImages();
        this.tilesize = tileSize;
    }

    private void loadTileImages() {
        try {
            rabbitFront = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_FRONT.png"));
            rabbitBack = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_BACK.png"));
            rabbitLeft = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_LEFT.png"));
            rabbitRight = ImageIO.read(getClass().getResourceAsStream("Graphics/player/rabbit_RIGHT.png"));
            directionImage = rabbitFront;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // finds the right image
    private BufferedImage setImageDirection() {
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

    // Draws the sprite with the right orientation and
    public void draw(Graphics2D g2, int tileSize) {
        g2.drawImage(setImageDirection(), playerPos.getPos().x * tileSize, playerPos.getPos().y * tileSize - 8, spriteWidth, spriteHeight, null);
    }

    public void setDirection(String direction){
        this.direction = direction;
    }
}
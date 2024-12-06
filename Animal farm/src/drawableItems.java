import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawableItems {

    GamePanel gp;
    int x, y;

    public drawableItems(GamePanel gp){
        this.gp = gp;

        getItemImage();
    }

    int itemSize = 56; //14 pixels * scale 4
    int itemMargin = 12; // 4 pixels * scale 4

    BufferedImage carrot;
    BufferedImage hoe;
    BufferedImage itemSlot;



    public void getItemImage(){
        try {

            //slots
            itemSlot = ImageIO.read(getClass().getResourceAsStream("Graphics/items/hoe.png"));

            //items
            hoe = ImageIO.read(getClass().getResourceAsStream("Graphics/items/hoe.png"));
            carrot = ImageIO.read(getClass().getResourceAsStream("Graphics/items/carrot.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawItemsSlots(Graphics2D g2) {
        //fix this to get inventory items
    }
    public void draw(Graphics2D g2, int x, int y){

        //hard coded items loll
        g2.drawImage(hoe, x+itemMargin, y+itemMargin, itemSize, itemSize, null); //to fit in the item slots
        g2.drawImage(carrot, x+itemSize+itemMargin + 6 + itemMargin, y+itemMargin, itemSize, itemSize, null);
    }
}

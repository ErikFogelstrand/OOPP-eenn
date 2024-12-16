import Inventory.Inventory;
import UsableObjects.SeedItem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class drawableItems {

    GamePanel gp;
    int x, y;

    Inventory inventory = new Inventory(); //ska inte skapas här!!!!!!
    SeedItem carrotSeedItem = new SeedItem("carrot", 1, "carrot", "carrot"); //ska inte skapas här!!!
    SeedItem hoeItem = new SeedItem("hoe", 1, "hoe", "hoe"); //ska inte skapas här!!!

    private Map<String, BufferedImage> itemImages = new HashMap<>();

    public void initItems(){ //map to know be able to recognize a string to a buffered image
        itemImages.put("carrot", carrot);
        itemImages.put("hoe", hoe);
    }


    public drawableItems(GamePanel gp){
        this.gp = gp;

        getItemImage();
        initItems();
    }

    int itemSize = 56; //14 pixels * scale 4
    int slotSize = 80;
    int itemMargin = 12; // 4 pixels * scale 4
    int rows;
    int columns;

    BufferedImage carrot;
    BufferedImage hoe;
    BufferedImage itemSlot;



    public void getItemImage(){
        try {

            //slots
            itemSlot = ImageIO.read(getClass().getResourceAsStream("Graphics/other/mainSlot.png"));

            //items
            hoe = ImageIO.read(getClass().getResourceAsStream("Graphics/items/hoe.png"));
            carrot = ImageIO.read(getClass().getResourceAsStream("Graphics/items/carrot.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, int x, int y) {

        //fix this to get inventory items

        inventory.addItem(carrotSeedItem); //lägger till ett item
        inventory.addItem(hoeItem); //lägger till ett item
        //inventory.addItem(carrotSeedItem);
        int rows = inventory.getRows(); // =5
        int xchord = x;
        for(int i=0; i<=rows; i++){
            drawSlot(g2, xchord, y);
            drawItem(g2, xchord, y , i);
            xchord += itemMargin + itemSize;

        }
    }

    public void drawSlot(Graphics2D g2, int x, int y) {
        g2.drawImage(itemSlot, x, y, slotSize, slotSize, null); //to fit in the item slots
    }

    public void drawItem(Graphics2D g2, int x, int y, int row){


        //if (inventory.getItem(row, 0).isPresent()) {
        if (row == 0) {
            g2.drawImage(hoe, x + itemMargin, y + itemMargin, itemSize, itemSize, null); //to fit in the item slots
        }
        if (row == 2) {
            g2.drawImage(carrot, x + itemMargin, y + itemMargin, itemSize, itemSize, null); //to fit in the item slots
        }


        //g2.drawImage(carrot, x + itemMargin, y + itemMargin, itemSize, itemSize, null); //to fit in the item slots

        //g2.drawImage(carrot, x+itemSize+itemMargin + 6 + itemMargin, y+itemMargin, itemSize, itemSize, null);
    }
}

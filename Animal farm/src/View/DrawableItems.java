package View;

import Model.UsableObjects.Item;
import Model.Inventory.Inventory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Model.Inventory.IInventoryHolder;

public class DrawableItems {

    private final IInventoryHolder inventoryHolder;
    private final Map<String, BufferedImage> itemImages = new HashMap<>();
    private final int itemSize = 56; //14 pixels * scale 4
    private final int slotSize = 80;
    private final int itemMargin = 12; // 4 pixels * scale 4

    private BufferedImage itemSlot;


    public DrawableItems(IInventoryHolder inventoryHolder){
        this.inventoryHolder = inventoryHolder;
        loadItemImages();
    }

    private void loadItemImages(){
        try {

            //slots
            itemSlot = ImageIO.read(getClass().getResourceAsStream("Graphics/other/mainSlot.png"));

            //items
            itemImages.put("hoe", ImageIO.read(getClass().getResourceAsStream("Graphics/items/hoe.png")));
            itemImages.put("carrot", ImageIO.read(getClass().getResourceAsStream("Graphics/items/carrot.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2, int x, int y, boolean expandInventory) {

        Inventory inventory = inventoryHolder.getInventory();
        int rows = 1;
        int offset;
        int columns = inventory.getColumns(); // = 5
        if (expandInventory){
            rows = inventory.getRows();
            offset = -500;
        } else {
            offset = 0;
        }



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int xPos = x + (slotSize) * j;

                int yPos = y + (slotSize) * i;

                inventory.getItem(i, j);

                drawSlot(g2, xPos, yPos+offset);
                inventory.getItem(i, j).ifPresent(item -> drawItem(g2, xPos+itemMargin, yPos+itemMargin, item));
            }

        }
    }

    private void drawSlot(Graphics2D g2, int x, int y) {
        g2.drawImage(itemSlot, x, y, slotSize, slotSize, null); //to fit in the item slots
    }

    private void drawItem(Graphics2D g2, int x, int y, Item item){
        BufferedImage itemImage = itemImages.get(item.getName()); // Retrieve image by item name
        if (itemImage != null) {
            g2.drawImage(itemImage, x + itemMargin, y + itemMargin, itemSize, itemSize, null);
        }
    }
}

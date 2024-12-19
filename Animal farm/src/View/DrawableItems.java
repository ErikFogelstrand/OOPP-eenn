package View;

import Model.Inventory.InventoryHandler;
import Model.UsableObjects.Item;
import Model.UsableObjects.StackableItem;

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
    private BufferedImage selectedSlot;


    public DrawableItems(IInventoryHolder inventoryHolder){
        this.inventoryHolder = inventoryHolder;
        loadItemImages();
    }

    private void loadItemImages(){
        try {

            //slots
            itemSlot = ImageIO.read(getClass().getResourceAsStream("Graphics/other/mainSlot.png"));

            //selected slot overlay/frame
            selectedSlot = ImageIO.read(getClass().getResourceAsStream("Graphics/other/slot_SELECTED.png"));

            //items
            itemImages.put("Shovel", ImageIO.read(getClass().getResourceAsStream("Graphics/items/hoe.png")));
            itemImages.put("carrot", ImageIO.read(getClass().getResourceAsStream("Graphics/items/carrot.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2, int x, int y, boolean expandInventory) {

        InventoryHandler inventoryHandler = inventoryHolder.getInventory();
        int rows = 1;
        int offset;
        int columns = inventoryHandler.getColumns(); // = 5
        if (expandInventory){
            rows = inventoryHandler.getRows();
            offset = -500;
        } else {
            offset = 0;
        }



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int xPos = x + (slotSize) * j;

                int yPos = y + (slotSize) * i;

                inventoryHandler.getItem(i, j);

                drawSlot(g2, xPos, yPos+offset);
                inventoryHandler.getItem(i, j).ifPresent(item -> drawItem(g2, xPos+itemMargin, yPos+itemMargin, item));
            }
        }
    }

    private void drawSlot(Graphics2D g2, int x, int y) {
        g2.drawImage(itemSlot, x, y, slotSize, slotSize, null); //to fit in the item slots
    }

    private void drawItem(Graphics2D g2, int x, int y, Item Item){
        BufferedImage itemImage = itemImages.get(Item.getType()); // Retrieve image by item name
        if (itemImage != null) {
            g2.drawImage(itemImage, x + itemMargin, y + itemMargin, itemSize, itemSize, null);
        }
    }
}


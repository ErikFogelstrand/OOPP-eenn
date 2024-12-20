package View;

import Model.Inventory.InventoryHandler;
import Model.Items.Item;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Model.Inventory.IInventoryHolder;
import Model.Items.StackableItem;

public class DrawableItems {

    private final IInventoryHolder inventoryHolder; // The inventory displayed on the screen
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
            itemImages.put("Hoe", ImageIO.read(getClass().getResourceAsStream("Graphics/items/Hoe.png")));
            itemImages.put("WateringCan", ImageIO.read(getClass().getResourceAsStream("Graphics/items/WateringCan.png")));
            itemImages.put("Shovel", ImageIO.read(getClass().getResourceAsStream("Graphics/items/Shovel.png")));

            itemImages.put("Carrot", ImageIO.read(getClass().getResourceAsStream("Graphics/items/Carrot.png")));
            itemImages.put("Seed", ImageIO.read(getClass().getResourceAsStream("Graphics/items/CarrotSeeds.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Either draws only the hot bar or the whole inventory when opened
    public void draw(Graphics2D g2, int x, int y, boolean expandInventory) {

        InventoryHandler inventoryHandler = inventoryHolder.getInventory();
        int rows = 1;
        int columns = inventoryHandler.getColumns(); // = 5

        if (expandInventory) {
            rows = inventoryHandler.getRows();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                int xPos = x + (slotSize) * j;
                int yPos = y - slotSize*(i);

                inventoryHandler.getItem(i, j);

                drawSlot(g2, xPos, yPos);

                if (0 == i && inventoryHolder.getInventory().getSelectedItemInHotBar() == j && !expandInventory){
                    drawSelectedSlot(g2, xPos, yPos);
                }
                else if(inventoryHolder.getInventory().getSelectedY() == i && inventoryHolder.getInventory().getSelectedX() == j && expandInventory){
                    drawSelectedSlot(g2, xPos, yPos);
                }

                Item item = inventoryHandler.getItem(i, j);
                if (item != null){
                    drawItem(g2, xPos+itemMargin, yPos+itemMargin, item);

                    if(item instanceof StackableItem){
                        StackableItem stackableItem = (StackableItem) item;
                        drawItemCount(g2, stackableItem.getQuantity(), xPos, yPos);
                    }

                }
            }
        }
        if(inventoryHandler.getSelectedItem() != null && expandInventory){
            drawItem(g2,x + slotSize*inventoryHandler.getSelectedX(), y - slotSize*inventoryHandler.getSelectedY(), inventoryHandler.getSelectedItem());
        }
    }

    // draw an inventory slot
    private void drawSlot(Graphics2D g2, int x, int y) {
        g2.drawImage(itemSlot, x, y, slotSize, slotSize, null); //to fit in the item slots
    }

    // draw the white frame that indicates the currently selected slot/the selector
    private void drawSelectedSlot(Graphics2D g2, int x, int y){
        g2.drawImage(selectedSlot, x, y, slotSize, slotSize, null);
    }

    // draws numbers that indicates how many of a stackableItem is in the inventory
    private void drawItemCount(Graphics2D g2, int count, int x, int y){
        g2.setFont(new Font("Arial", Font.BOLD, 18)); // Use a larger font for the quantity
        g2.setColor(Color.WHITE); // Make the text white or any other color that fits your UI

        g2. drawString(Integer.toString(count), x+itemMargin, y+18);
    }

    // Draws both an item in a slot and an item picked up by the selector
    private void drawItem(Graphics2D g2, int x, int y, Item Item){
        BufferedImage itemImage = itemImages.get(Item.getType()); // Retrieve image by item name
        if (itemImage != null) {
            g2.drawImage(itemImage, x, y, itemSize, itemSize, null);
        }
    }
}


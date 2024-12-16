import UsableObjects.Item;
import UsableObjects.SeedItem;
import Inventory.Inventory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import Inventory.IInventoryHolder;

public class drawableItems {

    public GamePanel gp;
    private IInventoryHolder inventoryHolder;
    private Map<String, BufferedImage> itemImages = new HashMap<>();
    private int itemSize = 56; //14 pixels * scale 4
    private int slotSize = 80;
    private int itemMargin = 12; // 4 pixels * scale 4

    private BufferedImage itemSlot;


    public drawableItems(GamePanel gp, IInventoryHolder inventoryHolder){
        this.gp = gp;
        this.inventoryHolder = inventoryHolder;

        getItemImage();
    }

    public void getItemImage(){
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

    public void draw(Graphics2D g2, int x, int y) {
        Inventory inventory = inventoryHolder.getInventory();

        int rows = inventory.getRows(); // = 5
        int columns = inventory.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int xPos = x + (slotSize + itemMargin) * j;

                int yPos = y + (slotSize + itemMargin) * i;

                drawSlot(g2, xPos, yPos);
                inventory.getItem(i, j).ifPresent(item -> drawItem(g2, xPos, yPos, item));
            }

        }
    }

    public void drawSlot(Graphics2D g2, int x, int y) {
        g2.drawImage(itemSlot, x, y, slotSize, slotSize, null); //to fit in the item slots
    }

    public void drawItem(Graphics2D g2, int x, int y, Item item){
        BufferedImage itemImage = itemImages.get(item.getName()); // Retrieve image by item name
        if (itemImage != null) {
            g2.drawImage(itemImage, x + itemMargin, y + itemMargin, itemSize, itemSize, null);
        }
    }
}


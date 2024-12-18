
import Player.IStates;
import Inventory.IInventoryHolder;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel{

    private final IStates playerStates;
    private final IInventoryHolder inventoryHolder;


    final int baseTileSize = 16; // 16 pixels
    final int scale = 4;
    static boolean toggleState = false;

    final int tileSize = baseTileSize * scale; // 16 x 3 = 48
    final int screenRow = 12; //12 tiles high
    final int screenCol = 16; //16 tiles wide

    final int statusBarHeight = screenRow/4 * 41;
    final int statusBarWidth = screenCol/2 * 41;
    final int mainSlotsWidth = 92*scale;
    final int mainSlotsHeight = 20*scale;


    final int screenHeight = tileSize * screenRow; // =768 pixels
    final int screenWidth = tileSize * screenCol; // =576 pixels

    BufferedImage foodBarFull, foodBar66, foodBar33, foodBarNone;
    BufferedImage sleepBarFull, sleepBar66, sleepBar33, sleepBarNone;
    BufferedImage waterBarFull, waterBar66, waterBar33, waterBarNone;
    BufferedImage mainSlots;

    drawableTiles tile;
    drawableSprites rabbit;
    drawableItems items;


    public GamePanel(IStates istates, IInventoryHolder inventoryHolder){ ////////////

        this.playerStates = istates; ////////////////
        this.inventoryHolder = inventoryHolder;


        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered((true)); // apparently improves rendering performance

        getOverlayImages();
        this.items = new drawableItems(this);
        this.tile = new drawableTiles(this);
        this.rabbit = new drawableSprites(this);

    }



    public void getOverlayImages(){
        try {

            //mainSlots
            mainSlots = ImageIO.read(getClass().getResourceAsStream("Graphics/other/mainSlots.png"));

            //foodBar
            foodBarFull = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_FULL.png"));
            foodBar66 = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_66.png"));
            foodBar33 = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_33.png"));
            foodBarNone = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_NONE.png"));

            //sleepBar
            sleepBarFull= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_FULL.png"));
            sleepBar66= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_66.png"));
            sleepBar33= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_33.png"));
            sleepBarNone= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_NONE.png"));

            //waterBar
            waterBarFull = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_FULL.png"));
            waterBar66 = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_66.png"));
            waterBar33 = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_33.png"));
            waterBarNone = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_NONE.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectItemInInventory(int column) {
        inventoryHolder.getInventory().selectItem(column).ifPresent(item -> {
            System.out.println("Selected item: " + item.getName());
        });
    }

    public void updatePaint(){
        repaint();
    }


    public void drawStatusBars(Graphics2D g2){


        if(playerStates.getHunger()>90){g2.drawImage(foodBarFull, 0, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getHunger()>66){g2.drawImage(foodBar66, 0, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getHunger()>33){g2.drawImage(foodBar33, 0, 5, statusBarWidth, statusBarHeight, null);}
        else {g2.drawImage(foodBarNone, 0, 5, statusBarWidth, statusBarHeight, null);}

        if(playerStates.getSleep()>90){g2.drawImage(sleepBarFull, statusBarWidth*2, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getSleep()>66){g2.drawImage(sleepBar66, statusBarWidth*2, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getSleep()>33){g2.drawImage(sleepBar33, statusBarWidth*2, 5, statusBarWidth, statusBarHeight, null);}
        else {g2.drawImage(sleepBarNone, statusBarWidth*2, 5, statusBarWidth, statusBarHeight, null);}

        if(playerStates.getThirst()>90){ g2.drawImage(waterBarFull, statusBarWidth, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getThirst()>66){ g2.drawImage(waterBar66, statusBarWidth, 5, statusBarWidth, statusBarHeight, null);}
        else if(playerStates.getThirst()>33){ g2.drawImage(waterBar33, statusBarWidth, 5, statusBarWidth, statusBarHeight, null);}
        else { g2.drawImage(waterBarNone, statusBarWidth, 5, statusBarWidth, statusBarHeight, null);}


    }
    public static boolean toggleInventory(){
        toggleState = !toggleState;
        return toggleState;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        requestFocusInWindow();

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor((Color.white));

        tile.draw(g2);
        rabbit.draw(g2);


        drawStatusBars(g2);
        items.draw(g2, tileSize*(screenCol-1)/3, screenHeight-mainSlotsHeight, toggleState);

        g2.dispose();
    }
}


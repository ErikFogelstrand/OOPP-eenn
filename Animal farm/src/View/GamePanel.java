package View;

import Model.Inventory.IInventoryHolder;
import Model.Player.IMovementHandler;
import Model.Player.IPlayerStates;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel{

    private final IPlayerStates playerStates;

    private final int baseTileSize = 16; // 16 pixels
    private final int scale = 4;
    private static boolean toggleState = false;

    private final int tileSize = baseTileSize * scale; // 16 x 3 = 48
    private final int screenRow = 12; //12 tiles high
    private final int screenCol = 16; //16 tiles wide

    final int screenHeight = tileSize * screenRow; // =768 pixels
    final int screenWidth = tileSize * screenCol; // =576 pixels

    final int statusBarHeight = screenHeight/6;
    final int statusBarWidth = screenWidth/3; //three bars make up a third of screen
    final int statusDotSize = 5*scale;

    final int mainSlotsHeight = 20*scale;

    private BufferedImage foodBarDot, foodBarNone;
    private BufferedImage sleepBarDot, sleepBarNone;
    private BufferedImage waterBarDot, waterBarNone;

    private final DrawableTiles drawableTiles;
    private final DrawableSprites rabbit;
    private final DrawableItems drawableItems;


    public GamePanel(IPlayerStates istates, IMovementHandler playerPos, IInventoryHolder inventoryHolder){
        this.playerStates = istates;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered((true)); // apparently improves rendering performance

        loadOverlayImages();
        this.drawableItems = new DrawableItems(inventoryHolder);
        this.drawableTiles = new DrawableTiles();
        this.rabbit = new DrawableSprites(playerPos, tileSize, scale);
    }



    private void loadOverlayImages(){
        try {

            //foodBar+
            foodBarDot = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_DOT.png"));
            foodBarNone = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/food_EMPTY.png"));

            //sleepBar
            sleepBarDot= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_DOT.png"));
            sleepBarNone= ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/sleep_EMPTY.png"));

            //waterBar
            waterBarDot = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_DOT.png"));
            waterBarNone = ImageIO.read(getClass().getResourceAsStream("Graphics/Status Bars/water_EMPTY.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updatePaint(){
        repaint();
    }

    // Draws the bars that dynamically changes depending on the players different states
    public void currentBarStatus(Graphics g2, int currentStatus,BufferedImage statusBarDot, int x){
        int dotOffsetX = 106; //to fit the starting dot on the statusBar
        int dotSpace = 9; //the space between every dot that blits so they fit the whole statusBar
        int dotOffsetY = statusBarHeight/2 - 10; //

        for(int i = 0; i<20; i++){
            if (currentStatus/5>i) {

                g2.drawImage(statusBarDot, x + dotOffsetX + (i * dotSpace), dotOffsetY, statusDotSize, statusDotSize, null);
            }
        }
    }

    // Draws all the status bars
    public void drawStatusBars(Graphics2D g2) {

        g2.drawImage(foodBarNone, 0, 0, statusBarWidth, statusBarHeight, null);
        g2.drawImage(waterBarNone, statusBarWidth, 0, statusBarWidth, statusBarHeight, null);
        g2.drawImage(sleepBarNone, statusBarWidth * 2, 0, statusBarWidth, statusBarHeight, null);

        currentBarStatus(g2, playerStates.getHunger(), foodBarDot, 0);
        currentBarStatus(g2, playerStates.getThirst(), waterBarDot, statusBarWidth);
        currentBarStatus(g2, playerStates.getSleep(), sleepBarDot, statusBarWidth * 2);

    }
    public void toggleInventory(){
        toggleState = !toggleState;
    }

    public boolean getToggleState(){
        return toggleState;
    }

    // draws everything on screen, delegates to its different components
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        requestFocusInWindow();

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor((Color.white));

        drawableTiles.draw(g2, tileSize);
        rabbit.draw(g2, tileSize);

        drawStatusBars(g2);

        drawableItems.draw(g2,tileSize*(screenCol-1)/3, screenHeight-mainSlotsHeight, toggleState);

        g2.dispose();
    }

    public void setDirection(String direction){
        rabbit.setDirection(direction);
    }
}


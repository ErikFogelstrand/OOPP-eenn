import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel{

    final int baseTileSize = 16; // 16 pixels
    final int scale = 3;

    final int tileSize = baseTileSize * scale; // 16 x 3 = 48
    final int screenRow = 12; //12 tiles high
    final int screenCol = 16; //16 tiles wide

    final int screenHeight = tileSize * screenRow; // =768 pixels
    final int screenWidth = tileSize * screenCol; // =576 pixels

    drawTiles tile = new drawTiles(this);


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered((true)); // apparently improves rendering performance
    }

    public void updatePaint(){
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D)g;

        g2.setColor((Color.white));
        //g2.fillRect(10, 10, tileSize, tileSize);
        g2.drawImage(tile.soil, 0, 0, tileSize, tileSize, null);//för skojs skull orkade inte göra en loop
        g2.drawImage(tile.soil, tileSize, 0, tileSize, tileSize, null);
        g2.drawImage(tile.soil, tileSize*2, 0, tileSize, tileSize, null);
        g2.drawImage(tile.soil, tileSize*3, 0, tileSize, tileSize, null);
        g2.drawImage(tile.soil, tileSize*4, 0, tileSize, tileSize, null);
        g2.drawImage(tile.soil, tileSize*5, 0, tileSize, tileSize, null);
        g2.drawImage(tile.grass, tileSize*6, 0, tileSize, tileSize, null);
        g2.drawImage(tile.grass, tileSize*7, 0, tileSize, tileSize, null);
        g2.drawImage(tile.dirt,tileSize , 0, tileSize, tileSize, null);
        g2.drawImage(tile.dirt,  tileSize,tileSize, tileSize, tileSize, null);
        g2.drawImage(tile.dirt,  tileSize, tileSize*2, tileSize, tileSize, null);
        g2.drawImage(tile.grass,  tileSize,tileSize*3, tileSize, tileSize, null);
        g2.drawImage(tile.grass,  tileSize, tileSize*4,tileSize, tileSize, null);
        g2.drawImage(tile.grass,  tileSize,tileSize*5, tileSize, tileSize, null);
        g2.drawImage(tile.grass,  tileSize, tileSize*6, tileSize, tileSize, null);
        g2.dispose();


    }




}


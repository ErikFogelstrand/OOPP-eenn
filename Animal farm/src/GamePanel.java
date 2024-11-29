import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel{

    final int baseTileSize = 16; // 16 pixels
    final int scale = 4;

    final int tileSize = baseTileSize * scale; // 16 x 3 = 48
    final int screenRow = 12; //12 tiles high
    final int screenCol = 16; //16 tiles wide

    final int screenHeight = tileSize * screenRow; // =768 pixels
    final int screenWidth = tileSize * screenCol; // =576 pixels

    drawTiles tile = new drawTiles(this);
    drawSprites player = new drawSprites(this);



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
        g2.drawImage(tile.soil, 0, 0, tileSize, tileSize, null); //för skojs skull orkade inte göra en loop

        tile.draw(g2);
        player.draw(g2);
        g2.drawImage(tile.rabbit,  tileSize, tileSize*6, tileSize, tileSize, null);
        g2.drawImage(tile.dirt,  tileSize*3, tileSize*6, tileSize, tileSize, null);
        g2.drawImage(tile.soil,  tileSize*2, tileSize*6, tileSize, tileSize, null);
        g2.dispose();


    }




}


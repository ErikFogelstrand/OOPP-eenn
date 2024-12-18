
import Player.IPlayerPos;
import Player.Player;


import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    IPlayerPos playerPos = Player.getInstance();
    GamePanel gamePanel;
    String direction = "front";


    public Controller(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        /**
         *  player movement and direction bellow
         */

        if (keyCode == VK_W) {
            direction = "back";
            drawableSprites.direction = direction;
            playerPos.move(0, -1);
        }
        if (keyCode == VK_A) {
            direction = "left";
            drawableSprites.direction = direction;
            playerPos.move(-1, 0);
        }
        if (keyCode == VK_S) {
            direction = "front";
            drawableSprites.direction = direction;
            playerPos.move(0, 1);

        }
        if (keyCode == VK_D) {
            direction = "right";
            drawableSprites.direction = direction;
            playerPos.move(1, 0);
        }

        /**
         *  change of player direction with arrow keys bellow
         */

        if (keyCode == VK_UP) {
            direction = "back";
            drawableSprites.direction = direction;
        }
        if (keyCode == VK_DOWN) {
            direction = "left";
            drawableSprites.direction = direction;
        }
        if (keyCode == VK_LEFT) {
            direction = "front";
            drawableSprites.direction = direction;
         }
        if (keyCode == VK_RIGHT) {
            direction = "right";
            drawableSprites.direction = direction;
        }
        /**
         *
         *  toggle inventory bellow
         */

        if (keyCode == VK_Q) {
            gamePanel.toggleInventory();


            //interact
        }

        if (keyCode == VK_1) {
            //item 1
        }
        if (keyCode == VK_2) {
            //item 2
        }
        if (keyCode == VK_3) {
            //item 3
        }
        if (keyCode == VK_4) {
            //item 4
        }
        if (keyCode == VK_5) {
            //item 5


        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == VK_W){

        }
        if(keyCode == VK_A){

        }
        if(keyCode == VK_S){

        }
        if(keyCode == VK_D){

        }
        if (keyCode == VK_ENTER){
            //interact
        }
    }
}
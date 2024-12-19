
import Model.Player.IMovementHandler;
import View.DrawableSprites;
import View.GamePanel;


import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    private final IMovementHandler movementHandler;
    private final GamePanel gamePanel;
    String direction = "front";


    public Controller(GamePanel gamePanel,IMovementHandler movementHandler){
        this.gamePanel = gamePanel;
        this.movementHandler = movementHandler;
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
            gamePanel.setDirection(direction);
            movementHandler.move(0, -1);
        }
        if (keyCode == VK_A) {
            direction = "left";
            gamePanel.setDirection(direction);
            movementHandler.move(-1, 0);
        }
        if (keyCode == VK_S) {
            direction = "front";
            gamePanel.setDirection(direction);
            movementHandler.move(0, 1);

        }
        if (keyCode == VK_D) {
            direction = "right";
            gamePanel.setDirection(direction);
            movementHandler.move(1, 0);
        }

        /**
         *  change of player direction with arrow keys bellow
         */

        if (keyCode == VK_UP) {
            direction = "back";
            gamePanel.setDirection(direction);
        }
        if (keyCode == VK_DOWN) {
            direction = "left";
            gamePanel.setDirection(direction);
        }
        if (keyCode == VK_LEFT) {
            direction = "front";
            gamePanel.setDirection(direction);
         }
        if (keyCode == VK_RIGHT) {
            direction = "right";
            gamePanel.setDirection(direction);
        }
        /**
         *
         *  toggle inventory bellow
         */

        if (keyCode == VK_Q) {
            gamePanel.toggleInventory();


            //interact
        }

        if (keyCode >= VK_1 && keyCode <= VK_5){
            int column = keyCode - VK_1; // map keys 1-5 to column indices 0-4
            gamePanel.selectItemInInventory(column);
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
            System.out.println("interact!");
            movementHandler.interact(movementHandler.getPos().x, movementHandler.getPos().y);
        }
    }
}
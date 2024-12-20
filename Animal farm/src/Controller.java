
import Model.Player.IMovementHandler;
import View.DrawableSprites;
import View.GamePanel;
import Model.Player.Player;


import java.awt.*;
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
            setDirection("back");
            movementHandler.move(0, -1);
        }
        if (keyCode == VK_A) {
            setDirection("left");
            movementHandler.move(-1, 0);
        }
        if (keyCode == VK_S) {
            setDirection("front");
            movementHandler.move(0, 1);

        }
        if (keyCode == VK_D) {
            setDirection("right");
            movementHandler.move(1, 0);
        }

        /**
         *  change of player direction with arrow keys bellow
         */

        if (keyCode == VK_UP) {
            setDirection("back");
        }
        if (keyCode == VK_DOWN) {
            setDirection("front");
        }
        if (keyCode == VK_LEFT) {
            setDirection("left");
         }
        if (keyCode == VK_RIGHT) {
            setDirection("right");
        }
        /**
         *
         *  toggle inventory bellow
         */

        if (keyCode == VK_Q) {
            gamePanel.toggleInventory();
        }


        if (keyCode == VK_E){
            movementHandler.interact(movementHandler.getPos().x, movementHandler.getPos().y);
        }

        // Handle inventory navigation
        if (keyCode == VK_UP) {
            Player.getInstance().getInventory().selectItem(
                    Player.getInstance().getInventory().getSelectedY() - 1,
                    Player.getInstance().getInventory().getSelectedX()
            );
        }
        if (keyCode == VK_DOWN) {
            Player.getInstance().getInventory().selectItem(
                    Player.getInstance().getInventory().getSelectedY() + 1,
                    Player.getInstance().getInventory().getSelectedX()
            );
        }

        if (keyCode >= VK_1 && keyCode <= VK_5){
            int column = keyCode - VK_1; // map keys 1-5 to column indices 0-4
            Player.getInstance().getInventory().selectItem(
                    Player.getInstance().getInventory().getSelectedY(),
                    column);
            gamePanel.selectItemInInventory(column);
        }

    }

    private void setDirection(String direction){
        gamePanel.setDirection(direction);
        switch (direction){
            case ("back"): {movementHandler.setDirection(0, -1); break;}
            case ("front"): {movementHandler.setDirection(0, 1); break;}
            case ("left"): {movementHandler.setDirection(-1, 0); break;}
            case ("right"): {movementHandler.setDirection(1, 0); break;}
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
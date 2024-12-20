
import Model.Inventory.InventoryHandler;
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
            if(gamePanel.getToggleState()){
                changeSelectInventorySlot(0,1);
            } else{
                setDirection("back");
            }
        }
        if (keyCode == VK_DOWN) {
            if(gamePanel.getToggleState()){
                changeSelectInventorySlot(0,-1);
            } else{
                setDirection("front");
            }
        }
        if (keyCode == VK_LEFT) {
            if(gamePanel.getToggleState()){
                changeSelectInventorySlot(-1,0);
            } else{
                setDirection("left");
            };
         }
        if (keyCode == VK_RIGHT) {
            if(gamePanel.getToggleState()){
                changeSelectInventorySlot(1,0);
            } else{
                setDirection("right");
            }
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


        if (keyCode >= VK_1 && keyCode <= VK_5){
            int column = keyCode - VK_1; // map keys 1-5 to column indices 0-4
            Player.getInstance().getInventory().selectItemInHotBar(column);
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

    private void changeSelectInventorySlot(int x, int y){
        Player player = Player.getInstance();
        player.selectItem(player.getInventory().getSelectedY()+y, player.getInventory().getSelectedX()+x);
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
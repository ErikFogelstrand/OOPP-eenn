
import Player.IPlayerPos;
import Player.Player;


import Player.IPlayerPos;

import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    IPlayerPos playerPos = Player.getInstance();
    GamePanel gamePanel;


    public Controller(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == VK_W) {
            playerPos.move(0, -1);
        }
        if (keyCode == VK_A) {
            playerPos.move(-1, 0);
        }
        if (keyCode == VK_S) {
            playerPos.move(0, 1);

        }
        if (keyCode == VK_D) {

            playerPos.move(1, 0);
        }
        if (keyCode == VK_E) {
            gamePanel.toggleInventory();


            //interact
        }

        /*if (keyCode == VK_1) {
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
        }*/

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
            //interact
        }
    }
}
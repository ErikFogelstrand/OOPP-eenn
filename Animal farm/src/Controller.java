
import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    IPlayerPos playerPos = Player.getInstance();

    public Controller(){
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
        if (keyCode == VK_ENTER) {
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
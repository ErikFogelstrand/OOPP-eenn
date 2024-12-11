
import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    private Player player;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public void controller(){
        //this.player = new Player();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("fram");
        if(keyCode == VK_W){
            //this.player.move(0,-1); //ska inte adaptern sköta rörelse? inte player?
            upPressed = true;
            System.out.println("fram");
        }
        if(keyCode == VK_A){
            leftPressed = true;
            //this.player.move(-1,0);

        }
        if(keyCode == VK_S){
            downPressed = true;
            //this.player.move(0,1);

        }
        if(keyCode == VK_D){
            rightPressed = true;
            //this.player.move(1,0);
        }
        if (keyCode == VK_ENTER){
            //interact
        }

        if (keyCode == VK_1){
            //item 1
        }
        if (keyCode == VK_2){
            //item 2
        }
        if (keyCode == VK_3){
            //item 3
        }
        if (keyCode == VK_4){
            //item 4
        }
        if (keyCode == VK_5){
            //item 5
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == VK_W){
            upPressed = false;
        }
        if(keyCode == VK_A){
            leftPressed = false;

        }
        if(keyCode == VK_S){
            downPressed = false;

        }
        if(keyCode == VK_D){
            rightPressed = false;
        }
        if (keyCode == VK_ENTER){
            //interact
        }
    }
}
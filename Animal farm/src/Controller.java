
import  java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements KeyListener {

    private Player player;

    public void controller(){
        this.player = new Player();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == VK_W){
            this.player.move(0,-1);
        }
        if(keyCode == VK_A){
            this.player.move(-1,0);
        }
        if(keyCode == VK_S){
            this.player.move(0,1);
        }
        if(keyCode == VK_D){
            this.player.move(1,0);
        }
        if (keyCode == VK_ENTER){
            //interact
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

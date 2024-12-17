package Player;

import Player.IPlayerPos;
import World.GameScene;
import World.GameSceneHandler;
import World.ICurrentGameScene;

import java.awt.*;

/**
 *
 * handles player {@link Player} movement so the player and interaction with the gameScene {@link GameScene}
 *
 */

public class playerHandler implements IPlayerPos {

    private int x = 200;
    private int y = 200;




    /**
     * constructor initiated in Player {@link Player} with given start position
     */
    public playerHandler() {
    }



    public void updatePos(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void move(int x, int y) {
        GameScene currentGameScene = GameSceneHandler.getInstance().getActiveGameScene();
        if ((currentGameScene.getTile(this.x + x, this.y + y)).getTileType().walkable()) {
            updatePos(x, y);
        }
    }


    public Point getPos() {
        return new Point(this.x, this.y);
    }


    public void interact(int x, int y) {
        // send to tools
    }


}

package Model.Player;

import Model.World.GameScene;
import Model.World.GameSceneManager;
import Model.World.ITileAction;


import java.awt.*;

/**
 *
 * handles player {@link Player} movement so the player and interaction with the gameScene {@link GameScene}
 *
 */

public class MovementHandler {

    private int x;
    private int y;
    private Point direction;

    /**
     * constructor initiated in Model.Player {@link Player} with given start position
     */
    public MovementHandler(int x, int y) {
        this.x = x;
        this.y = y;
        direction = new Point(0, 1);
    }

    private void updatePos(int x, int y) {
        this.x += x;
        this.y += y;
    }


    public void move(int x, int y) {
        GameScene currentGameScene = GameSceneManager.getInstance().getActiveGameScene();
        if (this.x+x < 0 || this.x+x >= currentGameScene.getSize().getX() || this.y+y < 0 || this.y+y >= currentGameScene.getSize().getY()){
            return;
        }

        if ((currentGameScene.getTile(this.x + x, this.y + y)).getTileType().walkable()) {
            updatePos(x, y);
        }
    }


    public Point getPos() {
        return new Point(this.x, this.y);
    }


    public void interact(int x, int y, ITileAction tileAction) {
        GameSceneManager.getInstance().getActiveGameScene().getTile(x+direction.x, y+direction.y).interact(tileAction);
    }

    public void setDirection(int x, int y){
        direction.setLocation(x, y);
    }

}

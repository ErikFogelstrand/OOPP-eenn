import World.GameScene;
import World.Tile;

public class Adapter {
    private int[] pos;

    private GameScene gamescene;

    Adapter(int x, int y) {
        this.pos[0] = 0;
        this.pos[1] = 0;
    }

    public void updatePos(int x, int y) {
        this.pos[0] = x;
        this.pos[1] = y;
    }

    public void move(int x, int y) {
        if ((gamescene.getTile(this.pos[0] + x, this.pos[1] + y)).getTileType().walkable()) {
            updatePos(this.pos[0] + x, this.pos[1] + y);
        }
    }

    public void interact(int x, int y) {
    // inte klar
    }
}

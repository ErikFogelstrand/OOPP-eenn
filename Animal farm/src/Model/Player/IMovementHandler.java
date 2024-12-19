package Model.Player;

import java.awt.*;

public interface IMovementHandler {
    public void move(int x, int y );
    public Point getPos();
    public void interact(int x, int y);
    public void setDirection(int x, int y);
}

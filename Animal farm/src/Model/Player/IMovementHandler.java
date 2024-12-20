package Model.Player;

import java.awt.*;

// Various methods to handle something that moves and interacts
public interface IMovementHandler {
    public void move(int x, int y );
    public Point getPos();
    public void tileInteract(int x, int y);
    public void playerInteract();
    public void setDirection(int x, int y);
}

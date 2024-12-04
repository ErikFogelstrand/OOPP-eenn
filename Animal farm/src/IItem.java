// interface för alla items (allt stackable)
public interface IItem implements IUsableObject {
    int getQuantity();
    void pickup();
}

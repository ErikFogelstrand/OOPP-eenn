package UsableObjects;

// interface för alla items (allt stackable)
public interface IItem extends IUsableObject {
    int getQuantity();
    void pickUp();
}

package UsableObjects;

// Interface för både items och tools
public interface IUsableObject {
    void use();
    void pickUp(Inventory inventory); // flytta på inventory
}


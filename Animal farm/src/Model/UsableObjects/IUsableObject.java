package Model.UsableObjects;
import Model.Inventory.Inventory;
import Model.World.IAction;


// Interface för både items och tools
public interface IUsableObject {
    void use(IAction action);
    void pickUp(Inventory inventory); // flytta på inventory
}



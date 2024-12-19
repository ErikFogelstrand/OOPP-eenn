package Model.UsableObjects;
import Model.Inventory.InventoryHandler;
import Model.World.ITileAction;


// Interface för både items och tools
public interface IUsableObject {
    void use(ITileAction action);
    void pickUp(InventoryHandler inventoryHandler); // flytta på inventory
}



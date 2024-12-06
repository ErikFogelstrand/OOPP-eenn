package UsableObjects;

public class FoodItem extends Item {
    private final int nutrition;
    public FoodItem(String itemType, int quantity, String name, int nutrition) {
        super(itemType, quantity, name);
        this.nutrition = nutrition;
    }

    public int getNutrition() {
        return nutrition;
    }
    @Override
    public void use() {
        // player.eat(nutrition); måste flytta player till package
    }
    @Override
    public void pickUp() {
        //
    }
}


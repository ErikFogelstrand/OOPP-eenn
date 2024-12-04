public class FoodItem extends Item {
    private int nutrition;
    public FoodItem(String itemType, int quantity, String name, int nutrition) {
        super(itemType, quantity, name);
        this.nutrition = nutrition;
    }

    public int getNutrition() {
        return nutrition;
    }
    @Override
    public void use() {
        // plantera
    }
    @Override
    public void pickUp() {
    }
}


}

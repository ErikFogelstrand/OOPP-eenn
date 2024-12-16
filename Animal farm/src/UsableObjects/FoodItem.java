package UsableObjects;
import Player.Player;

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
    public void use(Player player) {
        if (getQuantity() > 0) {
            player.eat(nutrition);
            setQuantity((getQuantity() - 1));
        } else {
            System.out.println("Slut på " + getName() + " :(");
        }
    }
}


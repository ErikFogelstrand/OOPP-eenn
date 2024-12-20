package Model.UsableObjects;
import Model.Player.Player;

public class FoodItem extends StackableItem implements IEdible {
    private final int nutrition;

    public FoodItem(String type, int quantity,int nutrition) {
        super(type, quantity);
        this.nutrition = nutrition;
    }

    public int getNutrition() {
        return nutrition;
    }

    @Override
    public void consume(Player player) {
        player.eat(nutrition);
    }
}


package Model.UsableObjects;
import Model.Player.Player;

public class FoodItem extends StackableItem implements IEdible {
    private final int nutrition;

    public FoodItem(String type, int nutrition) {
        super(type);
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


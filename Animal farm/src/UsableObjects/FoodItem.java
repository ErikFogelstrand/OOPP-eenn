package UsableObjects;
import Player.Player;
import Player.IStates;

public class FoodItem extends Item implements IEdible {
    private final int nutrition;

    public FoodItem(String type, String name, int nutrition) {
        super(name);
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


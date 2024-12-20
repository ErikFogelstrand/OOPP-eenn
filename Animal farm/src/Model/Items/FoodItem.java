package Model.Items;
import Model.Player.Player;

public abstract class FoodItem extends StackableItem implements IEdible {
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
        if(getQuantity() <= 0){
            return;
        }
        player.eat(nutrition);
        changeQuantity(-1);
    }
}


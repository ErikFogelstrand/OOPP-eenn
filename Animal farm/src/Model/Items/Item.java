package Model.Items;


// abstrakt klass för både tools och stackableItems

public abstract class Item {
    private final String type;

    public Item(String type) {
        this.type = type;
    }
    public String getType() {
         return type;
    }
    }


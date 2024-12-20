package Model.UsableObjects;


// abstrakt klass för både tools och items

public abstract class Item {
    protected final String type;
    protected int count;

    public Item(String type) {
        this.type = type;
    }
    public String getType() {
         return type;
    }
    }


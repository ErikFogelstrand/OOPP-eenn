package Model.UsableObjects;


// abstrakt klass för både tools och items

public abstract class Item {
    public String name;

    protected Item(String name) {
        this.name = name;
    }
    public String getName() {
         return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

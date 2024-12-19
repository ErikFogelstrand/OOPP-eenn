package Model.UsableObjects;


// abstrakt klass för både tools och items

public abstract class Item {
    public static String name;  /////// change back to non static

    protected Item(String name) {
        this.name = name;
    }
    public static String getName() {
         return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

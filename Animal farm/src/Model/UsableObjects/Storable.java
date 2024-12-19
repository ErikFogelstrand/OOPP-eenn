package Model.UsableObjects;


// abstrakt klass för både tools och items

public abstract class Storable {
    public String name;

    protected Storable (String name) {
        this.name = name;
    }
    public String getName() {
         return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

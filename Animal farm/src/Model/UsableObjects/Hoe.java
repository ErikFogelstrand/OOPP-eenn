package Model.UsableObjects;

public class Hoe extends Tool {
    public Hoe(String name, String type){
        super(name, type);
    }
    @Override
    public void use() {
        System.out.println("Now you can plant :)");
    }
    @Override
    public String getType() {
        return "Hoe";
    }
}